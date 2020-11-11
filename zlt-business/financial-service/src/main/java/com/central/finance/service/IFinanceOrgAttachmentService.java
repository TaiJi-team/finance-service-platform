package com.central.finance.service;

import com.central.finance.model.FinanceOrgAttachment;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;
import com.central.finance.model.FinanceOrgVo;

import java.util.Map;

/**
 * 金融机构附件表
 *
 * @author ljb
 * @date 2020-10-30 11:08:21
 */
public interface IFinanceOrgAttachmentService extends ISuperService<FinanceOrgAttachment> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<FinanceOrgAttachment> findList(Map<String, Object> params);

    /**
     * 修改
     *
     * @param financeOrgVo
     * @return
     */
    Boolean updateFinance(FinanceOrgVo financeOrgVo);
}

