package com.chq.grant;

import com.chq.config.OAuthUserDetails;
import com.chq.entity.SysUser;
import lombok.Setter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @program: tms-backend-usercenter
 * @description: 验证码校验处理类
 * @author: Chen Haiqi
 * @create: 2021-09-10 17:54
 */
public class SmsAuthenticationProvider implements AuthenticationProvider {


    @Setter
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        SmsAuthenticationToken smsAuthenticationToken = (SmsAuthenticationToken) authentication;

        String username = (String) smsAuthenticationToken.getPrincipal();

        String password = smsAuthenticationToken.getCredentials().toString();

        return dealSmsCode(username, password, smsAuthenticationToken.getAppId());
    }


    /**
     * 处理短信验证码的验证方式
     *
     * @param username
     * @param password
     * @return
     */
    private SmsAuthenticationToken dealSmsCode(String username, String password, Long appId) {
        //查找账户是否存在,
        SysUser sysUser = new SysUser();
        UserDetails userDetails = buildUserDetails(sysUser);

        return new SmsAuthenticationToken(userDetails.getAuthorities(), userDetails);
    }


    /**
     * 构建用户认证信息
     *
     * @param user 用户对象
     * @return UserDetails
     */
    private OAuthUserDetails buildUserDetails(SysUser user) {
        return new OAuthUserDetails(user);
    }

    /**
     * ProviderManager 选择具体Provider时根据此方法判断
     * 判断 authentication 是不是 SmsCodeAuthenticationToken 的子类或子接口
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return SmsAuthenticationToken.class.isAssignableFrom(authentication);
    }

    /**
     * 校验短信验证码
     */
    private void verifySms(String phone, String password) {
        //
    }


}
