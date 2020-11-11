package com.central.backstage.service;

import com.central.backstage.model.UserOrgProdmanag;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 机构产品经理表
 *
 * @author ljb
 * @date 2020-11-02 15:23:55
 */
public interface IUserOrgProdmanagService extends ISuperService<UserOrgProdmanag> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<UserOrgProdmanag> findList(Map<String, Object> params);

    /**
     * 指定产品经理新增
     * @param userOrgProdmanag
     * @return
     */
    Boolean saveManage(UserOrgProdmanag userOrgProdmanag);
}

