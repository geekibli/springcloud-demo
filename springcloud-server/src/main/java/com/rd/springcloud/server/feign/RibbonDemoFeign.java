package com.rd.springcloud.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author gaolei
 * @Date 2021/10/20 下午3:48
 * @Version 1.0
 */
@FeignClient("springcloud-server")
public interface RibbonDemoFeign {

    @GetMapping("/v1/ribbon/demo")
    String getDemoResponse();

}
