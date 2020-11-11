package com.central.finance.model;

import lombok.Data;

@Data
public class CompanyVo extends Company {
    private UserCompLegpers userCompLegpers;
    private UserCompOper userCompOpers;
    private CompAttachment compAttachments;
    private CompExtend compExtends;
    private CompOpenBank compOpenBanks;
    private UserRelation userRelation;
}
