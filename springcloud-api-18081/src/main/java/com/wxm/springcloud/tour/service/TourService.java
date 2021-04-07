package com.wxm.springcloud.tour.service;

import com.wxm.springcloud.tour.po.Tour;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/4/5.
 */
public interface TourService {

    public List<Tour> queryList(Map maps);

    int queryListTotal(Map map);
}
