package com.central.finance.service;

import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;
import com.central.finance.model.IndivHouseh;
import com.central.finance.model.IndivVo;

import java.util.List;
import java.util.Map;

/**
 * 个体户企业表
 *
 * @author zlt
 * @date 2020-10-27 16:21:31
 */
public interface IndivHousehService extends ISuperService<IndivHouseh> {
    /**
     * 列表
     *
     * @param params
     * @return
     */
    PageResult<IndivHouseh> findList(Map<String, Object> params);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    IndivVo getById(String id);


    /**
     * 新增
     *
     * @param indivVo
     * @return
     */
    Boolean saveAdd(IndivVo indivVo);

    /**
     * 修改
     *
     * @param indivVo
     * @return
     */
    Boolean updateIndiv(IndivVo indivVo);
}

