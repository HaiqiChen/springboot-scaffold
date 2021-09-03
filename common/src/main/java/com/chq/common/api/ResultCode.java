package com.chq.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

@Getter
@AllArgsConstructor
public enum ResultCode implements IResultCode {
    /**
     * 成功
     */
    SUCCESS(0, "success"),

    /**
     * 失败
     */
    FAILURE(-1, "fail"),

    /**
     * 没有获取到当前用户
     */
    USER_NOT_FOUND(401, "Current User Not Found"),

    /**
     * 系统异常
     */
    INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error"),

    /**
     * 未认证
     */
    UN_AUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "Request Unauthorized"),

    /**
     * 404
     */
    NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, "404 Not Found"),

    /**
     * 不支持的Method
     */
    METHOD_NOT_SUPPORTED(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Method Not Supported"),

    /**
     * MediaType不支持
     */
    MEDIA_TYPE_NOT_SUPPORTED(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Media Type Not Supported"),

    /**
     * 禁止访问
     */
    FORBIDDEN(HttpServletResponse.SC_FORBIDDEN, "403 Forbidden"),

    /**
     * 参数校验失败
     */
    PARAM_VALID_ERROR(HttpServletResponse.SC_BAD_REQUEST, "Parameter Validation Error"),

    /**
     * fall-back
     */
    FAIL_FALL_BACK(9998, "fall back"),


    /**
     * 账户异常信息
     */
    USER_NOT_EXIST(20000, "用户不存在"),

    USER_ACCOUNT_LOCKED(20001,"用户账户被冻结"),

    USER_ACCOUNT_INVALID(20002,"用户账户已作废"),

    USERNAME_OR_PASSWORD_ERROR(20003,"用户名或密码错误"),

    INPUT_PASSWORD_EXCEED_LIMIT(20004,"用户输入密码次数超限"),

    AUTHENTICATION_FAILED(20005,"访问认证异常"),

    TOKEN_INVALID_OR_EXPIRED(20006,"token无效或已过期"),

    TOKEN_ACCESS_FORBIDDEN(20007,"token已被禁止访问"),

    DUPLICATED_KEY_ERROR(20008,"输入信息已存在"),

    SMS_CODE_ERROR(20009,"验证码错误"),

    SMS_CODE_LOSE_EFFICACY(20010,"验证码失效"),

    SMS_CODE_MANY_TIME_ERROR(20011,"输错验证码次数太多，5分钟后再试"),

    SMS_CODE_EMPTY(20012,"手机号或者验证码不能为空"),

    AUTHORIZED_ERROR(20013,"访问权限异常"),

    ACCESS_UNAUTHORIZED(20014,"访问未授权"),

    PARAM_ERROR(20015,"用户请求参数错误"),

    DATABASE_OPERATION_ERROR(20016, "数据操作失败");


    final int code;

    final String msg;

    public static ResultCode fromCode(long code) {
        ResultCode[] ecs = ResultCode.values();
        for (ResultCode ec : ecs) {
            if (ec.getCode() == code) {
                return ec;
            }
        }
        return SUCCESS;
    }
}
