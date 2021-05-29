package com.wxm.springcloud.tour.po;

import lombok.Data;

/**
 * Created by 高等数学 on 2021/5/9.
 */
@Data
public class User {

    private Integer id;

    private String name;

    private String passWord;

    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
