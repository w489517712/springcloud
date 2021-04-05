package com.wxm.springcloud.tour.controller;

import com.wxm.springcloud.sys.po.Result;
import com.wxm.springcloud.test.po.Test;
import com.wxm.springcloud.tour.po.Tour;
import com.wxm.springcloud.tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<Tour> list = tourService.queryList(map);
        return Result.ok("操作成功").put("list",list);
    }
}
