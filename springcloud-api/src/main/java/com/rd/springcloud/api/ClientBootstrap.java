package com.rd.springcloud.api;

import com.rd.springcloud.api.config.RibbonGlobalLoadBalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @Author gaolei
 * @Date 2021/10/20 下午3:39
 * @Version 1.0
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.rd","com.redtom"})
@SpringBootApplication(scanBasePackages = {"com.rd","com.redtom"})
//@RibbonClient(name = "springcloud-client", configuration = RibbonGlobalLoadBalanceConfig.class)
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION)})
public class ClientBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ClientBootstrap.class, args);
    }

//    @Bean
//    public ConsulClient getClinet(){
//        return new ConsulClient();
//    }

}
