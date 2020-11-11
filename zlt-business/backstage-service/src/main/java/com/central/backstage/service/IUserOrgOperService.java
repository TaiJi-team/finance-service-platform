package com.central.backstage.service;

import com.central.backstage.model.UserCompOper;
import com.central.backstage.model.UserOrgOper;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.List;
import java.util.Map;

/**
 * 机构经办人表
 *
 * @author ljb
 * @date 2020-11-02 15:23:56
 */
public interface IUserOrgOperService extends ISuperService<UserOrgOper> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<UserOrgOper> findList(Map<String, Object> params);

    /**
     * 查询
     * @param id
     * @return
     */
    List<UserOrgOper> findUserById(String id);

    /**
     * 新增
     * @param userOrgOper
     * @return
     */
    Boolean saveAdd(UserOrgOper userOrgOper);
}

