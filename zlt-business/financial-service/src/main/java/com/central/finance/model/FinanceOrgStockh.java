package com.central.finance.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 金融机构股东表
 *
 * @author ljb
 * @date 2020-10-30 11:08:24
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("auth_finance_org_stockh")
public class FinanceOrgStockh implements Serializable {
    private static final long serialVersionUID=1L;
        private Long id;
        private Long compId;
        private String holderName;
        private String holderType;
    }
