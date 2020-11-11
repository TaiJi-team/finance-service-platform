package com.central.user.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户关联表
 *
 * @author yzb
 * @date 2020-11-07 22:59:38
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_relation")
public class UserRelation implements Serializable {
    private static final long serialVersionUID=1L;
        private Long id;
        private Integer enterpType;
        private Integer persCateg;
        private Integer orgCateg;
        private Long userId;
        private Long compId;
        private Integer province;
        private Integer city;
        private Integer county;
    }
