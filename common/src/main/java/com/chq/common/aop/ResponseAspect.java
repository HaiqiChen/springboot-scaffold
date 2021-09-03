package com.chq.common.aop;


import com.chq.common.api.RestResponse;
import com.chq.common.core.utils.AopUtil;
import com.chq.common.core.utils.MethodUtil;
import com.chq.common.exception.NotFoundExceptionController;
import com.chq.common.exception.ServiceException;
import com.chq.common.properties.SkepConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
@Slf4j
public class ResponseAspect {

    private static final String SPLIT_STR = ",";

    @Autowired
    private SkepConfigProperties porosConfig;

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController) || @annotation(org.springframework.web.bind.annotation.ResponseBody)")
    public void responseBody() {

    }

    @Around("responseBody()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        if (checkNoScan(signature)) {
            return joinPoint.proceed(args);
        }


        Object result = null;
        long start = System.currentTimeMillis();
        String token = RandomStringUtils.randomAlphanumeric(8);
        MethodUtil.setInvokeToken(token, start);
        String params = AopUtil.getParameters(joinPoint);
        printRequestParam(token, signature, params);



        try {
            result = joinPoint.proceed(args);
            if (result == null) {
                result = RestResponse.ok();
            }
//            else if (!(result instanceof RestResponse)) {
//                result = RestResponse.ok(result);
//            }
        } catch (ServiceException se) {
            result = RestResponse.failed(se.getCode(), se.getMsg());
        }

        log.info("[{}] - 耗时：{}，请求应答：{}", token, System.currentTimeMillis() - start, AopUtil.logStr(result));
        return result;
    }

    /**
     * 是否需要使用AOP处理
     *
     * @param signature
     * @return
     */
    private boolean checkNoScan(MethodSignature signature) {
        if (signature.getDeclaringType() == NotFoundExceptionController.class) {
            return true;
        }
        if (porosConfig.getRestAop() != null && StringUtils.isNotEmpty(porosConfig.getRestAop().getBasePackages())) {
            for (String packageName : porosConfig.getRestAop().getBasePackages().split(SPLIT_STR)) {
                if (signature.getDeclaringTypeName().startsWith(StringUtils.trim(packageName))) {
                    return false;
                }
            }
        }
        return true;
    }




    private void printRequestParam(String token, MethodSignature signature, String params) {
        log.info("[{}] - {}.{} 请求参数：{}", token, signature.getDeclaringType().getSimpleName(), signature.getMethod().getName(), params);
    }

    private String substring(String str, int length) {
        if (StringUtils.length(str) > length) {
            return str.substring(0, length);
        }
        return str;
    }
}

