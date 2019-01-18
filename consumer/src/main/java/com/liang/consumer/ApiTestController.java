package com.liang.consumer;

import com.liang.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@RestController
@RequestMapping("/apiTestController")
public class ApiTestController {
    @Autowired
    private ApiTestFeignClient apiTestFeignClient;

    @PostMapping(value = "/testController",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String test(@RequestParam("name") String name, HttpServletRequest request){
        return apiTestFeignClient.test(name,request);
    }

    /**
     * 多参数演示
     * @param user
     * @param request
     * @return
     */
    @PostMapping(value = "/test2Controller",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String test2(@RequestBody User user,HttpServletRequest request){

        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(request.getHeader("auth"));
        return apiTestFeignClient.test2(user,request.getHeader("auth"));
        //return "aaa";
    }
}

