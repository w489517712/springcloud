package com.wxm.springcloud.test.dao;

import com.wxm.springcloud.test.po.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/3/30.
 */
@Mapper
public interface TestDao {

        void save(Test test);

        List<Test> queryList(Map querMap);

}
