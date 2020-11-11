package com.central.finance.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.IndivOpenBank;
import com.central.finance.mapper.IndivOpenBankMapper;
import com.central.finance.service.IIndivOpenBankService;

/**
 * 个体户企业银行账户表
 *
 * @author ljb
 * @date 2020-10-30 10:06:46
 */
@Slf4j
@Service
public class IndivOpenBankServiceImpl extends SuperServiceImpl<IndivOpenBankMapper, IndivOpenBank> implements IIndivOpenBankService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<IndivOpenBank> findList(Map<String, Object> params){
        Page<IndivOpenBank> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<IndivOpenBank> list  =  baseMapper.findList(page, params);
        return PageResult.<IndivOpenBank>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
