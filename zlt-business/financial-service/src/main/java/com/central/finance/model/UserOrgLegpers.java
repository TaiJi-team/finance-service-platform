package com.central.finance.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 机构法人代表表
 *
 * @author ljb
 * @date 2020-10-29 09:26:07
 */
@Getter
@Setter
public class UserOrgLegpers implements Serializable {
    private static final long serialVersionUID=1L;
        private Long id;
        private Long compId;
        private String name;
        private String cardType;
        private String cardNum;
        private Date cardValidDate;
        private Long orgCateg;
        private String phone;
        private String realName;
        private Integer idNum;
        private String gender;
        private String password;
        private Date regDate;
        private Date updateDate;
        private String headPic;
    }