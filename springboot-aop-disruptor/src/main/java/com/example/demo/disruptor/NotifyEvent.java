package com.example.demo.disruptor;

/**
 * @Author: xiadongming
 * @Date: 2020/9/20 14:33
 * @描述：
 */
public class NotifyEvent {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "message='" + message + '\'' +
                '}';
    }
}
