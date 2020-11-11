package com.central.finance.service;

import com.central.finance.model.FinanceOrgStockh;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 金融机构股东表
 *
 * @author ljb
 * @date 2020-10-30 11:08:24
 */
public interface IFinanceOrgStockhService extends ISuperService<FinanceOrgStockh> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<FinanceOrgStockh> findList(Map<String, Object> params);
}

