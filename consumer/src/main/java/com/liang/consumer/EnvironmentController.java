package com.liang.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/environment")
@RefreshScope
public class EnvironmentController {

    @Value("${test.mark}")
    private String mark;

    @RequestMapping("/mark")
    public String testEnvironment(){

        return mark;

    }
}
