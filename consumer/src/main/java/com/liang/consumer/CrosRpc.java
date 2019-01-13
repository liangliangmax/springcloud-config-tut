package com.liang.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "provider")
public interface CrosRpc {

    @RequestMapping("/provider/test")
    String crosTest();
}
