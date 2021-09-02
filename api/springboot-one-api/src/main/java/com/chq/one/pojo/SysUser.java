package com.chq.one.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sys_user用户表
 * </p>
 *
 * @author Chen
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账户名/登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 状态(1.正常/启用 2.冻结/禁用)
     */
    private Integer status;

    /**
     * 账户类型(1：OA账号，2：手机号)
     */
    private Integer accountType;

    /**
     * 中文姓名
     */
    private String name;

    /**
     * 事业部id(二级组织)
     */
    private String divisionCode;

    /**
     * 事业部名称(二级组织)
     */
    private String divisionName;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 职位
     */
    private String position;

    /**
     * OA部门
     */
    private String dept;

    /**
     * OA员工编号
     */
    private String employeeNumber;

    /**
     * 用户所属(1：内部员工；2：外部人员)
     */
    private Integer userBelong;

    /**
     * 外部用户类型(1：承运商 2：司机)
     */
    private Integer externalUserType;

    /**
     * 供应商id
     */
    private String carrierId;

    /**
     * 承运商名称(选择类型为承运商时必填)
     */
    private String carrierName;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    private Long modifier;

    /**
     * 更新时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 是否删除(0:否 , 1:是)
     */
    private Integer isDeleted;

    private Integer isAdmin;


}
