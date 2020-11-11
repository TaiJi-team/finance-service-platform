package com.central.backstage.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业管法人代表表
 *
 * @author ljb
 * @date 2020-11-02 15:21:07
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_comp_legpers")
public class UserCompLegpers implements Serializable {
    private static final long serialVersionUID=1L;
        private Long  id;
        private Long compId;
        private String name;
        private String cardType;
        private String cardNum;
        private Date cardValidDate;
        private String phone;
        private String realName;
        private String gender;
        private String password;
        private Date regDate;
        private Date updateDate;
        private String headPic;
    }
