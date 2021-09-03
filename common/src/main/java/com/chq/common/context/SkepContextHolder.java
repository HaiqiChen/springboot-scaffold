package com.chq.common.context;

import cn.hutool.core.net.URLDecoder;
import com.alibaba.fastjson.JSON;
import com.chq.common.api.ResultCode;
import com.chq.common.bean.UserBaseInfo;
import com.chq.common.bean.UserInfo;
import com.chq.common.core.constant.GlobalConstants;
import com.chq.common.exception.ServiceException;
import com.google.common.base.Charsets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class SkepContextHolder implements ApplicationContextAware {
    /**
     * 获取用户信息
     */
    @Deprecated
    public static UserBaseInfo getCurrentUser() {
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        // 从请求信息获取登陆用户信息
        // TODO
        return userBaseInfo;
    }

    public static UserInfo getCurrentUserInfo() {
        HttpServletRequest request = getRequest();
        if (null == request) {
            log.error("{} 缺少request 信息", Thread.currentThread().getName());
            throw new ServiceException(ResultCode.INTERNAL_SERVER_ERROR);
        }
        String header = request.getHeader(GlobalConstants.HEADER_USER);
        if (StringUtils.isNotBlank(header)) {
            return JSON.parseObject(header, UserInfo.class);
        } else {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserid(request.getHeader(GlobalConstants.HEADER_TMS_UID));
            userInfo.setUserName(request.getHeader(GlobalConstants.HEADER_TMS_USERNAME));
            //获取name时解码为中文
            userInfo.setName(URLDecoder.decode(request.getHeader(GlobalConstants.HEADER_TMS_NAME), Charsets.UTF_8));
            userInfo.setCurOrg(request.getHeader(GlobalConstants.HEADER_CUR_ORG));
            request.setAttribute(GlobalConstants.HEADER_USER, JSON.toJSONString(userInfo));
            return userInfo;
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SkepContextHolder.applicationContext == null) {
            SkepContextHolder.applicationContext = applicationContext;
        }
    }

    private static ApplicationContext applicationContext = null;

    /**
     * 根据class获取spring管理的bean
     *
     * @param cla
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> cla) {
        return applicationContext.getBean(cla);
    }

    /**
     * 根据name、class获取spring管理的bean
     *
     * @param name
     * @param cal
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> cal) {
        return applicationContext.getBean(name, cal);
    }

    /**
     * 获取配置项
     *
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        return applicationContext.getBean(Environment.class).getProperty(key);
    }

    /**
     * 获取当前Request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        return null == attributes ? null : attributes.getRequest();
    }

}
