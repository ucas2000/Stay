package org.example.common;

/**
 * 全局自定义异常
 */
public class CustomException extends RuntimeException{
    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }}