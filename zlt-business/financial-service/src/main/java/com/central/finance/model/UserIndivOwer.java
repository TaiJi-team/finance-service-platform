package com.central.finance.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 个体户户主表
 *
 * @author zlt
 * @date 2020-10-28 10:44:02
 */
@Getter
@Setter
public class UserIndivOwer implements Serializable {
    private static final long serialVersionUID=1L;
        private Long id;
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
