package com.liang.gateway;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping(value = "/login")
    public String login(Map map, HttpServletRequest request, HttpServletResponse response){

        System.out.println(map);

        response.setHeader("access-token","1234567890");

        return "login";

    }
}
