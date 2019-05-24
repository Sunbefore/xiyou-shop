package com.xiyou.pindao.controller;

import com.xiyou.common.model.User;
import com.xiyou.pindao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    /**
     * 跳转到指定的注册页面
     * @return
     */
    @GetMapping(value = "/toUserRegister")
    public String toUserRegister(){
        // 跳转到resources下的templates下的指定文件下userregister.html
        return "userregister";
    }

    /**
     * 注册用户信息
     */
    @PostMapping("/userRegister")
    public void userRegister(User user){
        // 因为设置了<selectKey>标签的原因所以插入成功后，user的属性中是存在id的值的
        userService.userRegister(user);
    }


    /**
     * 跳转到用户登录页面
     */
    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 用户的登录显示
     * @return
     */
    @PostMapping("/login")
    public String login(String account, String password, HttpServletRequest req){
        User user = userService.findByUserName(account);
        // 表示没有找到，无该对象
        if(user == null){
            System.out.println("无此用户");
        }else{
            if(user.getPasswordencrypt().equals(password)){
                // 密码正确，表示查询出了账号, 存放到session中
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
            }else{
                // 表示密码错误
                System.out.println("密码错误");
            }
        }
        return "list";
    }
}
