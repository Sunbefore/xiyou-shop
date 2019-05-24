package com.xiyou.xiyoushopuser.controller;


import com.xiyou.common.model.User;
import com.xiyou.xiyoushopuser.service.UserService;
import com.xiyou.xiyoushopuser.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 测试方法，不考虑
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public User getUserInfo(){
        User user = userService.findUserInfo();
        if (user != null){
            System.out.println("user name :" + user.getName());
        }
        return user;
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
        userService.insertUserInfo(user);
        System.out.println(user);
    }


    /**
     * 跳转到更新用户界面
     * @param id:用户的id，根据id查询出具体的值，并进行回显，判断是否更新
     */
    @GetMapping(value = "/toUpdateUser/{id}")
    public String toUpdateUser(@PathVariable(value = "id") Integer id, Model model){
        User user = userService.findByUserId(id);
        // model用来给前端带值，跳转到的界面直接可以回显值, 将id对应的数据进行回显
        model.addAttribute("user", user);
        return "userupdate";
    }


    /**
     * 更新用户操作
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/updateUser")
    public void updateUser(User user){
        userService.updateUser(user);
    }

    /**
     * 用户展现页面，传入用户id
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/findByUserId/{id}")
    public String findByUserId(@PathVariable Integer id, Model model){
        User user = userService.findByUserId(id);
        model.addAttribute("user", user);
        return "userview";
    }

    /**
     * 查询所有用户的信息，根据userVO
     * @param
     * @return
     */
    @GetMapping("/queryUserByVo")
    public String queryUserByVo(Model model){
        UserVo userVo = new UserVo();
        List<User> users = userService.queryUserByVo(userVo);
        model.addAttribute("listuser", users);
        return "userlist";
    }

    /**
     * 根据指定id删除用户
     * @param id
     */
    @GetMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
    }
}
