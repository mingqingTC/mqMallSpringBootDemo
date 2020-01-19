package com.mq.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 秒杀成功明细表
 */
@Getter
@Setter
@ToString
public class SuccessKilled {
    /**
     * 秒杀成功的商品id
     */
    private long secKillId;

    /**
     * 成功秒杀的用户手机号
     */
    private long userPhone;

    /**
     * 订单状态码
     */
    private int state;

    /**
     * 状态码描述
     */
    private String stateInfo;

    /**
     * 记录创建时间
     */
    private Date createTime;

    /**
     * 秒杀商品对象
     */
    private SecKill secKill;
}
