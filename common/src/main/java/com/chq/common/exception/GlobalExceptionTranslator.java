package com.chq.common.exception;

import com.alibaba.fastjson.JSON;
import com.chq.common.api.RestResponse;
import com.chq.common.api.ResultCode;
import com.chq.common.core.constant.CommonConstants;
import com.chq.common.core.utils.MethodUtil;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

/**
 * 全局异常处理拦截器
 *
 * @author jiawen5.chen
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionTranslator {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public RestResponse handleError(MissingServletRequestParameterException e) {
        String message = String.format("Missing Request Parameter: %s", e.getParameterName());

        RestResponse result = RestResponse.failed(ResultCode.PARAM_VALID_ERROR.getCode(),
                message);

        log.info("[{}] - 耗时：{}，请求应答：{}",
                MethodUtil.getInvokeToken(),
                MethodUtil.getInvokeElapsed(),
                StringUtils.substring(JSON.toJSONString(result), 0, CommonConstants.RES_LENGTH));
        return result;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public RestResponse handleError(MethodArgumentTypeMismatchException e) {
        String message = String.format("Method Argument Type Mismatch: %s", e.getName());
        RestResponse result = RestResponse.failed(ResultCode.PARAM_VALID_ERROR.getCode(),
                message);

        log.info("[{}] - 耗时：{}，请求应答：{}",
                MethodUtil.getInvokeToken(),
                MethodUtil.getInvokeElapsed(),
                StringUtils.substring(JSON.toJSONString(result), 0, CommonConstants.RES_LENGTH));
        return result;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestResponse handleError(MethodArgumentNotValidException e) {
        log.error("Method Argument Not Valid:{}", e);
        BindingResult bindingResult = e.getBindingResult();
        return getRestResponse(bindingResult);
    }

    private RestResponse getRestResponse(BindingResult bindingResult) {
        FieldError error = bindingResult.getFieldError();
        String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());

        RestResponse result = RestResponse.failed(ResultCode.PARAM_VALID_ERROR.getCode(),
                message);

        log.info("[{}] - 耗时：{}，请求应答：{}",
                MethodUtil.getInvokeToken(),
                MethodUtil.getInvokeElapsed(),
                StringUtils.substring(JSON.toJSONString(result), 0, CommonConstants.RES_LENGTH));
        return result;
    }

    @ExceptionHandler(BindException.class)
    public RestResponse handleError(BindException e) {
        log.error("Bind Exception:{}", e);
        return getRestResponse(e);
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public RestResponse handleError(NoHandlerFoundException e) {
        RestResponse result = RestResponse.failed(ResultCode.NOT_FOUND);

        log.info("[{}] - 耗时：{}，请求应答：{}",
                MethodUtil.getInvokeToken(),
                MethodUtil.getInvokeElapsed(),
                StringUtils.substring(JSON.toJSONString(result), 0, CommonConstants.RES_LENGTH));
        return result;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public RestResponse handleError(HttpMessageNotReadableException e) {
        RestResponse result;
        if (e.getRootCause() instanceof InvalidFormatException) {
            InvalidFormatException exception = (InvalidFormatException) e.getRootCause();
            StringBuilder errors = new StringBuilder();
            List<JsonMappingException.Reference> path = exception.getPath();
            for (JsonMappingException.Reference reference : path) {
                errors.append("参数名：").append(reference.getFieldName()).append(" 输入不合法，需要的是 ").append(exception.getTargetType().getName()).append(" 类型，").append("提交的值是：").append(exception.getValue().toString());
            }
            result = RestResponse.failed(ResultCode.PARAM_VALID_ERROR.getCode(),
                    errors.toString());
        } else {
            result = RestResponse.failed(ResultCode.PARAM_VALID_ERROR.getCode(),
                    e.getMessage());
        }

        log.info("[{}] - 耗时：{}，请求应答：{}",
                MethodUtil.getInvokeToken(),
                MethodUtil.getInvokeElapsed(),
                StringUtils.substring(JSON.toJSONString(result), 0, CommonConstants.RES_LENGTH));
        return result;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public RestResponse handleError(HttpRequestMethodNotSupportedException e) {
        RestResponse result = RestResponse.failed(ResultCode.METHOD_NOT_SUPPORTED);

        log.info("[{}] - 耗时：{}，请求应答：{}",
                MethodUtil.getInvokeToken(),
                System.currentTimeMillis() - MethodUtil.getInvokeStart(),
                StringUtils.substring(JSON.toJSONString(result), 0, CommonConstants.RES_LENGTH));
        return result;
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public RestResponse handleError(HttpMediaTypeNotSupportedException e) {
        RestResponse result = RestResponse.failed(ResultCode.MEDIA_TYPE_NOT_SUPPORTED);

        log.info("[{}] - 耗时：{}，请求应答：{}",
                MethodUtil.getInvokeToken(),
                System.currentTimeMillis() - MethodUtil.getInvokeStart(),
                StringUtils.substring(JSON.toJSONString(result), 0, CommonConstants.RES_LENGTH));
        return result;
    }

    @ExceptionHandler(ServiceException.class)
    public RestResponse handleError(ServiceException e) {
        RestResponse result = RestResponse.failed(e.getCode(), e.getMsg());
        log.info("ServiceException");
        log.info("[{}] - 耗时：{}，请求应答：{}",
                MethodUtil.getInvokeToken(),
                System.currentTimeMillis() - MethodUtil.getInvokeStart(),
                StringUtils.substring(JSON.toJSONString(result), 0, CommonConstants.RES_LENGTH));
        return result;
    }

    @ExceptionHandler(Throwable.class)
    public RestResponse handleError(Throwable e) {
        log.error("Internal Server Error:{}", e);
        RestResponse result = RestResponse.failed(ResultCode.INTERNAL_SERVER_ERROR, e.getMessage());

        log.info("[{}] - 耗时：{}，请求应答：{}",
                MethodUtil.getInvokeToken(),
                System.currentTimeMillis() - MethodUtil.getInvokeStart(),
                StringUtils.substring(JSON.toJSONString(result), 0, CommonConstants.RES_LENGTH));
        return result;
    }

    // 其他未处理的异常
    @ExceptionHandler(Exception.class)
    public RestResponse exceptionHandler(Exception e) {
        log.error("Exception Internal Server Error:{}", e);
        RestResponse result = RestResponse.failed(ResultCode.INTERNAL_SERVER_ERROR, e.getMessage());
        log.info("Exception");
        log.info("[{}] - 耗时：{}，请求应答：{}",
                MethodUtil.getInvokeToken(),
                System.currentTimeMillis() - MethodUtil.getInvokeStart(),
                StringUtils.substring(JSON.toJSONString(result), 0, CommonConstants.RES_LENGTH));
        return result;
    }
}