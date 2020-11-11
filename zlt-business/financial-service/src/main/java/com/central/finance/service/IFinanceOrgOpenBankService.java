package com.central.finance.service;

import com.central.finance.model.FinanceOrgOpenBank;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 金融机构银行账户表
 *
 * @author ljb
 * @date 2020-10-30 11:08:18
 */
public interface IFinanceOrgOpenBankService extends ISuperService<FinanceOrgOpenBank> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<FinanceOrgOpenBank> findList(Map<String, Object> params);
}

