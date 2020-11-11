package com.central.backstage.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业经办人表
 *
 * @author ljb
 * @date 2020-10-30 18:49:31
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_comp_oper")
public class UserCompOper implements Serializable {
    private static final long serialVersionUID=1L;
        private Long id;
        private Long compId;
        private String cardType;
        private String cardNum;
        private Date cardValidDate;
        private String name;
        private String phone;
        private String realName;
        private Integer idNum;
        private String gender;
        private String password;
        private Date regDate;
        private Date updateDate;
        private String headPic;
    }
