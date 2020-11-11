package com.central.finance.service;

import com.central.finance.model.FinanceProduct;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 金融产品表
 *
 * @author ljb
 * @date 2020-11-03 14:11:44
 */
public interface IFinanceProductService extends ISuperService<FinanceProduct> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<FinanceProduct> findList(Map<String, Object> params);

    /**
     * 查询金融产品详情
     * @param id
     * @return
     */
    FinanceProduct findUserById(String id);

    /**
     * 添加金融产品
     * @param financeProduct
     * @return
     */
    Boolean saveAdd(FinanceProduct financeProduct);
}

