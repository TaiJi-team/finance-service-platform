package com.central.backstage.service;

import com.central.backstage.model.UserOrgAdmin;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 机构管理员表
 *
 * @author ljb
 * @date 2020-11-02 15:23:57
 */
public interface IUserOrgAdminService extends ISuperService<UserOrgAdmin> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<UserOrgAdmin> findList(Map<String, Object> params);
}

