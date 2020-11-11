package com.central.backstage.service;

import com.central.backstage.model.UserCompOper;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.List;
import java.util.Map;

/**
 * 企业经办人表
 *
 * @author ljb
 * @date 2020-10-30 18:49:31
 */
public interface IUserCompOperService extends ISuperService<UserCompOper> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<UserCompOper> findList(Map<String, Object> params);

    /**
     * 新增
     * @param userCompOper
     * @return
     */
     Boolean saveAdd(UserCompOper userCompOper);

    /**
     * 查询
     * @param id
     * @return
     */
    List<UserCompOper> findUserById(String id);
}

