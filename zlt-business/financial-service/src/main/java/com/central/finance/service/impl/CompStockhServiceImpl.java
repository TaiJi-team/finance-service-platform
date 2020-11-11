package com.central.finance.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.CompStockh;
import com.central.finance.mapper.CompStockhMapper;
import com.central.finance.service.ICompStockhService;

/**
 * 企业股东表
 *
 * @author ljb
 * @date 2020-10-30 10:08:33
 */
@Slf4j
@Service
public class CompStockhServiceImpl extends SuperServiceImpl<CompStockhMapper, CompStockh> implements ICompStockhService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<CompStockh> findList(Map<String, Object> params){
        Page<CompStockh> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<CompStockh> list  =  baseMapper.findList(page, params);
        return PageResult.<CompStockh>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
