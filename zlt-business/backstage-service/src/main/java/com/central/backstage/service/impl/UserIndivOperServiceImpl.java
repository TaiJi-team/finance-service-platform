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

import com.central.backstage.model.UserIndivOper;
import com.central.backstage.mapper.UserIndivOperMapper;
import com.central.backstage.service.IUserIndivOperService;

/**
 * 个体户经办人表
 *
 * @author ljb
 * @date 2020-11-02 15:22:46
 */
@Slf4j
@Service
public class UserIndivOperServiceImpl extends SuperServiceImpl<UserIndivOperMapper, UserIndivOper> implements IUserIndivOperService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<UserIndivOper> findList(Map<String, Object> params){
        Page<UserIndivOper> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<UserIndivOper> list  =  baseMapper.findList(page, params);
        return PageResult.<UserIndivOper>builder().data(list).code(0).count(page.getTotal()).build();
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public List<UserIndivOper> findUserById(String id){
        return baseMapper.findUserById(id);
    }

    /**
     * 新增
     * @param userIndivOper
     * @return
     */
    @Override
    public Boolean saveAdd(UserIndivOper userIndivOper) {
        return baseMapper.saveAdd(userIndivOper);
    }
}
