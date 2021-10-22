package com.rd.hyxtrix.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author gaolei
 * @Date 2021/10/20 下午3:39
 * @Version 1.0
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.rd","com.redtom"})
@SpringBootApplication(scanBasePackages = {"com.rd" ,"com.redtom"})
@EnableHystrix
@EnableHystrixDashboard
public class HystrixBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(HystrixBootstrap.class, args);
    }
}
