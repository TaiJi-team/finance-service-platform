package com.central.backstage.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统菜单表
 *
 * @author yzb
 * @date 2020-11-04 11:21:15
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu")
public class Menu implements Serializable {
    private static final long serialVersionUID=1L;

        private Long pid;
        private Integer subCount;
        private Integer type;
        private String title;
        private String name;
        private String component;
        private Integer menuSort;
        private String icon;
        private String path;
        private Boolean iFrame;
        private Boolean cache;
        private Boolean hidden;
        private String createBy;
        private String updateBy;
        private Date createTime;
        private Date updateTime;
    }
