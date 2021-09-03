package com.chq.common.core.constant;

/**
 * 常用常量
 */
public interface CommonConstants
{
    /**
     * 动态字表外键id
     */
    static final String PARENT_ID = "parent_id";

    /**
     * 字表集合UID
     */
    static final String UID = "uid";


    /**
     * 请求/响应标记TOKEN长度
     */
    int TOKEN_LENGTH = 8;

    /**
     * 响应结果截取长度
     */
    int RES_LENGTH = 300;

    /**
     * 方法执行前计时器名称
     */
    String METHOD_INVOKE_TOKEN = "methodInvokeToken";

    /**
     * 方法执行开始名称
     */
    String METHOD_INVOKE_START = "methodInvokeStart";

    /**
     * 当前用户请求头标识
     */
    String POROS_USER_INFO_HEADER = "poros-current-user";


    /**
     *  不进行授权
     * not permission flag
     *  feign调用 nacos 标识
     */
    String NOT_PERMISSION_FLAG = "poros-not-permission-flag";

    /**
     * 系统编码 用于区分不同的业务系统
     */
    String SYSCODE = "syscode";

    /**
     * 默认超级管理员账号
     */
    String POROS_SUPER_ADMIN = "super_admin";

//    /**
//     * 默认租户id
//     */
//    String POROS_DEFAULT_TENANTID = "HXLeQcsM";

    /**
     * 默认debugger账号
     */
    String DEBUGGER_USER_INFO = "{\"uid\":\"poros_debugger\",\"username\":\"poros_debugger\",\"orgCodePath\":\"1111_2222\",\"tenantId\":\"HXLeQcsM\"}";

    /**
     * user-agent
     */
    String HEADER_USER_AGENT = "User-Agent";

    /**
     * 创建时间
     */
    String FIELD_CREATE_TIME = "createTime";
    /**
     * 创建人
     */
    String FIELD_CREATE_BY = "createBy";
    /**
     * 更新时间
     */
    String FIELD_UPDATE_TIME = "updateTime";

    /**
     * 更新人 field
     */
    String FIELD_UPDATE_BY = "updateBy";

    /**
     * 租户id
     */
    String FIELD_TENANT_ID = "tenantId";

    /**
     * 默认多租户字段
     */
    String FIELD_TENANT_COLUMN = "tenant_id";

    /**
     * 租户ID长度
     *
     */
    int TENANT_ID_LENGTH = 8;

    /**
     * AUTHORIZATION_HEADER
     */
    String AUTHORIZATION_HEADER = "Authorization";

    /**
     * 暴露给其它服务调用的API
     */
    String FEIGN_API_TAG = "FeignClient-API";

    /**
     * 暴露给其它服务调用的API
     */
    String WebConsole_API_TAG = "WebClient-API";

    String[] DEFAULT_IGNORE_PATTERNS= {"/webjars/**", "/swagger/**", "/actuator/**", "/*.html", "/**/*.js",
            "/**/*.css", "/**/*.ico", "/**/*.woff", "/**/*.ttf", "/**/*.gif", "/**/*.png", "/**/*.webp", "/**/*.jpg"};

    String XSS_ENCODE_ATTR = "XSS_ENCODE_ATTR";

}
