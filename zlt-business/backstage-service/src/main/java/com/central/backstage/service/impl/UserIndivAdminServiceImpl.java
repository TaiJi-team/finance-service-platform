package com.central.backstage.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserIndivAdmin;
import com.central.backstage.mapper.UserIndivAdminMapper;
import com.central.backstage.service.IUserIndivAdminService;

/**
 * 个体户管理员表
 *
 * @author ljb
 * @date 2020-11-02 15:22:48
 */
@Slf4j
@Service
public class UserIndivAdminServiceImpl extends SuperServiceImpl<UserIndivAdminMapper, UserIndivAdmin> implements IUserIndivAdminService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<UserIndivAdmin> findList(Map<String, Object> params){
        Page<UserIndivAdmin> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<UserIndivAdmin> list  =  baseMapper.findList(page, params);
        return PageResult.<UserIndivAdmin>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
