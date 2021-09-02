package com.chq.one.fengin;

import com.chq.common.pojo.Result;
import com.chq.core.feign.CoreFeign;
import com.chq.one.pojo.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "springboot-one", path = "/user")
public interface SysUserFeign extends CoreFeign<SysUser> {

    @GetMapping("queryById")
    public Result<SysUser> queryById(@RequestParam Long id);
}
