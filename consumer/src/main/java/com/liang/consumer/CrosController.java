package com.liang.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/consumer")
public class CrosController {

    @Autowired
    private CrosRpc crosRpc;


    @RequestMapping("/testCros")
    public String testCros(HttpServletRequest request){

        String token = request.getHeader("access-token");

        System.out.println("token-----====="+token);

        return crosRpc.crosTest();
    }
}
