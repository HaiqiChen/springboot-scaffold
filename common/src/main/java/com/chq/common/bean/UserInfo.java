package com.chq.common.bean;

import lombok.Data;

import java.util.List;

/**
 * @author Chenjw
 * @since 2021/8/18
 **/
@Data
public class UserInfo {

    private String userid;

    private String userName;

    private String name;

    private List<String> deptCodes;

    private String orgId;

    private String orgName;

    private String deptCode;

    /**
     * 当前机构
     */
    private String curOrg;
}
