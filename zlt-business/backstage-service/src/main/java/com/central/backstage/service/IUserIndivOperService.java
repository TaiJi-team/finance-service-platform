package com.central.backstage.service;

import com.central.backstage.model.UserCompOper;
import com.central.backstage.model.UserIndivOper;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.List;
import java.util.Map;

/**
 * 个体户经办人表
 *
 * @author ljb
 * @date 2020-11-02 15:22:46
 */
public interface IUserIndivOperService extends ISuperService<UserIndivOper> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<UserIndivOper> findList(Map<String, Object> params);

    /**
     * 查询
     * @param id
     * @return
     */
    List<UserIndivOper> findUserById(String id);

    /**
     * 新增
     * @param userIndivOper
     * @return
     */
    Boolean saveAdd(UserIndivOper userIndivOper);
}

