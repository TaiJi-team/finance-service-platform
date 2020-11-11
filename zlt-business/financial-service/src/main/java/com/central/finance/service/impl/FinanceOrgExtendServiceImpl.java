package com.central.finance.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.FinanceOrgExtend;
import com.central.finance.mapper.FinanceOrgExtendMapper;
import com.central.finance.service.IFinanceOrgExtendService;

/**
 * 金融机构扩展表
 *
 * @author ljb
 * @date 2020-10-30 11:08:20
 */
@Slf4j
@Service
public class FinanceOrgExtendServiceImpl extends SuperServiceImpl<FinanceOrgExtendMapper, FinanceOrgExtend> implements IFinanceOrgExtendService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<FinanceOrgExtend> findList(Map<String, Object> params){
        Page<FinanceOrgExtend> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<FinanceOrgExtend> list  =  baseMapper.findList(page, params);
        return PageResult.<FinanceOrgExtend>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
