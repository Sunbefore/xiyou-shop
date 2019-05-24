package com.xiyou.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Created by Administrator on 2018/7/29 0029.
 */
@Controller
public class IndexController {

    /**
     * 跳转到用户管理的首页
     * @param model
     * @return
     */
    @GetMapping(value = "/index")
    public String index(Model model){
        return "index";
    }
}
