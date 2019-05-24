package com.xiyou.xiyoushopuser.controller;

import com.xiyou.common.model.User;
import com.xiyou.xiyoushopuser.service.UserService;
import com.xiyou.xiyoushopuser.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用于给外部微服务调用提供接口
 */
@RestController
public class UserOutController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有的用户
     * @return
     */
    @GetMapping("/listOutUser")
    public List<User> listOutUser(){
        UserVo userVo = new UserVo();
        List<User> userList = userService.queryUserByVo(userVo);
        return userList;
    }

    /**
     * 注册用户信息
     */
    @PostMapping("/userOutRegister")
    // @RequestBody的作用是接收的参数是一个json 将其转为user对象，复杂对象的时候传递过来是json格式
    public void userRegister(@RequestBody User user){
        // 因为设置了<selectKey>标签的原因所以插入成功后，user的属性中是存在id的值的
        userService.insertUserInfo(user);
        System.out.println(user);
    }

    /**
     * 用户展现页面，传入用户id
     * @return
     */
    @GetMapping("/findByUserName/{username}")
    public User findByUserName(@PathVariable String username){
        User user = userService.findByUserName(username);
        return user;
    }
}
