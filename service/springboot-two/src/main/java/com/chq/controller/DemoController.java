package com.chq.controller;

import com.chq.common.pojo.Result;
import com.chq.one.fengin.SysUserFeign;
import com.chq.one.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot-scaffold
 * @description:
 * @author: Chen Haiqi
 * @create: 2021-09-02 17:23
 **/

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private SysUserFeign sysUserFeign;


    @RequestMapping("/testFeign")
    public Result testFeign(@RequestParam Long id) {
        Result<SysUser> sysUserResult = sysUserFeign.queryById(id);
        return sysUserResult;
    }
}
