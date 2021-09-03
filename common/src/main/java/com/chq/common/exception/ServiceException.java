package com.chq.common.exception;


import com.chq.common.api.IResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jiawen5.chen
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 2631761154221532395L;

    private Integer code;

    private String msg;

    private IResultCode resultCode;

    /**
     * for better performance
     *
     * @return Throwable
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public Throwable doFillInStackTrace() {
        return super.fillInStackTrace();
    }


    public ServiceException(String msg) {
        this.code = 500;
        this.msg = msg;
    }

    public ServiceException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(IResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }
}