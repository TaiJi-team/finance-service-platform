package com.central.finance.service;

import com.central.finance.model.DictData;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.List;
import java.util.Map;

/**
 * 字典数据表
 *
 * @author zlt
 * @date 2020-10-27 09:38:04
 */
public interface IDictDataService extends ISuperService<DictData> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<DictData> findList(Map<String, Object> params);

    List<DictData> findUserById(String id);

    DictData selectDist(String id);

    boolean saveDictData(DictData dictData);
}

