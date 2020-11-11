package com.central.finance.service;

import com.central.finance.model.FinanceOrgExtend;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 金融机构扩展表
 *
 * @author ljb
 * @date 2020-10-30 11:08:20
 */
public interface IFinanceOrgExtendService extends ISuperService<FinanceOrgExtend> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<FinanceOrgExtend> findList(Map<String, Object> params);
}

