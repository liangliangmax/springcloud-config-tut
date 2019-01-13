package com.liang.provider.controller;

import com.liang.provider.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private MyConfig myConfig;

    @RequestMapping("/get")
    public String getConfig(){

        return myConfig.getTomcat().getValue();
    }
}
