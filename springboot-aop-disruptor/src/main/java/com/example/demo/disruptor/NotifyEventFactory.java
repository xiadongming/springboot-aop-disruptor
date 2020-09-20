package com.example.demo.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @Author: xiadongming
 * @Date: 2020/9/20 16:06
 * @描述：
 */
public class NotifyEventFactory implements EventFactory<NotifyEvent> {
    @Override
    public NotifyEvent newInstance() {
        return new NotifyEvent();
    }
}
