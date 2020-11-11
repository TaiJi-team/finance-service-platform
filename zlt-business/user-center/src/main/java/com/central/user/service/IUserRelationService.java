package com.central.user.service;

import com.central.user.model.UserRelation;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.List;
import java.util.Map;

/**
 * 用户关联表
 *
 * @author yzb
 * @date 2020-11-07 22:59:38
 */
public interface IUserRelationService extends ISuperService<UserRelation> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<UserRelation> findList(Map<String, Object> params);

    /**
     * 入驻认证添加用户关联表
     * @param userRelation
     */
    void saveRelation(UserRelation userRelation);
    /**
     * 入驻认证修改用户关联表
     * @param userRelation
     */
    void updateRelation(UserRelation userRelation);

    /**
     * 查询
     * @param id
     * @return
     */
    List<UserRelation> findUserById(String  id);
}

