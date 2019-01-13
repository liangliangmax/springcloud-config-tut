package com.liang.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logger")
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/log")
    public String log(){

        logger.trace("trace");

        logger.debug("debug");

        logger.info("info");

        logger.error("error");

        logger.warn("warn");
        return "aaaa";

    }
}
