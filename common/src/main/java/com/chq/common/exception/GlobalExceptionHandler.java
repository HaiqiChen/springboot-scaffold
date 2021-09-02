package com.chq.common.exception;


import com.chq.common.pojo.Result;
import com.chq.common.pojo.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice//注解用来标识该类是一个异常处理类
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);



    //这里写一个方法 当 某一个controller 发生了异常就会被执行该方法 ，捕获异常，处理结果 返回给前端 处理系统异常

    // TODO: 2021/9/2 添加日志
    //处理系统的异常
    @ExceptionHandler(value = Exception.class)//当发生了exception异常（包括他的子类）的时候 就执行该方法 返回给前端
    public Result handlerException(Exception e) {
        e.printStackTrace();
        return Result.errorMessage(e.getMessage());
    }


    // 处理 自定义的异常
    @ExceptionHandler(value = BusinessException.class)//发生自定义的BusinessException的时候 就执行该方法 返回给前端
    public Result handlerLeadNewsException(BusinessException e) {
        e.printStackTrace();
        return Result.errorMessage(e.getMessage(), StatusCode.CUSTOM_FAILURE.code(), null);
    }


}
