package com.liang.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CrosController {


    @RequestMapping("/cros")
    public String crosTest(){

        return "test";
    }
}
