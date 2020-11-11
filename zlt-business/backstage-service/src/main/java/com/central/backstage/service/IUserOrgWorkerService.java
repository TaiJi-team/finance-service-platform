package com.central.backstage.service;

import com.central.backstage.model.UserOrgWorker;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 机构业务员表
 *
 * @author ljb
 * @date 2020-11-02 15:23:54
 */
public interface IUserOrgWorkerService extends ISuperService<UserOrgWorker> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<UserOrgWorker> findList(Map<String, Object> params);

    /**
     * 新增业务员信息
     * @param userOrgWorker
     */
    void saveWork(UserOrgWorker userOrgWorker);
}

