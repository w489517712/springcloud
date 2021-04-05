package com.wxm.springcloud.test.controller;

import com.wxm.springcloud.sys.controller.SysController;
import com.wxm.springcloud.sys.po.Result;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 高等数学 on 2021/3/31.
 */

@RestController
@RequestMapping("/test")
public class TestController extends SysController{

    @RequestMapping("/save")
    public Result save(){
        MultiValueMap<String, Object> params = new LinkedMultiValueMap();
        params.add("name","wxm");
        params.add("age","12");
        return doPost(apiUrl+"/test/save", params);
    }

    @RequestMapping("/queryList")
    public Result queryList(){
        MultiValueMap<String, Object> params = new LinkedMultiValueMap();
        params.add("id", 3);
        return doPost(apiUrl+"/test/queryList", params);
    }


}
