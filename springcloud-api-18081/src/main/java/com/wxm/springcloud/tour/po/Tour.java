package com.wxm.springcloud.tour.po;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by 高等数学 on 2021/4/5.
 */
@Data
public class Tour  implements Serializable{

    private int id;

    private String name;

    private BigDecimal money;

    private String lev;

    private String remark;

    private String setmeal;

    private String pngurl;

    private String country;


}
