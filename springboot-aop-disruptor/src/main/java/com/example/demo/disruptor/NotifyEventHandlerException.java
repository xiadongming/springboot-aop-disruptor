package com.example.demo.disruptor;

import com.lmax.disruptor.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: xiadongming
 * @Date: 2020/9/20 14:50
 * @描述：
 */
public class NotifyEventHandlerException implements ExceptionHandler {

    final Logger logger = LoggerFactory.getLogger(NotifyEventHandlerException.class);

    @Override
    public void handleEventException(Throwable throwable, long sequence, Object event) {
        throwable.fillInStackTrace();
        logger.error("process data error sequence ==[{}] event==[{}] ,ex ==[{}]", sequence, event.toString(), throwable.getMessage());
    }

    @Override
    public void handleOnStartException(Throwable throwable) {
        logger.error("start disruptor error ==[{}]!", throwable.getMessage());
    }

    @Override
    public void handleOnShutdownException(Throwable throwable) {
        logger.error("shutdown disruptor error ==[{}]!", throwable.getMessage());
    }

}
