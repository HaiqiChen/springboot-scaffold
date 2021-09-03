package com.chq;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.chq.mapper")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.chq.*.feign")
@ServletComponentScan(basePackages = "com.chq.common")
public class SpringBootOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootOneApplication.class, args);
    }

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}