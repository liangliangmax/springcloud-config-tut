package com.liang.consumer;

import com.liang.TestApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("provider")
public interface ApiTestFeignClient extends TestApi {
}
