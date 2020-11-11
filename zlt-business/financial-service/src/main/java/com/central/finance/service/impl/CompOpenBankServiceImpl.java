package com.central.finance.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.CompOpenBank;
import com.central.finance.mapper.CompOpenBankMapper;
import com.central.finance.service.ICompOpenBankService;

/**
 * 企业银行账户表
 *
 * @author ljb
 * @date 2020-10-30 10:08:35
 */
@Slf4j
@Service
public class CompOpenBankServiceImpl extends SuperServiceImpl<CompOpenBankMapper, CompOpenBank> implements ICompOpenBankService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<CompOpenBank> findList(Map<String, Object> params){
        Page<CompOpenBank> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<CompOpenBank> list  =  baseMapper.findList(page, params);
        return PageResult.<CompOpenBank>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
