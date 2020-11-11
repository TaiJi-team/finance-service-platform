package com.central.backstage.service;

import com.central.backstage.model.UserCompAdmin;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 企业管理员表
 *
 * @author ljb
 * @date 2020-11-02 15:21:18
 */
public interface IUserCompAdminService extends ISuperService<UserCompAdmin> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<UserCompAdmin> findList(Map<String, Object> params);
}

