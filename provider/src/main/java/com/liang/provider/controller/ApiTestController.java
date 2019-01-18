package com.liang.provider.controller;

import com.liang.TestApi;
import com.liang.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@RestController
public class ApiTestController implements TestApi {


    @Override
    public String test(@RequestParam("name") String name, HttpServletRequest request) {

        System.out.println(request.getHeader("auth"));
        return name;
    }

    @Override
    public String test2(@RequestBody User user, @RequestParam("auth") String auth) {
        return user.getName()+auth;
    }
}


