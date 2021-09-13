package com.chq.grant;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: tms-backend-usercenter
 * @description: 自定义短信验证码登录方式
 * @author: Chen Haiqi
 * @create: 2021-08-05 15:15
 */
public class SmsTokenGranter extends AbstractTokenGranter {
    private static final String GRANT_TYPE = "sms";


    private final AuthenticationManager authenticationManager;

    public SmsTokenGranter(AuthenticationManager authenticationManager, AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory) {
        super(tokenServices, clientDetailsService, requestFactory, GRANT_TYPE);
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        Map<String, String> parameters = new LinkedHashMap<>(tokenRequest.getRequestParameters());
        // 登录用户信息
//        String username = parameters.get(USERNAME);
//        String code = parameters.get(AuthCommonConstant.CODE);
//        String appId = parameters.get(AuthCommonConstant.APP_ID);
        //构建SmsAuthenticationProvider支持的对象
        Authentication userAuth = new SmsAuthenticationToken("username", "code", Long.valueOf("1"));

        ((AbstractAuthenticationToken) userAuth).setDetails(parameters);
        userAuth = this.authenticationManager.authenticate(userAuth);
        OAuth2Request storedOAuth2Request = this.getRequestFactory().createOAuth2Request(client, tokenRequest);
        return new OAuth2Authentication(storedOAuth2Request, userAuth);
    }


}