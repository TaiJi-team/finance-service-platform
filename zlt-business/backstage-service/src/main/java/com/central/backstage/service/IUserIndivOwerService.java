package com.central.backstage.service;

import com.central.backstage.model.UserCompOper;
import com.central.backstage.model.UserIndivOwer;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.List;
import java.util.Map;

/**
 * 个体户户主表
 *
 * @author ljb
 * @date 2020-11-02 15:22:44
 */
public interface IUserIndivOwerService extends ISuperService<UserIndivOwer> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<UserIndivOwer> findList(Map<String, Object> params);

    /**
     * 查询
     * @param id
     * @return
     */
    List<UserIndivOwer> findUserById(String id);

    /**
     * 新增
     * @param userIndivOwer
     * @return
     */
    Boolean saveAdd(UserIndivOwer userIndivOwer);
}

