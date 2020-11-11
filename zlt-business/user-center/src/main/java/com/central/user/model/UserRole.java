package com.central.user.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用户关联表
 *
 * @author yzb
 * @date 2020-11-07 22:59:38
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role")
public class UserRole implements Serializable {
    private static final long serialVersionUID=1L;

    private Long userId;
    private Long roleId;
}
