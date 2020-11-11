package com.central.backstage.service;

import com.central.backstage.model.Role;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 角色表
 *
 * @author yzb
 * @date 2020-11-04 11:13:41
 */
public interface IRoleService extends ISuperService<Role> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<Role> findList(Map<String, Object> params);

    Role seleRoleById(Integer id);

    void deleRoleById(Integer id);
}

