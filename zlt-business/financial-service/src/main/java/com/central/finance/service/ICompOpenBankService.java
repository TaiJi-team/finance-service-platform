package com.central.finance.service;

import com.central.finance.model.CompOpenBank;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 企业银行账户表
 *
 * @author ljb
 * @date 2020-10-30 10:08:35
 */
public interface ICompOpenBankService extends ISuperService<CompOpenBank> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<CompOpenBank> findList(Map<String, Object> params);
}

