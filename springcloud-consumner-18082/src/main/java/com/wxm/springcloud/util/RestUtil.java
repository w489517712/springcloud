package com.wxm.springcloud.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 高等数学 on 2021/3/31.
 */
@Component
public class RestUtil {

    @Autowired
    private RestTemplate restTemplate;



    public  <T> T doPost(String serviceName,String url,Object obj,Class<T> clazz){

        T t = restTemplate.postForObject(serviceName + url, null, clazz, obj);


        return  t;

    }




}
