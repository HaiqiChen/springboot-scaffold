package com.chq.serice;


import com.chq.config.OAuthUserDetails;
import com.chq.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Service
@AllArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Autowired
//    private ISysUserService userService;


    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //从数据库查询用户
        //        SysUser sysUser = userService.getUserByUsername(username);

//        if (sysUser == null) {
//            throw new UsernameNotFoundException(ResultCode.USER_NOT_EXIST.getMsg());
//        }

        SysUser sysUser = new SysUser();
        OAuthUserDetails oauthUserDetails = new OAuthUserDetails(sysUser);


        //校验
//        if (oauthUserDetails.getId() == null) {
//            throw new UsernameNotFoundException(ResultCode.USER_NOT_EXIST.getMsg());
//        } else if (!oauthUserDetails.isEnabled()) {
//            throw new DisabledException("该账户已被禁用!");
//        } else if (!oauthUserDetails.isAccountNonLocked()) {
//            throw new LockedException("该账号已被锁定!");
//        } else if (!oauthUserDetails.isAccountNonExpired()) {
//            throw new AccountExpiredException("该账号已过期!");
//        }
        return oauthUserDetails;
    }

}
