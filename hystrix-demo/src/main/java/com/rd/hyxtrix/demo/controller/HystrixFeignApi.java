package com.rd.hyxtrix.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author gaolei
 * @Date 2021/10/22 上午10:40
 * @Version 1.0
 */
@FeignClient("hystrix-demo")
public interface HystrixFeignApi {

    @RequestMapping(value = "/hello")
    String sayHello();


}
