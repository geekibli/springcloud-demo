package com.rd.hyxtrix.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author gaolei
 * @Date 2021/10/22 上午10:43
 * @Version 1.0
 */
@Service
@Slf4j
public class HelloService {

    @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String doSay() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("doSay success!");
        return "Welcome Hystrix";
    }

    private String fallback_hello() {
        log.info("调用了fallback_hello方法。。。。");
        return "Request fails. It takes long time to response";
    }
}
