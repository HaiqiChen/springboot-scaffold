package com.chq.common.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "skep")
@RefreshScope
public class SkepConfigProperties {
    /**
     * 是否debug环境
     * debug环境下： 默认当前用户为 poros_debugger
     */
    private boolean debug;

    /**
     * 所属系统标识
     */
    private String syscode;

    /**
     * 服务名称
     */
    private String sername;

    @NestedConfigurationProperty
    private SkepRestAopConfigProperties restAop = new SkepRestAopConfigProperties();

    /**
     * API文档配置信息
     */
    @NestedConfigurationProperty
    private Swagger2ConfigProperties swagger = new Swagger2ConfigProperties();
}