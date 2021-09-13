package com.chq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springboot-scaffold
 * @description: qidonglie
 * @author: Chen Haiqi
 * @create: 2021-09-13 10:14
 */

@SpringBootApplication
@MapperScan("com.chq.mapper")
@EnableDiscoveryClient
@ServletComponentScan(basePackages = "com.chq.common")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
