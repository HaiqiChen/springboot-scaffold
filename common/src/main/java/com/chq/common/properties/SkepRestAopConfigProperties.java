package com.chq.common.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "skep.aop")
@RefreshScope
public class SkepRestAopConfigProperties {
    /**
     * Controller base package 逗号分隔
     */
    private String basePackages;

    /**
     * 是否使用check()校验参数
     */
    private boolean checkArgs = true;
}
