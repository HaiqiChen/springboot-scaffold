package com.chq.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBaseInfo {

    /**
     * 登录名
     */
    private String uid;

    /**
     * 员工号
     */
    private String empNum;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 头像
     */
    private String headUrl;

    /**
     * 是否是租户管理员
     */
    private boolean isTenantManager;

    /**
     * 主部门code
     */
    private String orgCode;

    /**
     * 主部门codePath
     */
    private String orgCodePath;

    /**
     * 所有所在部门code
     */
    private List<String> allOrgCode;

    /**
     * 所有所在部门codePath
     */
    private List<String> allOrgCodePath;

    /**
     * 岗位列表
     */
    private List<String> postionCodes;

    /**
     * 权限条目
     */
    private List<String> permission;
}

