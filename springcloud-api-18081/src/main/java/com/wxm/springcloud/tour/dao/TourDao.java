package com.wxm.springcloud.tour.dao;

import com.wxm.springcloud.tour.po.Order;
import com.wxm.springcloud.tour.po.Ticket;
import com.wxm.springcloud.tour.po.Tour;
import com.wxm.springcloud.tour.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/4/5.
 */
@Mapper
public interface TourDao {
    public List<Tour> queryList(Map maps);

    public List<Tour> queryList1(Map maps);

    int queryListTotal(Map map);

    User checkLoginInfo(Map map);

    void updateUserToken(String replace);

    Integer register(User user);

    List<Ticket> queryTicketList(Map map);

    int queryTicketListTotal(Map map);

    List<Order> queryOrderList(Map map);

    int queryOrderListTotal(Map map);

    void saveOrder(Order order);

    void updateOrder(Order order);

    Tour queryTourObject(Map map);

    Ticket queryTicketObject(Map map);

    Order queryOrderObject(Map map);
}
