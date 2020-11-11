package com.central.finance.service;

import com.central.finance.model.CompAttachment;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;
import com.central.finance.model.CompanyVo;

import java.util.Map;

/**
 * 企业附件表
 *
 * @author ljb
 * @date 2020-10-30 10:08:29
 */
public interface ICompAttachmentService extends ISuperService<CompAttachment> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<CompAttachment> findList(Map<String, Object> params);

    /**
     * 修改
     *
     * @param companyVo
     * @return
     */
    Boolean updateCompany(CompanyVo companyVo);
}

