package com.wxm.springcloud.sys.controller;

import com.wxm.springcloud.sys.po.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;

/**
 * Created by 高等数学 on 2021/4/1.
 */
@Component
public class SysController {

    //@Value("springcloud.api.url")
    @Value("${springcloud.api.url}")
    public String apiUrl;
    @Autowired
    private RestTemplate restTemplate;


    public Result doPost(String url,Map param){

        MultiValueMap<String, Object> stringObjectMultiValueMap = map2MultiValueMap(param);


        return restTemplate.postForObject(url, stringObjectMultiValueMap, Result.class);

    }


    private MultiValueMap<String, Object> map2MultiValueMap(Map map ){

        MultiValueMap<String, Object> params = new LinkedMultiValueMap();

        for(Object key:map.keySet()){
            params.add(key.toString(),map.get(key));
        }

        return params;
    }



}
