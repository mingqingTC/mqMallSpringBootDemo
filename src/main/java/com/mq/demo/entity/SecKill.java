package com.mq.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 秒杀库存表
 */
@Getter
@Setter
@ToString
public class SecKill {
    /**
     * 商品库存id
     */
    private long secKillId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 库存数量
     */
    private int number;

    /**
     * 秒杀开始时间
     */
    private Date startTime;

    /**
     * 秒杀结束时间
     */
    private Date endTime;

    /**
     * 数据创建时间
     */
    private Date createTime;
}
