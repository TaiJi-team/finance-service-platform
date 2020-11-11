package com.central.backstage.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限表
 *
 * @author yzb
 * @date 2020-11-04 11:14:33
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_permission")
public class Permission implements Serializable {
    private static final long serialVersionUID=1L;

        private String name;
        private String description;
        private Integer available;
    }
