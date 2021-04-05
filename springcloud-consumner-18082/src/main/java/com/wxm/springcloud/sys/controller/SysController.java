package com.wxm.springcloud.sys.controller;

import com.wxm.springcloud.sys.po.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by 高等数学 on 2021/4/1.
 */
@Component
public class SysController {

    @Value("springcloud.api.url")
    public String apiUrl;
    @Autowired
    private RestTemplate restTemplate;


    public Result doPost(String url,Object param){

        return restTemplate.postForObject(url, param, Result.class);

    }



}
