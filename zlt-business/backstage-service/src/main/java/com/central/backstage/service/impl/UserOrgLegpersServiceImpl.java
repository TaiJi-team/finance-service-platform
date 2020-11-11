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

import com.central.backstage.model.UserOrgLegpers;
import com.central.backstage.mapper.UserOrgLegpersMapper;
import com.central.backstage.service.IUserOrgLegpersService;

/**
 * 机构法人代表表
 *
 * @author ljb
 * @date 2020-11-02 15:24:07
 */
@Slf4j
@Service
public class UserOrgLegpersServiceImpl extends SuperServiceImpl<UserOrgLegpersMapper, UserOrgLegpers> implements IUserOrgLegpersService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<UserOrgLegpers> findList(Map<String, Object> params){
        Page<UserOrgLegpers> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<UserOrgLegpers> list  =  baseMapper.findList(page, params);
        return PageResult.<UserOrgLegpers>builder().data(list).code(0).count(page.getTotal()).build();
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public List<UserOrgLegpers> findUserById(String id){
        return baseMapper.findUserById(id);
    }

    /**
     * 新增
     * @param userOrgLegpers
     * @return
     */
    @Override
    public Boolean saveAdd(UserOrgLegpers userOrgLegpers) {
        return baseMapper.saveAdd(userOrgLegpers);
    }
}
