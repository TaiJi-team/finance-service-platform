package com.central.finance.service;

import com.central.finance.model.CompExtend;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 企业扩展表
 *
 * @author ljb
 * @date 2020-10-30 10:08:39
 */
public interface ICompExtendService extends ISuperService<CompExtend> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<CompExtend> findList(Map<String, Object> params);
}

