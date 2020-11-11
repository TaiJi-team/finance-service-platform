package com.central.finance.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户关联表
 *
 * @author ljb
 * @date 2020-11-02 15:23:05
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_relation")
public class UserRelation implements Serializable {
    private static final long serialVersionUID=1L;
        private Long    id;
        private Integer enterpType;
        private Integer persCateg;
        private Integer orgCateg;
        private Long userId;
        private Long compId;
        private Integer province;
        private Integer city;
        private Integer county;
    }
