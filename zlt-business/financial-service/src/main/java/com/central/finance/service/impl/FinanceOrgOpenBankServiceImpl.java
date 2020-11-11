package com.central.finance.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.FinanceOrgOpenBank;
import com.central.finance.mapper.FinanceOrgOpenBankMapper;
import com.central.finance.service.IFinanceOrgOpenBankService;

/**
 * 金融机构银行账户表
 *
 * @author ljb
 * @date 2020-10-30 11:08:18
 */
@Slf4j
@Service
public class FinanceOrgOpenBankServiceImpl extends SuperServiceImpl<FinanceOrgOpenBankMapper, FinanceOrgOpenBank> implements IFinanceOrgOpenBankService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<FinanceOrgOpenBank> findList(Map<String, Object> params){
        Page<FinanceOrgOpenBank> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<FinanceOrgOpenBank> list  =  baseMapper.findList(page, params);
        return PageResult.<FinanceOrgOpenBank>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
