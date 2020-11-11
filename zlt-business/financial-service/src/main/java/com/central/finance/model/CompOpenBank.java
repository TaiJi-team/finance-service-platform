package com.central.finance.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业银行账户表
 *
 * @author ljb
 * @date 2020-10-30 10:08:35
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("auth_comp_open_bank")
public class CompOpenBank implements Serializable {
    private static final long serialVersionUID=1L;
        private Long id;
        private Long compId;
        private String compName;
        private String bankName;
        private String bankAccount;
        private String openLisence;
    }
