package com.central.backstage.service;

import com.central.backstage.model.UserIndivAdmin;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 个体户管理员表
 *
 * @author ljb
 * @date 2020-11-02 15:22:48
 */
public interface IUserIndivAdminService extends ISuperService<UserIndivAdmin> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<UserIndivAdmin> findList(Map<String, Object> params);
}

