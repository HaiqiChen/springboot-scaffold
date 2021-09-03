package com.chq.controller;

import com.chq.core.controller.AbstractCoreController;
import com.chq.one.pojo.SysUser;
import com.chq.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot-scaffold
 * @description:
 * @author: Chen Haiqi
 * @create: 2021-09-02 15:46
 **/

@RestController
@RequestMapping("/test")
public class TestController extends AbstractCoreController<SysUser> {

    @Autowired
    public TestController(SysUserService userService) {
        super(userService);
    }

    // TODO: 2021/9/2 对称加密 2
    // TODO: 2021/9/2 网关的配置方式及其含义
    // TODO: 2021/9/2 分布式文件系统 4
    // TODO: 2021/9/2 kafka 和内容安全 6  支持对图片、视频、文本、语音等对象进行多样化场景检测
    // TODO: 2021/9/2 雪花算法集成mybatis-plus
    // TODO: 2021/9/2 分布式任务调度 8
    // TODO: 2021/9/2 mongodb 11
    // TODO: 2021/9/2 kibana 12
    // TODO: 2021/9/2 kafka strem  13
    // TODO: 2021/9/2 分布式事务 ，setae 14
    // TODO: 2021/9/2 分布式链路追踪  以及其他技术  15
    // TODO: 2021/9/2
}
