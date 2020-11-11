package com.central.backstage.service.impl;

import com.central.backstage.model.UserCompOper;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserOrgOper;
import com.central.backstage.mapper.UserOrgOperMapper;
import com.central.backstage.service.IUserOrgOperService;

/**
 * 机构经办人表
 *
 * @author ljb
 * @date 2020-11-02 15:23:56
 */
@Slf4j
@Service
public class UserOrgOperServiceImpl extends SuperServiceImpl<UserOrgOperMapper, UserOrgOper> implements IUserOrgOperService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<UserOrgOper> findList(Map<String, Object> params){
        Page<UserOrgOper> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<UserOrgOper> list  =  baseMapper.findList(page, params);
        return PageResult.<UserOrgOper>builder().data(list).code(0).count(page.getTotal()).build();
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public List<UserOrgOper> findUserById(String id){
        return baseMapper.findUserById(id);
    }

    /**
     * 新增
     * @param userOrgOper
     * @return
     */
    @Override
    public Boolean saveAdd(UserOrgOper userOrgOper) {
        return baseMapper.saveAdd(userOrgOper);
    }
}
