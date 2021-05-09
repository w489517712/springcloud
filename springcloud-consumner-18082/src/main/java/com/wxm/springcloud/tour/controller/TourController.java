package com.wxm.springcloud.tour.controller;

import com.wxm.springcloud.sys.controller.SysController;
import com.wxm.springcloud.sys.po.Result;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody Map map,HttpServletRequest request,HttpServletResponse response){
        if(map  == null){
            map = new HashMap();
        }

        Result result = doPost(apiUrl + "/tour/login", map);
//        String code = result.get("code").toString();
//        if(code.equals("1")){
//            String token = result.get("token").toString();
//            Cookie cookie = new Cookie("token",token);
//            cookie.setMaxAge(1800);
//            response.addCookie(cookie);
//
//        }
        return result;

    }

}
