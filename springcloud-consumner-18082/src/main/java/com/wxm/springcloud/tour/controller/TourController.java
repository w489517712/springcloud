package com.wxm.springcloud.tour.controller;

import com.wxm.springcloud.sys.controller.SysController;
import com.wxm.springcloud.sys.po.Result;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/4/5.
 */
@RestController
@RequestMapping("/tour")
public class TourController extends SysController{

    @PostMapping("/queryTourList")
    @ResponseBody
    public Result queryList(@RequestBody Map map){
        if(map  == null){
            map = new HashMap();
        }
        return doPost(apiUrl+"/tour/queryList", map);

    }


}
