package com.example.demo.disruptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: xiadongming
 * @Date: 2020/9/20 14:56
 * @描述：
 */
@RestController
@RequestMapping("/dev")
public class DisruptorController {
    final Logger logger = LoggerFactory.getLogger(DisruptorController.class);

    @Autowired
    private INotifyService notifyService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String testLog() {
        logger.info("=============");
        notifyService.sendNotify("Hello,World!");
        return "hello,world";
    }

}
