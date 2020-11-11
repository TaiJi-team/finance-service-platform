package com.central.backstage.service;

import com.central.backstage.model.Menu;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import java.util.Map;

/**
 * 系统菜单表
 *
 * @author yzb
 * @date 2020-11-04 11:21:15
 */
public interface IMenuService extends ISuperService<Menu> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<Menu> findList(Map<String, Object> params);
}

