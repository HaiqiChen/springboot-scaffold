package com.chq.common.exception;


import com.chq.common.pojo.StatusCode;

/*

自定义异常，如果说出现了业务上的异常 比如：查不到信息，抛出
 */
public class BusinessException extends Exception {

    //状态码
    private Integer code;

    //异常信息
    private String message;

    public BusinessException() {

    }

    public BusinessException(String message) {
        this.message = message;
        this.code = StatusCode.CUSTOM_FAILURE.code();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BusinessException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}