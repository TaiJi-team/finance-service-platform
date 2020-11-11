package com.central.finance.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.CompExtend;
import com.central.finance.mapper.CompExtendMapper;
import com.central.finance.service.ICompExtendService;

/**
 * 企业扩展表
 *
 * @author ljb
 * @date 2020-10-30 10:08:39
 */
@Slf4j
@Service
public class CompExtendServiceImpl extends SuperServiceImpl<CompExtendMapper, CompExtend> implements ICompExtendService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<CompExtend> findList(Map<String, Object> params){
        Page<CompExtend> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<CompExtend> list  =  baseMapper.findList(page, params);
        return PageResult.<CompExtend>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
