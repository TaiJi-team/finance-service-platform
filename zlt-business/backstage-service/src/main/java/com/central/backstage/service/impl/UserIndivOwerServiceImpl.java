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

import com.central.backstage.model.UserIndivOwer;
import com.central.backstage.mapper.UserIndivOwerMapper;
import com.central.backstage.service.IUserIndivOwerService;

/**
 * 个体户户主表
 *
 * @author ljb
 * @date 2020-11-02 15:22:44
 */
@Slf4j
@Service
public class UserIndivOwerServiceImpl extends SuperServiceImpl<UserIndivOwerMapper, UserIndivOwer> implements IUserIndivOwerService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<UserIndivOwer> findList(Map<String, Object> params){
        Page<UserIndivOwer> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<UserIndivOwer> list  =  baseMapper.findList(page, params);
        return PageResult.<UserIndivOwer>builder().data(list).code(0).count(page.getTotal()).build();
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public List<UserIndivOwer> findUserById(String id){
        return baseMapper.findUserById(id);
    }


    /**
     * 新增
     * @param userIndivOwer
     * @return
     */
    @Override
    public Boolean saveAdd(UserIndivOwer userIndivOwer) {
        return baseMapper.saveAdd(userIndivOwer);
    };
}
