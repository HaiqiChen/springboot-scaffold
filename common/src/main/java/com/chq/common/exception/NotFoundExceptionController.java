package com.chq.common.exception;


import com.chq.common.api.RestResponse;
import com.chq.common.api.ResultCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class NotFoundExceptionController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(ERROR_PATH)
    public RestResponse error(){
        return RestResponse.failed(ResultCode.NOT_FOUND);
    }
}
