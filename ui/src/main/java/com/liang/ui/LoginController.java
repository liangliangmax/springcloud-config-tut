package com.liang.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping("/toLogin")
    public String login(){
        return "login";
    }
}
