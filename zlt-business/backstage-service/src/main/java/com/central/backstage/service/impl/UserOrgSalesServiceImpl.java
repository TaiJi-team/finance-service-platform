package com.central.backstage.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserOrgSales;
import com.central.backstage.mapper.UserOrgSalesMapper;
import com.central.backstage.service.IUserOrgSalesService;

/**
 * 运营机构推广员表
 *
 * @author ljb
 * @date 2020-11-02 15:23:52
 */
@Slf4j
@Service
public class UserOrgSalesServiceImpl extends SuperServiceImpl<UserOrgSalesMapper, UserOrgSales> implements IUserOrgSalesService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<UserOrgSales> findList(Map<String, Object> params){
        Page<UserOrgSales> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<UserOrgSales> list  =  baseMapper.findList(page, params);
        return PageResult.<UserOrgSales>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
