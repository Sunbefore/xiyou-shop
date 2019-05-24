package com.xiyou.admin.service;

import com.xiyou.common.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("xiyou-shop-user")
public interface UserService {

    @RequestMapping(value = "/listOutUser", method = RequestMethod.GET)
    public List<User> listOutUser();

}
