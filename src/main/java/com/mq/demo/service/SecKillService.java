package com.mq.demo.service;

import com.mq.demo.dto.ExecuteSecKillResult;
import com.mq.demo.dto.ExposeEntranceResult;
import com.mq.demo.entity.SecKill;
import com.mq.demo.exception.SecKillException;

import java.util.List;

//在使用者的角度上设计接口
//SpringIOC配置: 第三方类库和一次性配置(声明式事务)使用xml 对自定义Dao, Service,Controller等使用注解
public interface SecKillService {

    /**
     * 获得系统当前时间
     *
     * @return 返回以毫秒为单位的时间戳
     */
    Long querySystemCurrentTime();

    /**
     * 获取列表页显示需要的秒杀商品数据
     *
     * @param offset 开始项,从0开始
     * @param limit  数据个数
     * @return 秒杀商品列表
     */
    List<SecKill> querySecKills(int offset, int limit);

    /**
     * 获取单个秒杀商品数据
     *
     * @param secKillId 商品id
     * @return 秒杀商品数据
     */
    SecKill queryOneSecKill(long secKillId);

    /**
     * 判断是否暴露秒杀入口
     *
     * @param secKillId 秒杀商品id
     * @return 返回判断结果
     */
    ExposeEntranceResult exposeSecKillEntrance(long secKillId);

    /**
     * 处理秒杀
     *
     * @param secKillId 秒杀商品id
     * @param userPhone 秒杀用户手机号
     * @param md5       md5加密字符串
     * @return 处理结果
     * @throws SecKillException 自定义秒杀异常: 系统错误
     */
    ExecuteSecKillResult executeSecKill(long secKillId, long userPhone, String md5) throws SecKillException;

}
