package com.example.demo.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

/**
 * @Author: xiadongming
 * @Date: 2020/9/20 15:28
 * @描述：
 */
@Configuration
public class DisruptorConfig {

    private static final int RING_BUFFER_SIZE = 1024 * 1024;

    @Bean
    public Disruptor<NotifyEvent> disruptor(){
        Disruptor<NotifyEvent> disruptor = null;

        disruptor = new Disruptor<NotifyEvent>(new NotifyEventFactory(),RING_BUFFER_SIZE, Executors.defaultThreadFactory(),
                                                ProducerType.SINGLE,new BlockingWaitStrategy());
        disruptor.setDefaultExceptionHandler(new NotifyEventHandlerException());
        disruptor.handleEventsWith(new NotifyEventHandler());
        disruptor.start();
        return  disruptor;
    }

}
