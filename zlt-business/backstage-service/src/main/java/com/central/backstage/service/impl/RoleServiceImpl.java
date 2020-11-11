package com.central.backstage.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.Role;
import com.central.backstage.mapper.RoleMapper;
import com.central.backstage.service.IRoleService;

/**
 * 角色表
 *
 * @author yzb
 * @date 2020-11-04 11:13:41
 */
@Slf4j
@Service
public class RoleServiceImpl extends SuperServiceImpl<RoleMapper, Role> implements IRoleService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<Role> findList(Map<String, Object> params){
        Page<Role> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<Role> list  =  baseMapper.findList(page, params);
        return PageResult.<Role>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    public Role seleRoleById(Integer id) {
        return baseMapper.seleRoleById(id);
    }

    @Override
    public void deleRoleById(Integer id) {
        baseMapper.deleRoleById(id);
    }
}
