package com.wxm.springcloud.tour.controller;

import com.alibaba.fastjson.JSON;
import com.wxm.springcloud.sys.po.Result;
import com.wxm.springcloud.test.po.Test;
import com.wxm.springcloud.tour.po.Tour;
import com.wxm.springcloud.tour.po.User;
import com.wxm.springcloud.tour.service.TourService;
import com.wxm.springcloud.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 高等数学 on 2021/4/5.
 */
@RestController
@RequestMapping("tour")
public class TourController {

    @Autowired
    private TourService tourService;

    @PostMapping("/queryList")
    @ResponseBody
    public Result queryList(@RequestParam Map map){
        if(map  == null){
            map = new HashMap();
        }

        System.out.println(JSON.toJSONString(map));
        PageUtil.getQuery(map);

        //需要返回总条数和查询的数据数
        List<Tour> list = tourService.queryList(map);
        int total = tourService.queryListTotal(map);


        return Result.ok("操作成功").put("list",list).put("total",total);
    }


    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestParam Map map){
        if(map  == null){
            map = new HashMap();
        }

        User user = tourService.checkLoginInfo(map);

        if (user != null){
            //此时表示用户存在,既登录成功

            //更新token
            String token = UUID.randomUUID().toString().replace("-","");
            tourService.updateUserToken(token);
            user.setToken(token);
            return Result.ok("操作成功").put("user",user).put("token",token);

        }else{

            return Result.error("登录失败！用户名或密码错误！");
        }


    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestParam Map map){
        if(map  == null){
            map = new HashMap();
        }

        User user1 = JSON.parseObject(JSON.toJSONString(map), User.class);
        User user = tourService.checkLoginInfo(map);

        if (user != null){
            //此时表示用户存在,既登录成功

            //更新token
            String token = UUID.randomUUID().toString().replace("-","");
            tourService.updateUserToken(token);
            user.setToken(token);
            return Result.ok("操作成功").put("user",user).put("token",token);

        }else{

            return Result.error("登录失败！用户名或密码错误！");
        }


    }





}
