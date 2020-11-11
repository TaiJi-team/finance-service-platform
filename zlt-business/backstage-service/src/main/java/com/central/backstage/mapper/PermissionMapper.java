package com.central.backstage.mapper;

import com.central.backstage.model.Permission;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 权限表
 * 
 * @author yzb
 * @date 2020-11-04 11:14:33
 */
@Mapper
public interface PermissionMapper extends SuperMapper<Permission> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<Permission> findList(Page<Permission> page, @Param("p") Map<String, Object> params);
}
