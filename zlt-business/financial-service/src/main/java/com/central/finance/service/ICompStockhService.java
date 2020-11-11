package com.central.finance.service;

import com.central.finance.model.CompStockh;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 企业股东表
 *
 * @author ljb
 * @date 2020-10-30 10:08:33
 */
public interface ICompStockhService extends ISuperService<CompStockh> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<CompStockh> findList(Map<String, Object> params);
}

