package com.central.backstage.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.Permission;
import com.central.backstage.mapper.PermissionMapper;
import com.central.backstage.service.IPermissionService;

/**
 * 权限表
 *
 * @author yzb
 * @date 2020-11-04 11:14:33
 */
@Slf4j
@Service
public class PermissionServiceImpl extends SuperServiceImpl<PermissionMapper, Permission> implements IPermissionService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<Permission> findList(Map<String, Object> params){
        Page<Permission> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<Permission> list  =  baseMapper.findList(page, params);
        return PageResult.<Permission>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
