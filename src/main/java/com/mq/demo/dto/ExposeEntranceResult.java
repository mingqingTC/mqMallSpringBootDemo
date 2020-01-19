package com.mq.demo.dto;

import com.mq.demo.entity.SecKill;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 暴露秒杀接口调用结果返回的dto
 */
@Getter
@Setter
@ToString
public class ExposeEntranceResult {

    //秒杀商品id
    private long secKillId;

    //判断是否暴露入口
    private boolean exposed;

    //md5加密字符串
    private String md5 = "";

    //系统当前时间
    private long systemCurrentTime;

    //秒杀开始时间
    private long startTime;

    //秒杀结束时间
    private long endTime;

    //秒杀的商品信息
    private SecKill secKill;

    //秒杀入口暴露时使用的构造函数
    public ExposeEntranceResult(long secKillId, boolean exposed, String md5, SecKill secKill) {
        this.secKillId = secKillId;
        this.exposed = exposed;
        this.md5 = md5;
        this.secKill = secKill;
    }

    //秒杀入口不暴露且存在秒杀商品时使用的构造函数
    public ExposeEntranceResult(long secKillId, boolean exposed, long systemCurrentTime, long startTime, long endTime, SecKill secKill) {
        this.secKillId = secKillId;
        this.exposed = exposed;
        this.systemCurrentTime = systemCurrentTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.secKill = secKill;
    }

    //秒杀入口不暴露且不存在秒杀商品时使用的构造函数
    public ExposeEntranceResult(long secKillId, boolean exposed, SecKill secKill) {
        this.secKillId = secKillId;
        this.exposed = exposed;
        this.secKill = secKill;
    }
}
