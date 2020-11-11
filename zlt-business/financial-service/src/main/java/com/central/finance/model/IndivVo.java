package com.central.finance.model;

import lombok.Data;
@Data
public class IndivVo extends IndivHouseh {
    private UserIndivOper IndivOperData;
    private UserIndivOwer IndivOwerData;
    private IndivAttachment indivAttachments;
    private IndivOpenBank indivOpenBanks;
    private UserRelation userRelation;
}
