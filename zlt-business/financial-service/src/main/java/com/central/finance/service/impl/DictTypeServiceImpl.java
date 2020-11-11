package com.central.finance.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.DictType;
import com.central.finance.mapper.DictTypeMapper;
import com.central.finance.service.IDictTypeService;

/**
 * 字典类型表
 *
 * @author zlt
 * @date 2020-10-27 09:36:44
 */
@Slf4j
@Service
public class DictTypeServiceImpl extends SuperServiceImpl<DictTypeMapper, DictType> implements IDictTypeService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<DictType> findList(Map<String, Object> params){
        Page<DictType> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<DictType> list  =  baseMapper.findList(page, params);
        return PageResult.<DictType>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    public List<DictType> seleDictType() {
        return baseMapper.seleDictType();
    }


}
