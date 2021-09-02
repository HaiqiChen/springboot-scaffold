package com.chq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chq.mapper.SysUserMapper;
import com.chq.one.pojo.SysUser;
import com.chq.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sys_user用户表 服务实现类
 * </p>
 *
 * @author Chen
 * @since 2021-09-02
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
