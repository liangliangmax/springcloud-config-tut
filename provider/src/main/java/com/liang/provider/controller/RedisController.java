package com.liang.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
@RefreshScope
public class RedisController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Value("${redis.mark}")
    private String mark;

    @RequestMapping("/set")
    public String test(){

        redisTemplate.opsForValue().set("aaaa",mark);
        return "aaaa";
    }


    @RequestMapping("/get")
    public String get(){

        String aaa =  (String) redisTemplate.opsForValue().get("aaaa");
        System.out.println(aaa);
        return "bbbb";
    }
}
