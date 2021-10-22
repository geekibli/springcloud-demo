package com.rd.springcloud.api.service;

import com.rd.springcloud.server.feign.RibbonDemoFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author gaolei
 * @Date 2021/10/20 下午3:52
 * @Version 1.0
 */
@Slf4j
@Service
public class RibbonService {

    @Resource
    private RibbonDemoFeign ribbonDemoFeign;


    public void print() {
        System.err.println("ribbonDemoFeign rsp ---> {}" + ribbonDemoFeign.getDemoResponse());
    }
}
