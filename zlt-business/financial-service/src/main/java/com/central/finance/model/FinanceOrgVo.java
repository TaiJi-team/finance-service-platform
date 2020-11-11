package com.central.finance.model;

import lombok.Data;

@Data
public class FinanceOrgVo extends FinanceOrg {
    private UserOrgLegpers userOrgLegpers;
    private UserOrgOper userOrgOpers;
    private FinanceOrgAttachment financeOrgAttachments;
    private FinanceOrgOpenBank financeOrgOpenBanks;
    private FinanceOrgStockh financeOrgStockhs;
    private UserRelation userRelation;

}
