package com.chq.common.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "skep.swagger")
@RefreshScope
public class Swagger2ConfigProperties {

    /**
     * 标题
     */
    private String title;

    /**
     * 基本包
     */
    private String basePackage;

    /**
     * 描述
     */
    private String description;

    /**
     * URL
     */
    private String url;

    /**
     * 作者
     */
    private String contactName;

    /**
     * 作者网址
     */
    private String contactUrl;

    /**
     * 作者邮箱
     */
    private String contactEmail;

    /**
     * 版本
     */
    private String version;
}