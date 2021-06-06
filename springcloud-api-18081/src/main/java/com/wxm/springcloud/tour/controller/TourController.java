package com.wxm.springcloud.tour.controller;

import com.alibaba.fastjson.JSON;
import com.wxm.springcloud.sys.po.Result;
import com.wxm.springcloud.test.po.Test;
import com.wxm.springcloud.tour.po.Order;
import com.wxm.springcloud.tour.po.Ticket;
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

    @RequestMapping("/register")
    @ResponseBody
    public Result register(@RequestParam Map map){
        tourService.insert(JSON.parseObject(JSON.toJSONString(map),User.class));
        return Result.ok("操作成功");
    }

    @PostMapping("/queryList")//酒店查询
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

    @PostMapping("/queryTicketList")//机票查询
    @ResponseBody
    public Result queryTicketList(@RequestParam Map map){
        if(map  == null){
            map = new HashMap();
        }


        PageUtil.getQuery(map);

        //需要返回总条数和查询的数据数
        List<Ticket> list = tourService.queryTicketList(map);
        int total = tourService.queryTicketListTotal(map);
        return Result.ok("操作成功").put("list",list).put("total",total);
    }


    @PostMapping("/queryOrderList")//订单查询
    @ResponseBody
    public Result queryOrderList(@RequestParam Map map){
        if(map  == null){
            map = new HashMap();
        }


        PageUtil.getQuery(map);

        //需要返回总条数和查询的数据数
        List<Order> list = tourService.queryOrderList(map);
        int total = tourService.queryOrderListTotal(map);
        return Result.ok("操作成功").put("list",list).put("total",total);
    }


    @PostMapping("/saveOrder")//新增查询
    @ResponseBody
    public Result saveOrder(@RequestParam Map map){
        Order order = JSON.parseObject(JSON.toJSONString(map), Order.class);
        tourService.saveOrder(order);

        return Result.ok("操作成功").put("id",order.getId());
    }

    @PostMapping("/updateOrder")//新增查询
    @ResponseBody
    public Result updateOrder(@RequestParam Map map){
        Order order = JSON.parseObject(JSON.toJSONString(map), Order.class);
        tourService.updateOrder(order);

        return Result.ok("操作成功").put("id",order.getId());
    }




    @PostMapping("/queryTourObject")//新增查询
    @ResponseBody
    public Result queryTourObject(@RequestParam Map map){
        Tour tour = tourService.queryTourObject(map);

        return Result.ok("操作成功").put("result",tour);
    }

    @PostMapping("/queryTicketObject")//新增查询
    @ResponseBody
    public Result queryTicketObject(@RequestParam Map map){
        Ticket ticket = tourService.queryTicketObject(map);

        return Result.ok("操作成功").put("result",ticket);
    }

    @PostMapping("/queryOrderObject")//新增查询
    @ResponseBody
    public Result queryOrderObject(@RequestParam Map map){
        Order order = tourService.queryOrderObject(map);

        return Result.ok("操作成功").put("result",order);
    }



    @PostMapping("/queryAboutObject")//新增查询
    @ResponseBody
    public Result queryAboutObject(@RequestParam Map map){
        List<Map>  listresult = tourService.queryAboutList(map);

        return Result.ok("操作成功").put("result",listresult);
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

            return Result.error("Login failed！Wrong username or password！");
        }



    }

    @PostMapping("/queryBlogList")//订单查询
    @ResponseBody
    public Result queryBlogList(@RequestParam Map map){
        if(map  == null){
            map = new HashMap();
        }


        PageUtil.getQuery(map);

        //需要返回总条数和查询的数据数
        List<Map> list = tourService.queryBlogList(map);
        int total = tourService.queryBlogListTotal(map);
        return Result.ok("操作成功").put("list",list).put("total",total);
    }

//    @PostMapping("/register")
//    @ResponseBody
//    public Result register(@RequestParam Map map){
//        if(map  == null){
//            map = new HashMap();
//        }
//
//        User user1 = JSON.parseObject(JSON.toJSONString(map), User.class);
//        User user = tourService.checkLoginInfo(map);
//
//        if (user != null){
//            //此时表示用户存在,既登录成功
//
//            //更新token
//            String token = UUID.randomUUID().toString().replace("-","");
//            tourService.updateUserToken(token);
//            user.setToken(token);
//            return Result.ok("操作成功").put("user",user).put("token",token);
//
//        }else{
//
//            return Result.error("登录失败！用户名或密码错误！");
//        }
//
//
//    }







}
