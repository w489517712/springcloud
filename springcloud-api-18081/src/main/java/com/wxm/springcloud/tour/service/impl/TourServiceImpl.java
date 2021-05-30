package com.wxm.springcloud.tour.service.impl;

import com.wxm.springcloud.tour.dao.TicketDao;
import com.wxm.springcloud.tour.dao.TourDao;
import com.wxm.springcloud.tour.po.Order;
import com.wxm.springcloud.tour.po.Ticket;
import com.wxm.springcloud.tour.po.Tour;
import com.wxm.springcloud.tour.po.User;
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


    @Override
    public List<Tour> queryList(Map maps) {
        return tourDao.queryList(maps);
    }
    @Override
    public int queryListTotal(Map map) {
        return tourDao.queryListTotal(map);
    }
    @Override
    public User checkLoginInfo(Map map) {
        return tourDao.checkLoginInfo(map);

    }
    @Override
    public void updateUserToken(String replace) {
        tourDao.updateUserToken(replace);
    }

    @Override
    public void insert(User user){
        Integer rows = tourDao.register(user);
    }

    @Override
    public List<Ticket> queryTicketList(Map map) {
        return tourDao.queryTicketList(map);
    }

    @Override
    public int queryTicketListTotal(Map map) {
        return tourDao.queryTicketListTotal(map);
    }

    @Override
    public List<Order> queryOrderList(Map map) {
        return tourDao.queryOrderList(map);
    }

    @Override
    public int queryOrderListTotal(Map map) {
        return tourDao.queryOrderListTotal(map);
    }


}
