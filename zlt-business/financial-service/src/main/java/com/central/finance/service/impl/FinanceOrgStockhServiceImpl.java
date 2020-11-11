package com.central.finance.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.FinanceOrgStockh;
import com.central.finance.mapper.FinanceOrgStockhMapper;
import com.central.finance.service.IFinanceOrgStockhService;

/**
 * 金融机构股东表
 *
 * @author ljb
 * @date 2020-10-30 11:08:24
 */
@Slf4j
@Service
public class FinanceOrgStockhServiceImpl extends SuperServiceImpl<FinanceOrgStockhMapper, FinanceOrgStockh> implements IFinanceOrgStockhService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<FinanceOrgStockh> findList(Map<String, Object> params){
        Page<FinanceOrgStockh> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<FinanceOrgStockh> list  =  baseMapper.findList(page, params);
        return PageResult.<FinanceOrgStockh>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
