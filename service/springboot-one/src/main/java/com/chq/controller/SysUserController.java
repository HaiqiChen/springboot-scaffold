package com.chq.controller;


import com.chq.common.pojo.Result;
import com.chq.one.pojo.SysUser;
import com.chq.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * sys_user用户表 前端控制器
 * </p>
 *
 * @author Chen
 * @since 2021-09-02
 */

// TODO: 2021/9/2 swaagger注解说明
@RestController
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private SysUserService userService;


    @GetMapping("queryById")
    public Result<SysUser> queryById(@RequestParam Long id) {
        SysUser user = userService.getById(id);
        return Result.ok(user);
    }

    @GetMapping("testError")
    public Result testError(@RequestParam Long id) {
        int i = 1 / 0;
        return Result.ok();
    }

}
