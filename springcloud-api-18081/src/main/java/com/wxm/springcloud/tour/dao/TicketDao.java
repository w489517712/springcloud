package com.wxm.springcloud.tour.dao;

import com.wxm.springcloud.tour.po.Tour;
import com.wxm.springcloud.tour.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by 高等数学 on 2021/4/5.
 */
@Mapper
public interface TicketDao {
    public List<Tour> queryList(Map maps) ;

    int queryListTotal(Map map);

    User checkLoginInfo(Map map);

    void updateUserToken(String replace);

    Integer register(User user);
    
}
