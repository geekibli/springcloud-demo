package com.rd.hystrix.demo;

import com.rd.hyxtrix.demo.service.QueryOrderIdCommand;
import org.junit.Test;

/**
 * @Author gaolei
 * @Date 2021/10/21 下午5:21
 * @Version 1.0
 */
public class DemoTest {

    @Test
    public void test() {
        Integer execute = new QueryOrderIdCommand().execute();
        System.out.println("execute rsp -> {}" + execute);
    }
}
