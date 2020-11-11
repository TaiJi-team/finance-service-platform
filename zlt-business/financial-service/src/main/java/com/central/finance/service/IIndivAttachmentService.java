package com.central.finance.service;

import com.central.finance.model.IndivAttachment;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;
import com.central.finance.model.IndivVo;

import java.util.Map;

/**
 * 个体户企业附件表
 *
 * @author ljb
 * @date 2020-10-30 10:06:44
 */
public interface IIndivAttachmentService extends ISuperService<IndivAttachment> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<IndivAttachment> findList(Map<String, Object> params);

    /**
     * 修改
     *
     * @param indivVo
     * @return
     */
    Boolean updateIndiv(IndivVo indivVo);
}

