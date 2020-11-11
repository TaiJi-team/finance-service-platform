package com.central.backstage.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserOrgAdmin;
import com.central.backstage.mapper.UserOrgAdminMapper;
import com.central.backstage.service.IUserOrgAdminService;

/**
 * 机构管理员表
 *
 * @author ljb
 * @date 2020-11-02 15:23:57
 */
@Slf4j
@Service
public class UserOrgAdminServiceImpl extends SuperServiceImpl<UserOrgAdminMapper, UserOrgAdmin> implements IUserOrgAdminService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<UserOrgAdmin> findList(Map<String, Object> params){
        Page<UserOrgAdmin> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<UserOrgAdmin> list  =  baseMapper.findList(page, params);
        return PageResult.<UserOrgAdmin>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
