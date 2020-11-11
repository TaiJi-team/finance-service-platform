package com.central.backstage.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserCompOper;
import com.central.backstage.mapper.UserCompOperMapper;
import com.central.backstage.service.IUserCompOperService;

/**
 * 企业经办人表
 *
 * @author ljb
 * @date 2020-10-30 18:49:31
 */
@Slf4j
@Service
public class UserCompOperServiceImpl extends SuperServiceImpl<UserCompOperMapper, UserCompOper> implements IUserCompOperService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<UserCompOper> findList(Map<String, Object> params){
        Page<UserCompOper> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<UserCompOper> list  =  baseMapper.findList(page, params);
        return PageResult.<UserCompOper>builder().data(list).code(0).count(page.getTotal()).build();
    }
    @Override
    public Boolean saveAdd(UserCompOper userCompOper){
        return baseMapper.saveAdd(userCompOper);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public List<UserCompOper> findUserById(String id){
        return baseMapper.findUserById(id);
    };

}
