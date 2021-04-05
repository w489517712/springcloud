package com.wxm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by 高等数学 on 2021/3/30.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsummerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsummerApplication.class,args);
    }


}
