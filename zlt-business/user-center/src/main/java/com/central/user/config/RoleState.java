package com.central.user.config;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoleState {
    /**
     * 个体户角色状态
     */
    public static Integer PERSONAL_STATE = 0;
    /**
     * 企业角色状态
     */
    public static Integer COMPANYL_STATE = 1;
    /**
     * 机构角色状态
     */
    public static Integer ORG_STATE = 2;
    /**
     * 个体户角色id
     */
    public static Long PERSONAL_ID = (long)001;
    /**
     * 企业角色id
     */
    public static Long COMPANYL_ID = (long)002;
    /**
     * 金融类机构角色id
     */
    public static Long ORG_ID = (long)003;
}
