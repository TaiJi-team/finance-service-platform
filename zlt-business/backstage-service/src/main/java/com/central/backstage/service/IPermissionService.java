package com.central.backstage.service;

import com.central.backstage.model.Permission;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 权限表
 *
 * @author yzb
 * @date 2020-11-04 11:14:33
 */
public interface IPermissionService extends ISuperService<Permission> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<Permission> findList(Map<String, Object> params);
}

