package com.mq.demo.enums;

import lombok.Getter;

/**
 * 秒杀结果状态
 */
@Getter
public enum SecKillStateEnum {
    SUCCESS(0, "秒杀成功"),
    END(-1, "秒杀结束"),
    REPEAT_KILL(-2, "重复秒杀"),
    DATA_REWRITE(-3, "数据有误"),
    INNER_ERROR(-4, "系统错误");

    /**
     * 状态码
     */
    private int state;
    /**
     * 状态码描述
     */
    private String stateInfo;

    SecKillStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /**
     * 根据状态码获取SecKillStateEnum对象
     *
     * @param state 状态码
     * @return SecKillStateEnum对象
     */
    public static SecKillStateEnum stateOf(int state) {
        for (SecKillStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state)
                return stateEnum;
        }
        return null;
    }

    /**
     * 根据状态值获取SecKillStateEnum对象
     *
     * @param stateInfo 状态值
     * @return SecKillStateEnum对象
     */
    public static SecKillStateEnum stateOf(String stateInfo) {
        for (SecKillStateEnum stateEnum : values()) {
            if (stateEnum.getStateInfo().equals(stateInfo))
                return stateEnum;
        }
        return null;
    }
}
