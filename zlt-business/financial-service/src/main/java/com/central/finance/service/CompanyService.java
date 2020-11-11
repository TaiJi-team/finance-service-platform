package com.central.finance.service;

import com.central.finance.model.Company;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;
import com.central.finance.model.CompanyVo;
import com.central.finance.model.IndivVo;

import java.util.Map;

/**
 * 企业表
 *
 * @author ljb
 * @date 2020-10-28 15:02:14
 */
public interface CompanyService extends ISuperService<Company> {
    /**
     * 列表
     *
     * @param params
     * @return
     */
    PageResult<Company> findList(Map<String, Object> params);

    /**
     * 新增
     *
     * @param indivVo
     * @return
     */
    Boolean saveAdd(CompanyVo indivVo);

    /**
     * 修改
     *
     * @param companyVo
     * @return
     */
    Boolean updateCompany(CompanyVo companyVo);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    CompanyVo getById(String id);
}

