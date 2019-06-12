package com.xiyou.product.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@FeignClient(value = "xiyou-shop-redisTest")
public interface RedisService {

    /**
     * 根据key得到value
     * @param key
     * @return
     */
    @RequestMapping(value = "/getKey/{key}",method = RequestMethod.GET)
    public String getKey(@PathVariable("key") String key);

    /**
     * 将key，value存入redis中
     * @param key
     * @param value
     */
    @RequestMapping(value = "/setKey/{key}/{value}",method = RequestMethod.GET)
    public void setKey(@PathVariable("key") String key, @PathVariable("value") String value);

    /**
     * 得到所有的key对应的value
     * @return
     */
    @RequestMapping(value = "/getAllProductKeys",method = RequestMethod.POST)
    public Set<String> getAllProductKeys();

}
