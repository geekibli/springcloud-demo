package com.rd.sentienl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author gaolei
 * @Date 2021/10/20 下午3:39
 * @Version 1.0
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.rd"})
@SpringBootApplication(scanBasePackages = {"com.rd"})
public class SentinelBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SentinelBootstrap.class, args);
    }
}
