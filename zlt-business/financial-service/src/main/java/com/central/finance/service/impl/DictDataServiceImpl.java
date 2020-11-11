package com.central.finance.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.DictData;
import com.central.finance.mapper.DictDataMapper;
import com.central.finance.service.IDictDataService;

/**
 * 字典数据表
 *
 * @author zlt
 * @date 2020-10-27 09:38:04
 */
@Slf4j
@Service
public class DictDataServiceImpl extends SuperServiceImpl<DictDataMapper, DictData> implements IDictDataService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<DictData> findList(Map<String, Object> params){
        Page<DictData> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<DictData> list  =  baseMapper.findList(page, params);
        return PageResult.<DictData>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    public List<DictData> findUserById(String id) {
        return baseMapper.selectDistById(id);
    }

    @Override
    public DictData selectDist(String id) {

        return baseMapper.selectDist(id);
    }

    @Override
    public boolean saveDictData(DictData dictData) {
        return baseMapper.saveDictData(dictData);
    }
}
