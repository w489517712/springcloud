package com.wxm.springcloud.tour.controller;

import com.alibaba.fastjson.JSON;
import com.wxm.springcloud.sys.controller.SysController;
import com.wxm.springcloud.sys.po.Result;
import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody Map map) {
        if (map == null) {
            map = new HashMap();
        }
        System.out.println(JSON.toJSONString(map));
        return doPost(apiUrl+"/tour/register", map);
    }



    @PostMapping("/queryTourList")//酒店查询
    @ResponseBody
    public Result queryList(@RequestBody Map map){
        if(map  == null){
            map = new HashMap();
        }
        return doPost(apiUrl+"/tour/queryList", map);

    }

    @PostMapping("/queryTicketList")//机票查询
    @ResponseBody
    public Result queryList1(@RequestBody Map map){
        if(map  == null){
            map = new HashMap();
        }
        return doPost(apiUrl+"/tour/queryTicketList", map);

    }



    @PostMapping("/queryOrderList")//订单查询
    @ResponseBody
    public Result queryOrderList(@RequestBody Map map){
        if(map  == null){
            map = new HashMap();
        }
        return doPost(apiUrl+"/tour/queryOrderList", map);

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
