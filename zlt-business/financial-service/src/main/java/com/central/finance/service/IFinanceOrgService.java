package com.central.finance.service;

import com.central.finance.model.FinanceOrg;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;
import com.central.finance.model.FinanceOrgVo;

import java.util.Map;

/**
 * 金融机构表
 *
 * @author ljb
 * @date 2020-10-29 09:21:31
 */
public interface IFinanceOrgService extends ISuperService<FinanceOrg> {
    /**
     * 列表
     *
     * @param params
     * @return
     */
    PageResult<FinanceOrg> findList(Map<String, Object> params);

    /**
     * 新增
     *
     * @param financeOrgVo
     * @return
     */
    Boolean saveAdd(FinanceOrgVo financeOrgVo);


    /**
     * 修改
     *
     * @param financeOrgVo
     * @return
     */
    Boolean updateFinance(FinanceOrgVo financeOrgVo);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    FinanceOrgVo getById(String id);
}

