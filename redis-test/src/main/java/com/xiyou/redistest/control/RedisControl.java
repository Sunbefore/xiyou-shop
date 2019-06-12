package com.xiyou.redistest.control;

import com.xiyou.redistest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by Administrator on 2018/9/9 0009.
 */
@RestController
public class RedisControl {

    @Autowired
    RedisService redisService;

    /**
     * 根据key得到value
     * @param key
     * @return
     */
    @RequestMapping(value = "/getKey/{key}",method = RequestMethod.GET)
    public String getKey(@PathVariable("key") String key) {
        String reuslt = redisService.getStr(key);
        return reuslt;
    }

    /**
     * 将key，value存入redis中
     * @param key
     * @param value
     */
    @RequestMapping(value = "/setKey/{key}/{value}",method = RequestMethod.GET)
    public void setKey(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisService.setStr(key,value);
    }

    /**
     * 得到所有的key对应的value
     * @return
     */
    @RequestMapping(value = "/getAllProductKeys",method = RequestMethod.POST)
    public Set<String> getAllProductKeys() {
        Set<String> set = redisService.getAllkeys();
        return set;
    }
}
