package com.xiyou.admin.controller;

import com.xiyou.admin.service.UserService;
import com.xiyou.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有的用户
     * @param model
     * @return
     */
    @GetMapping("/listUser")
    public String listUser(Model model){
        List<User> listUser = userService.listOutUser();
        model.addAttribute("userlist", listUser);
        return "listuser";
    }
}
