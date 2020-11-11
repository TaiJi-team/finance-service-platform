package com.central.finance.service;

import com.central.finance.model.IndivExtend;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 个体户企业扩展表
 *
 * @author ljb
 * @date 2020-10-30 10:06:48
 */
public interface IIndivExtendService extends ISuperService<IndivExtend> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<IndivExtend> findList(Map<String, Object> params);
}

