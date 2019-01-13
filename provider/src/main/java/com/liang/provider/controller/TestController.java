package com.liang.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/provider")
public class TestController {

    @RequestMapping("/test")
    public String testRest(HttpServletRequest request){

        System.out.println("被远程访问了");

        String token = request.getHeader("access-token");

        System.out.println("provider 中获取的token为"+token);

        return "aaaa";
    }
}
