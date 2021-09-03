package com.chq.common.param;


import com.chq.common.bean.UserBaseInfo;
import com.chq.common.context.SkepContextHolder;

public interface ICheck {

    /**
     * 是否需要校验登录态
     * 默认为true
     * @return
     */
    default boolean checkLogin(){ return true;};

    /**
     * 当前用户信息
     *
     * @return
     */
    default UserBaseInfo currentUser() {
        return SkepContextHolder.getCurrentUser();
    };

    /**
     * 校验参数
     */
    default void check() {
        //开启校验登录态时，校验当前用户信息不为空
        if (checkLogin()){
//            Assert.isTrue(ResultCode.USER_NOT_FOUND, null != currentUser());
        }
    };
}