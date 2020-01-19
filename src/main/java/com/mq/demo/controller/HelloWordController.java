package com.mq.demo.controller;

import com.mq.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloWordController {

    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "hello");
        return map;
    }

    @GetMapping("/jsp")
    public String jsp(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("张三", 21));
        users.add(new User("李四", 22));
        model.addAttribute("users", users);
        model.addAttribute("msg", "test");
        return "index";
    }

    @GetMapping("/ftl")
    public String ftl(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("王五", 21));
        users.add(new User("赵六", 22));
        model.addAttribute("users", users);
        model.addAttribute("msg", "test");
        return "template";
    }

    //freemarker语法页
    @GetMapping(path = "/grammar")
    public String grammar(HttpServletRequest request, Model model) {
        model.addAttribute("basePath", ControllerUtil.basePath(request));
        model.addAttribute("lists", new ArrayList<Integer>());
        return "grammar";
    }
}
