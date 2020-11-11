package com.central.finance.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 金融机构附件表
 *
 * @author ljb
 * @date 2020-10-30 11:08:21
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("auth_finance_org_attachment")
public class FinanceOrgAttachment implements Serializable {
    private static final long serialVersionUID=1L;
        private Long id;
        private Long compId;
        private String association;
        private String capiReport;
        private String creditReport;
        private String loanUse;
        private String custContract;
        private String legalPersonCreditReport;
    }
