package com.central.backstage.service;

import com.central.backstage.model.UserOrgSales;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 运营机构推广员表
 *
 * @author ljb
 * @date 2020-11-02 15:23:52
 */
public interface IUserOrgSalesService extends ISuperService<UserOrgSales> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<UserOrgSales> findList(Map<String, Object> params);
}

