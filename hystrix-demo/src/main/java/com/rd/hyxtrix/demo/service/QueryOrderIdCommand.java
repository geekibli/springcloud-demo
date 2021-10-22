package com.rd.hyxtrix.demo.service;

import com.netflix.hystrix.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Author gaolei
 * @Date 2021/10/21 下午5:18
 * @Version 1.0
 */
@Service
public class QueryOrderIdCommand extends HystrixCommand<Integer> {


    public QueryOrderIdCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("orderService"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("queryByOrderId"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerRequestVolumeThreshold(10)//至少有10个请求，熔断器才进行错误率的计算
                        .withCircuitBreakerSleepWindowInMilliseconds(5000)//熔断器中断请求5秒后会进入半打开状态,放部分流量过去重试
                        .withCircuitBreakerErrorThresholdPercentage(50)//错误率达到50开启熔断保护
                        .withExecutionTimeoutEnabled(true))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties
                        .Setter().withCoreSize(10)));
    }



    @Override
    protected Integer run() {
        return new Random().nextInt(100);
    }

    @Override
    protected Integer getFallback() {
        return -1;
    }

}
