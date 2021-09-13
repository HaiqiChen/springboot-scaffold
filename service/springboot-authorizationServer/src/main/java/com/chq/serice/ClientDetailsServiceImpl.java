package com.chq.serice;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 * @program: tms-backend-usercenter
 * @description: clientDetails处理类
 * @author: Chen Haiqi
 * @create: 2021-08-05 15:15
 */
@Slf4j
@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

//    @Autowired
//    private IOAuthClientService OAuthClientService;

    @Override
    @SneakyThrows
    public ClientDetails loadClientByClientId(String clientId) {
        try {
//            SysOauthClient client = OAuthClientService.getOAuthClientById(clientId);
//            BaseClientDetails clientDetails = new BaseClientDetails(
//                    client.getClientId(),
//                    client.getResourceIds(),
//                    client.getScope(),
//                    client.getAuthorizedGrantTypes(),
//                    client.getAuthorities(),
//                    client.getWebServerRedirectUri());
//            clientDetails.setClientSecret(PasswordEncoderTypeEnum.NOOP.getPrefix() + client.getClientSecret());
//            clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValidity());
//            clientDetails.setRefreshTokenValiditySeconds(client.getRefreshTokenValidity());
            BaseClientDetails clientDetails = new BaseClientDetails(
                    "client",
                    null,
                    "all",
                    "refresh_token,sms",
                    "null",
                    "null"
            );
            clientDetails.setClientSecret("{noop}123456");
            clientDetails.setAccessTokenValiditySeconds(1000);
            clientDetails.setRefreshTokenValiditySeconds(1000);

            return clientDetails;
        } catch (EmptyResultDataAccessException var4) {
            throw new NoSuchClientException("No client with requested id: " + clientId);
        }
    }

}
