package com.central.login.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.google.common.base.Verify;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户表
 *
 * @author yzb
 * @date 2020-11-09 14:20:53
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class User implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;
    private String userName;
    private String password;
    private String nickName;
    private String realName;
    private String headImgUrl;
    private String mobile;
    private Integer gender;
    private Integer idNum;
    private Integer enabled;
    private String sourceType;
    private Date createTime;
    private Date regDate;
    private Date updateTime;
    private String openId;
    private Integer isDel;
    private String type;
    private String verify;
}
