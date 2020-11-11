package com.central.finance.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.IndivExtend;
import com.central.finance.mapper.IndivExtendMapper;
import com.central.finance.service.IIndivExtendService;

/**
 * 个体户企业扩展表
 *
 * @author ljb
 * @date 2020-10-30 10:06:48
 */
@Slf4j
@Service
public class IndivExtendServiceImpl extends SuperServiceImpl<IndivExtendMapper, IndivExtend> implements IIndivExtendService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<IndivExtend> findList(Map<String, Object> params){
        Page<IndivExtend> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<IndivExtend> list  =  baseMapper.findList(page, params);
        return PageResult.<IndivExtend>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
