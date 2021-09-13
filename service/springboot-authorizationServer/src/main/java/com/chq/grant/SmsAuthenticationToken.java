package com.chq.grant;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @program: tms-backend-usercenter
 * @description: 存储短信验证码信息
 * @author: Chen Haiqi
 * @create: 2021-09-10 17:55
 */
public class SmsAuthenticationToken extends AbstractAuthenticationToken {

    /**
     * 账号主体信息
     */
    private final Object principal;

    private Object credentials;

    private Long appId;


    /**
     * @return
     * @Author haiqi1.chen
     * @Description 构建已经授权的账户信息
     * @Date 2021/9/10
     * @Param [authorities, principal, credentials, appId]
     */
    public SmsAuthenticationToken(Collection<? extends GrantedAuthority> authorities, Object principal) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

    /**
     * @return
     * @Author haiqi1.chen
     * @Description 构建未授权的账户信息
     * @Date 2021/9/10
     * @Param [principal, credentials, appId]
     */
    public SmsAuthenticationToken(String username, String password, Long appId) {
        super(null);
        this.principal = username;
        this.credentials = password;
        this.appId = appId;
        super.setAuthenticated(false);
    }


    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }


    public Long getAppId() {
        return appId;
    }
}
