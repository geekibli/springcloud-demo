package com.rd.hyxtrix.demo.controller;

import com.rd.hyxtrix.demo.service.HelloService;
import com.rd.hyxtrix.demo.service.QueryOrderIdCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author gaolei
 * @Date 2021/10/21 下午5:24
 * @Version 1.0
 */
@RestController
public class HystrixController implements HystrixFeignApi {

    @Resource
    private QueryOrderIdCommand queryOrderIdCommand;
    @Resource
    private HelloService helloService;

    @GetMapping("/hystrix/start")
    public Integer quickStart() {
        Integer execute = queryOrderIdCommand.execute();
        return execute;
    }


//    @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    })

    @Override
    public String sayHello() {
        return helloService.doSay();
    }
}
