package com.central.backstage.service;

import com.central.backstage.model.UserCompOper;
import com.central.backstage.model.UserOrgLegpers;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.List;
import java.util.Map;

/**
 * 机构法人代表表
 *
 * @author ljb
 * @date 2020-11-02 15:24:07
 */
public interface IUserOrgLegpersService extends ISuperService<UserOrgLegpers> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<UserOrgLegpers> findList(Map<String, Object> params);

    /**
     * 查询
     * @param id
     * @return
     */
    List<UserOrgLegpers> findUserById(String id);

    /**
     * 新增
     * @param userOrgLegpers
     * @return
     */
    Boolean saveAdd(UserOrgLegpers userOrgLegpers);
}

