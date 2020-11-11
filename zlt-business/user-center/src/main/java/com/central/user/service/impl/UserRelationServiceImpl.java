package com.central.user.service.impl;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import com.central.common.utils.Sequence;
import com.central.common.utils.SpringUtil;
import com.central.user.config.RoleState;
import com.central.user.model.UserRole;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.user.model.UserRelation;
import com.central.user.mapper.UserRelationMapper;
import com.central.user.service.IUserRelationService;

/**
 * 用户关联表
 *
 * @author yzb
 * @date 2020-11-07 22:59:38
 */
@Slf4j
@Service
public class UserRelationServiceImpl extends SuperServiceImpl<UserRelationMapper, UserRelation> implements IUserRelationService {

    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<UserRelation> findList(Map<String, Object> params){
        Page<UserRelation> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<UserRelation> list  =  baseMapper.findList(page, params);
        return PageResult.<UserRelation>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    public void saveRelation(UserRelation userRelation) {
        //雪花算法生成id
        Sequence sequence = new Sequence();
        userRelation.setId(sequence.nextId());
        baseMapper.saveRelation(userRelation);
       //存入用户角色表中
       if(userRelation.getUserId()!= null){
           UserRole userRole = new UserRole();
           userRole.setUserId(userRelation.getUserId());
           //个人角色
           if(RoleState.PERSONAL_STATE.equals(userRelation.getEnterpType())){
                userRole.setRoleId(RoleState.PERSONAL_ID);
           }
           //企业角色
           if(RoleState.COMPANYL_STATE.equals(userRelation.getEnterpType())){
                userRole.setRoleId(RoleState.COMPANYL_ID);
           }
           //机构角色
           if(RoleState.ORG_STATE.equals(userRelation.getEnterpType())){
               userRole.setRoleId(RoleState.ORG_ID);
           }
           baseMapper.saveUserRole(userRole);
       }

    }

    @Override
    public void updateRelation(UserRelation userRelation) {
        baseMapper.updateRelation(userRelation);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public List<UserRelation> findUserById(String  id) {
        return baseMapper.findUserById(id);
    }
}
