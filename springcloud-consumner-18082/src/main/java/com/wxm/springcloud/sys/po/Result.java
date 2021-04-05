package com.wxm.springcloud.sys.po;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/3/30.
 */
public class Result extends HashMap<String,Object>{

    private final static int CODE_SUCCESS=1;

    public static Result error(String msg) {
        Result r = new Result();
        r.put("code", 0);
        r.put("msg", msg);
        return r;
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }
    public static Result error(int code, String msg,String error) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        r.put("error", error);
        return r;
    }
    public static Result ok() {
        return ok("操作成功");
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("code", 1);
        r.put("msg", msg);
        return r;
    }

    public Result put(Map<String, Object> map) {
        super.putAll(map);
        return this;
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
