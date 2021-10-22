package com.rd.springcloud.api.controller;

import com.ecwid.consul.v1.ConsulClient;
import com.rd.springcloud.api.service.RibbonService;
import com.rd.hyxtrix.demo.controller.HystrixFeignApi;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author gaolei
 * @Date 2021/10/20 下午3:51
 * @Version 1.0
 */
@RestController
public class RibbonApiController {

    @Resource
    private RibbonService ribbonService;
    @Resource
    private ConsulClient consulClient;
    @Resource
    private HystrixFeignApi hystrixFeignApi;
    @Resource
    private ConsulDiscoveryProperties configurationProperties;

    @GetMapping("/v1/print")
    public void print() {
        configurationProperties.setServiceName("springcloud-server");
        ConsulDiscoveryClient discoveryClient = new ConsulDiscoveryClient(consulClient, configurationProperties);
        List<ServiceInstance> allInstances = discoveryClient.getAllInstances();
        System.err.println(" allInstances size" + allInstances.size());
        ribbonService.print();
    }


    @GetMapping("/hello/test")
    public String testHystrix() {
        return hystrixFeignApi.sayHello();
    }

}
