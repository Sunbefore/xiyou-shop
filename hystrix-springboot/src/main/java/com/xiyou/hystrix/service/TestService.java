package com.xiyou.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @HystrixCommand(fallbackMethod = "testFailMethod")
    public String testService(boolean flag){
        if (flag) {
            // 默认的hystrix的超时时间是2000ms
            int i = 1/0;
        }
        System.out.println("Hello World, we have no error");
        return "ok";
    }

    /**
     * 这个方法是testService的错误熔断的方法
     * 注意，其返回值和参数类型必须是相同的
     * @param flag
     * @param throwable 自动抓取到的异常
     * @return
     */
    public String testFailMethod(boolean flag, Throwable throwable){
        System.out.println("这里已经出错了");
        System.out.println(throwable.getMessage());
        return "error";
    }

}
