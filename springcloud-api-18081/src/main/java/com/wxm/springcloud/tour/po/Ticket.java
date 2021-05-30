package com.wxm.springcloud.tour.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by 高等数学 on 2021/5/30.
 */
@Data
public class Ticket {

        private int id;

        private String addrA;

        private String addrB;

        private BigDecimal money;

        private String usetime;

        private String pngurl;

        private String remark;



}
