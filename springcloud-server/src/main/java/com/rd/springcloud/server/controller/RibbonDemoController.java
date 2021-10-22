package com.rd.springcloud.server.controller;

import com.rd.springcloud.server.feign.RibbonDemoFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author gaolei
 * @Date 2021/10/20 下午3:53
 * @Version 1.0
 */
@RestController
@Slf4j
public class RibbonDemoController implements RibbonDemoFeign {

    @Override
    public String getDemoResponse() {
        log.info("sssssssss");
        String port = System.getenv("server.port");
        return port + "  |||  " + UUID.randomUUID().toString();
    }
}
