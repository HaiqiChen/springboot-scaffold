package com.chq.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.List;


@TableName(value = "sys_user")
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUser extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String name;

    private Integer isAdmin;

    private String mobile;

    private String password;

    private String email;

    private String dept;

    private String employeeNumber;

    private Integer status;

    private Long appId;

    @TableField(exist = false)
    private List<String> roles;


}
