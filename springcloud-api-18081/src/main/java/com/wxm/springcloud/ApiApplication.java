package com.wxm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

/**
 * Created by 高等数学 on 2021/3/30.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class,args);
    }


}
