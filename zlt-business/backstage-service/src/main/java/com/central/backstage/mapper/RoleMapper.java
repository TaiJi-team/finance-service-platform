package com.central.backstage.mapper;

import com.central.backstage.model.Role;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 角色表
 * 
 * @author yzb
 * @date 2020-11-04 11:13:41
 */
@Mapper
public interface RoleMapper extends SuperMapper<Role> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<Role> findList(Page<Role> page, @Param("p") Map<String, Object> params);

    Role seleRoleById(Integer id);

    void deleRoleById(Integer id);
}
