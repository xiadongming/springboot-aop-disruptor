package com.example.demo.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * @Author: xiadongming
 * @Date: 2020/9/20 14:41
 * @描述：
 */
public class NotifyEventHandler implements EventHandler<NotifyEvent>, WorkHandler<NotifyEvent> {
    @Override
    public void onEvent(NotifyEvent notifyEvent, long l, boolean b) throws Exception {
        System.out.println("接收到消息");
        this.onEvent(notifyEvent);
    }

    @Override
    public void onEvent(NotifyEvent notifyEvent) throws Exception {
        System.out.println("message=  "+notifyEvent.getMessage());
    }
}
