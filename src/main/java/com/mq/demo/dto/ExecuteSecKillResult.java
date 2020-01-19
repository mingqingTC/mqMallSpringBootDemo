package com.mq.demo.dto;

import com.mq.demo.entity.SuccessKilled;
import com.mq.demo.enums.SecKillStateEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 执行秒杀接口调用结果返回的dto
 */
@Getter
@Setter
@ToString
public class ExecuteSecKillResult {

    //秒杀商品id
    private long secKillId;

    //秒杀执行结果状态码
    private int state;

    //状态码描述
    private String stateInfo;

    //执行秒杀成功时的成功秒杀对象
    private SuccessKilled successKilled;

    //执行秒杀成功时调用的构造函数
    public ExecuteSecKillResult(long secKillId, SecKillStateEnum stateEnum, SuccessKilled successKilled) {
        this.secKillId = secKillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    //执行秒杀失败时调用的构造函数
    public ExecuteSecKillResult(long secKillId, SecKillStateEnum stateEnum) {
        this.secKillId = secKillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }
}
