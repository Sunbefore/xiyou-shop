package com.xiyou.pindao.service;

import com.xiyou.common.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("xiyou-shop-user")
public interface UserService {

    @RequestMapping(value = "/listOutUser", method = RequestMethod.GET)
    public List<User> listOutUser();


    /**
     * 注册用户信息
     */
    @RequestMapping(value = "/userOutRegister", method = RequestMethod.POST)
    // 加上@RequestBody表示的是传过去的是json
    // 复杂对象的传递都需要加上@RequestBody
    public void userRegister(@RequestBody User user);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @RequestMapping(value = "/findByUserName/{username}", method = RequestMethod.GET)
    public User findByUserName(@PathVariable(value = "username") String username);
}
