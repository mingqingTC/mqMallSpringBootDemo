package com.mq.demo.controller;

import com.mq.demo.dto.ExecuteSecKillResult;
import com.mq.demo.dto.ExposeEntranceResult;
import com.mq.demo.dto.SecKillResult;
import com.mq.demo.entity.SecKill;
import com.mq.demo.enums.SecKillStateEnum;
import com.mq.demo.exception.DataRewriteException;
import com.mq.demo.exception.RepeatKillException;
import com.mq.demo.exception.SecKillEndException;
import com.mq.demo.exception.SecKillException;
import com.mq.demo.service.SecKillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/secKill")
public class SecKillController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecKillService secKillService;

    //秒杀商品列表页
    //  GET /secKill/list/{offset}/{limit}
    @GetMapping(path = "/list/{offset}/{limit}")
    public String list(@PathVariable("offset") int offset, @PathVariable("limit") int limit, HttpServletRequest request, Model model) {
        List<SecKill> secKillList = secKillService.querySecKills(offset, limit);
        if (secKillList == null)
            secKillList = new ArrayList<>();
        model.addAttribute("basePath", ControllerUtil.basePath(request));
        model.addAttribute("secKillList", secKillList);
        return "list";
    }

    //秒杀商品详情页
    // GET /secKill/detail/{secKillId}
    @GetMapping(path = "/detail/{secKillId}")
    public String detail(@PathVariable("secKillId") long secKillId, HttpServletRequest request, Model model) {
        try {
            ExposeEntranceResult exposeEntranceResult = secKillService.exposeSecKillEntrance(secKillId);
            if (exposeEntranceResult.getSecKill() == null) {
                logger.error("没有秒杀商品");
                return "redirect:/secKill/list/0/10";
            }
            model.addAttribute("basePath", ControllerUtil.basePath(request));
            model.addAttribute("exposeEntranceResult", exposeEntranceResult);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "redirect:/secKill/list/0/10";
        }
        return "detail";
    }

    //获得系统当前时间
    // GET /secKill/systemCurrentTime
    @GetMapping(path = "/systemCurrentTime", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SecKillResult<Long> systemCurrentTime() {
        return new SecKillResult<>(true, new Date().getTime());
    }

    //判断是否要暴露秒杀入口
    // GET /secKill/exposer/{secKillId}
    @GetMapping(path = "/exposer/{secKillId}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SecKillResult<ExposeEntranceResult> exposer(@PathVariable("secKillId") long secKillId) {
        ExposeEntranceResult exposeEntranceResult = secKillService.exposeSecKillEntrance(secKillId);
        return new SecKillResult<>(true, exposeEntranceResult);
    }

    //执行秒杀操作
    // POST /secKill/execution/{secKillId}/{md5}
    @PostMapping(path = "/execution/{secKillId}/{md5}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SecKillResult<ExecuteSecKillResult> execution(@PathVariable("secKillId") long secKillId,
                                                         @PathVariable("md5") String md5,
                                                         @CookieValue(value = "userPhone", required = false) Long userPhone) {
        if (userPhone == null) {
            return new SecKillResult<>(false, "未注册");
        }
        ExecuteSecKillResult executeSecKillResult;
        try {
            executeSecKillResult = secKillService.executeSecKill(secKillId, userPhone, md5);
            return new SecKillResult<>(true, executeSecKillResult);
        } catch (DataRewriteException | RepeatKillException | SecKillEndException e) {
            SecKillStateEnum stateEnum = SecKillStateEnum.stateOf(e.getMessage());
            if (stateEnum == null) {
                logger.error("未能找到SecKillStateEnum对象,程序有误");
                return new SecKillResult<>(false, "应用程序错误");
            }
            return new SecKillResult<>(true, new ExecuteSecKillResult(secKillId, stateEnum));
        } catch (SecKillException e) {
            logger.error(e.getMessage());
            return new SecKillResult<>(false, "应用程序错误");
        }
    }

}
