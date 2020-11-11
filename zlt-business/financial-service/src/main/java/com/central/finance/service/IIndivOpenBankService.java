package com.central.finance.service;

import com.central.finance.model.IndivOpenBank;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 个体户企业银行账户表
 *
 * @author ljb
 * @date 2020-10-30 10:06:46
 */
public interface IIndivOpenBankService extends ISuperService<IndivOpenBank> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<IndivOpenBank> findList(Map<String, Object> params);
}

