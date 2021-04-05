package com.wxm.springcloud.tour.controller;

import com.wxm.springcloud.sys.po.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/4/5.
 */
@RestController
@RequestMapping("/tour")
public class TourController {

    @PostMapping("/queryTourList")
    @ResponseBody
    public Result queryList(@RequestBody Map map){
        if(map  == null){
            map = new HashMap();
        }

        //List<Test> tests = testService.queryList(map);
        return Result.ok("操作成功").put("testList","");
    }
}
