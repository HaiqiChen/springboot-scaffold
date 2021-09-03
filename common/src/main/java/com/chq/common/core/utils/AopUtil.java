package com.chq.common.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chq.common.api.RestResponse;
import com.chq.common.context.SkepContextHolder;
import com.chq.common.core.constant.CommonConstants;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.springframework.http.HttpMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AopUtil {

    /**
     * 获取请求参数
     *
     * @param joinPoint
     * @return
     */
    public static String getParameters(JoinPoint joinPoint) {
        String requestMethod = SkepContextHolder.getRequest().getMethod();

        if (HttpMethod.PUT.name().equals(requestMethod) || HttpMethod.POST.name().equals(requestMethod)) {
            String params = argsArrayToString(joinPoint.getArgs());
            return StringUtils.substring(params, 0, 2000);
        } else {
            Map<?, ?> paramsMap = (Map<?, ?>) SkepContextHolder.getRequest().getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
            List paramList = Arrays.stream(joinPoint.getArgs()).filter(param -> !isFilterObject(param)).collect(Collectors.toList());
            if (MapUtils.isNotEmpty(paramsMap)) {
                paramList.add(paramsMap);
            }

            return StringUtils.substring(JSON.toJSONString(paramList), 0, 2000);
        }
    }

    /**
     * 参数拼装
     */
    public static String argsArrayToString(Object[] paramsArray) {
        if (ArrayUtils.isNotEmpty(paramsArray)) {
            return Arrays.stream(paramsArray).filter(param -> !isFilterObject(param)).map(param -> JSON.toJSONString(param)).collect(Collectors.joining(" "));
        }
        return "";
    }


    /**
     * 判断是否需要过滤的对象。
     *
     * @param o 对象信息。
     * @return 如果是需要过滤的对象，则返回true；否则返回false。
     */
    public static boolean isFilterObject(final Object o) {
        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse;
    }

    public static String logStr(Object object){
        JSONObject jsonObject=null;
        if (object  instanceof RestResponse){
            jsonObject = new JSONObject();
            RestResponse restResponse = (RestResponse) object;
            jsonObject.put("code",restResponse.getCode());
            jsonObject.put("msg",restResponse.getMsg());
            if (restResponse.getData() != null){
                jsonObject.put("data",StringUtils.substring(JSON.toJSONString(restResponse.getData()),0, CommonConstants.RES_LENGTH));
            }
            return jsonObject.toJSONString();
        }else {
            return StringUtils.substring(JSON.toJSONString(object),0, CommonConstants.RES_LENGTH);
        }
    }
}
