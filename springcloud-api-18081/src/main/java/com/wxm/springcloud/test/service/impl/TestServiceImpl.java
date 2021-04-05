package com.wxm.springcloud.test.service.impl;

import com.wxm.springcloud.test.dao.TestDao;
import com.wxm.springcloud.test.po.Test;
import com.wxm.springcloud.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/3/30.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    public void save(Test test) {

        testDao.save(test);
    }

    public List<Test> queryList(Map querMap) {
        return testDao.queryList(querMap);
    }
}

