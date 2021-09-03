package com.chq.common.core.utils;

import com.chq.common.core.constant.CommonConstants;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Optional;

public class MethodUtil {

    public static void setInvokeToken(String token, long start) {
        RequestAttributes sra = RequestContextHolder.getRequestAttributes();
        sra.setAttribute(CommonConstants.METHOD_INVOKE_TOKEN, token, RequestAttributes.SCOPE_REQUEST);
        sra.setAttribute(CommonConstants.METHOD_INVOKE_START, start, RequestAttributes.SCOPE_REQUEST);
    }

    public static String getInvokeToken() {
        RequestAttributes sra = RequestContextHolder.getRequestAttributes();
        return (String) sra.getAttribute(CommonConstants.METHOD_INVOKE_TOKEN, RequestAttributes.SCOPE_REQUEST);
    }

    public static long getInvokeStart() {
        RequestAttributes sra = RequestContextHolder.getRequestAttributes();
        return Optional.ofNullable((Long) sra.getAttribute(CommonConstants.METHOD_INVOKE_START, RequestAttributes.SCOPE_REQUEST)).orElse(System.currentTimeMillis());
    }

    public static long getInvokeElapsed() {
        return System.currentTimeMillis() - getInvokeStart();
    }

}