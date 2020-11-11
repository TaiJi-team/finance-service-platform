package com.central.backstage.service.impl;

import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.Menu;
import com.central.backstage.mapper.MenuMapper;
import com.central.backstage.service.IMenuService;

/**
 * 系统菜单表
 *
 * @author yzb
 * @date 2020-11-04 11:21:15
 */
@Slf4j
@Service
public class MenuServiceImpl extends SuperServiceImpl<MenuMapper, Menu> implements IMenuService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<Menu> findList(Map<String, Object> params){
        Page<Menu> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<Menu> list  =  baseMapper.findList(page, params);
        return PageResult.<Menu>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
