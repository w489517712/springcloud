package com.wxm.springcloud.tour.dao;

import com.wxm.springcloud.tour.po.Tour;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/4/5.
 */
@Mapper
public interface TourDao {
    public List<Tour> queryList(Map maps) ;

    int queryListTotal(Map map);
}
