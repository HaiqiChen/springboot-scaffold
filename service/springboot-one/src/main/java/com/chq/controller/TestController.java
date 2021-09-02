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

    // TODO: 2021/9/2 第二天的对称加密
    // TODO: 2021/9/2 网关的配置方式及其含义
}
