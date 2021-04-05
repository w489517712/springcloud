package com.wxm.springcloud.test.controller;

import com.wxm.springcloud.sys.po.Result;
import com.wxm.springcloud.test.po.Test;
import com.wxm.springcloud.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/3/30.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody Test test){
        try {
            testService.save(test);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("操作失败");
        }
        return Result.ok("操作成功");
    }

    @PostMapping("/queryList")
    @ResponseBody
    public Result queryList(@RequestParam Map map){
        if(map  == null){
            map = new HashMap();
        }

        List<Test> tests = testService.queryList(map);
        return Result.ok("操作成功").put("testList",tests);
    }


}
