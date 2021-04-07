package com.wxm.springcloud.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/4/7.
 */
public class PageUtil extends HashMap{


    private static int  rn = 0;  //起始
    private static int  tn = 6;  //结尾
    private static int  pageNum = 6;  //每页多少条数据

    //处理分页参数
    public static void getQuery(Map map){

        if(null != map){
            int page = map.get("page")==null?1:Integer.parseInt(map.get("page").toString());
            rn = (page-1)*pageNum;
            tn = pageNum;
        }
        map.put("rn",rn);
        map.put("tn",tn);
    }


}
