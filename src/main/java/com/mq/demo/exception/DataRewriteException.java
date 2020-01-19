package com.mq.demo.exception;

public class DataRewriteException extends SecKillException {

    public DataRewriteException(String message) {
        super(message);
    }

    public DataRewriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
