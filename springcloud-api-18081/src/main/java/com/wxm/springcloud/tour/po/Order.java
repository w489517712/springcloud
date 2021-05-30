package com.wxm.springcloud.tour.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 高等数学 on 2021/5/30.
 */
@Data
public class Order {

    private int id;
    private Integer tourid;
    private Integer ticketid;
    private String username;
    private String phone;
    private BigDecimal money;
    private Date createTime;
    private String remark;

    private String addrA;

    private String addrB;

    private String pngurl;

    private String ticketRemark;

    private String setmeal;

    private String createTimeStr;

    private BigDecimal ticketMoney;

    private BigDecimal tourMoney;


}
