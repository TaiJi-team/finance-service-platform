package com.central.backstage.mapper;

import com.central.backstage.model.Menu;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 系统菜单表
 * 
 * @author yzb
 * @date 2020-11-04 11:21:15
 */
@Mapper
public interface MenuMapper extends SuperMapper<Menu> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<Menu> findList(Page<Menu> page, @Param("p") Map<String, Object> params);
}
