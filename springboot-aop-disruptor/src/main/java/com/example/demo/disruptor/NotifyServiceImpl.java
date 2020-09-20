package com.example.demo.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;

/**
 * @Author: xiadongming
 * @Date: 2020/9/20 14:52
 * @描述：, InitializingBean
 */
@Service
public class NotifyServiceImpl implements  INotifyService, DisposableBean {

    @Autowired
    private Disruptor<NotifyEvent> disruptor;

    @Override
    public void sendNotify(String message) {
        RingBuffer<NotifyEvent> ringBuffer = disruptor.getRingBuffer();
        ringBuffer.publishEvent(new EventTranslatorOneArg<NotifyEvent,  String>() {
            @Override
            public void translateTo(NotifyEvent event, long sequence, String data) {
                event.setMessage(data);
            }
        }, message);
    }

    /**
     * 调用此方法的时候，才会销毁 disruptor
     * */
    @Override
    public void destroy() throws Exception {
        disruptor.shutdown();
    }

}
