package com.wxm.springcloud.tour.service.impl;

import com.wxm.springcloud.tour.dao.TourDao;
import com.wxm.springcloud.tour.po.Tour;
import com.wxm.springcloud.tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/4/5.
 */
@Service
public class TourServiceImpl implements TourService{

    @Autowired
    private TourDao tourDao;

    public List<Tour> queryList(Map maps) {
        return tourDao.queryList(maps);
    }

    public int queryListTotal(Map map) {
        return tourDao.queryListTotal(map);
    }
}
