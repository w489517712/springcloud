package com.wxm.springcloud.tour.service;

import com.wxm.springcloud.tour.po.Order;
import com.wxm.springcloud.tour.po.Ticket;
import com.wxm.springcloud.tour.po.Tour;
import com.wxm.springcloud.tour.po.User;

import java.util.List;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/4/5.
 */
public interface TourService {

    public List<Tour> queryList(Map maps);

    int queryListTotal(Map map);

    User checkLoginInfo(Map map);

    void updateUserToken(String replace);

    void insert(User user);

    List<Ticket> queryTicketList(Map map);


    int queryTicketListTotal(Map map);

    List<Order> queryOrderList(Map map);

    int queryOrderListTotal(Map map);

    void saveOrder(Order order);

    void updateOrder(Order order);

    Tour queryTourObject(Map map);

    Ticket queryTicketObject(Map map);

    Order queryOrderObject(Map map);

    List<Map> queryAboutList(Map map);

    List<Map> queryBlogList(Map map);

    int queryBlogListTotal(Map map);
}
