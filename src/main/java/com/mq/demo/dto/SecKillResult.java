package com.mq.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SecKillResult<T> {

    //判断是否获取数据成功
    private boolean success;

    //数据获取成功时存放的数据
    private T data;

    //数据获取失败时存放错误信息
    private String errorInfo;

    public SecKillResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public SecKillResult(boolean success, String errorInfo) {
        this.success = success;
        this.errorInfo = errorInfo;
    }
}
