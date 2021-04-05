package com.wxm.springcloud.test.service;

import com.wxm.springcloud.test.po.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/3/30.
 */
public interface TestService {
    void save(Test test);

    List<Test> queryList(Map querMap);

}
