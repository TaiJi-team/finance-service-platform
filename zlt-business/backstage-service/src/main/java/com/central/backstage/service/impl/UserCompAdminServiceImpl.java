package com.central.backstage.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserCompAdmin;
import com.central.backstage.mapper.UserCompAdminMapper;
import com.central.backstage.service.IUserCompAdminService;

/**
 * 企业管理员表
 *
 * @author ljb
 * @date 2020-11-02 15:21:18
 */
@Slf4j
@Service
public class UserCompAdminServiceImpl extends SuperServiceImpl<UserCompAdminMapper, UserCompAdmin> implements IUserCompAdminService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<UserCompAdmin> findList(Map<String, Object> params){
        Page<UserCompAdmin> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<UserCompAdmin> list  =  baseMapper.findList(page, params);
        return PageResult.<UserCompAdmin>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
