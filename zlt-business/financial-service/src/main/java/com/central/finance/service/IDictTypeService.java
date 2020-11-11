package com.central.finance.service;

import com.central.finance.model.DictType;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;
import com.central.finance.model.DictType;

import java.util.List;
import java.util.Map;

/**
 * 字典类型表
 *
 * @author zlt
 * @date 2020-10-27 09:36:44
 */
public interface IDictTypeService extends ISuperService<DictType> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<DictType> findList(Map<String, Object> params);

    List<DictType> seleDictType();
}

