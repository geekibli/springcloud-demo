package com.rd.springcloud.api.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author gaolei
 * @Date 2021/10/20 下午5:37
 * @Version 1.0
 */
@Configuration
@Component
public class RibbonGlobalLoadBalanceConfig {
    /**
     * 随机原则
     * @return
     */
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}