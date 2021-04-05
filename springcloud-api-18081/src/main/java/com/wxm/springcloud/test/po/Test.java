package com.wxm.springcloud.test.po;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 高等数学 on 2021/3/30.
 */

@Data
public class Test implements Serializable{

    private int id;
    private String name;
    private int age;


}
