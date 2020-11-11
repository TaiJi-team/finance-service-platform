package com.central.backstage.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserCompLegpers;
import com.central.backstage.mapper.UserCompLegpersMapper;
import com.central.backstage.service.IUserCompLegpersService;

/**
 * 企业管法人代表表
 *
 * @author ljb
 * @date 2020-11-02 15:21:07
 */
@Slf4j
@Service
public class UserCompLegpersServiceImpl extends SuperServiceImpl<UserCompLegpersMapper, UserCompLegpers> implements IUserCompLegpersService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<UserCompLegpers> findList(Map<String, Object> params){
        Page<UserCompLegpers> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<UserCompLegpers> list  =  baseMapper.findList(page, params);
        return PageResult.<UserCompLegpers>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    public List<UserCompLegpers> findUserById(String id){
        return baseMapper.findUserById(id);
    }

    /**
     * 新增
     * @param userCompLegpers
     * @return
     */
    @Override
    public Boolean saveAdd(UserCompLegpers userCompLegpers) {
        return baseMapper.saveAdd(userCompLegpers);
    }

}
