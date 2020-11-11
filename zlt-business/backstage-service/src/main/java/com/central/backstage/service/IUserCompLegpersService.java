package com.central.backstage.service;

import com.central.backstage.model.UserCompLegpers;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.List;
import java.util.Map;

/**
 * 企业管法人代表表
 *
 * @author ljb
 * @date 2020-11-02 15:21:07
 */
public interface IUserCompLegpersService extends ISuperService<UserCompLegpers> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<UserCompLegpers> findList(Map<String, Object> params);

    /**
     * 查询
     * @param id
     * @return
     */
    List<UserCompLegpers> findUserById(String id);

    /**
     * 新增
     * @param userCompLegpers
     * @return
     */
    Boolean saveAdd(UserCompLegpers userCompLegpers);
}

