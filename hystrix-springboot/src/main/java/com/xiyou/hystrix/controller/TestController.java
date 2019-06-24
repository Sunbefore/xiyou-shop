package com.xiyou.hystrix.controller;

import com.xiyou.hystrix.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @ResponseBody
    @GetMapping("/test/{flag}")
    public String test(@PathVariable Integer flag){
        if(flag == 1){
            // 参数是true会调用错误机制，进行服务熔断操作
            testService.testService(true);
        } else {
            testService.testService(false);
        }
        return "ok";
    }

}
