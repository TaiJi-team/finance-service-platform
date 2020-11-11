package com.central.backstage.mapper;

import com.central.backstage.model.UserOrgAdmin;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 机构管理员表
 * 
 * @author ljb
 * @date 2020-11-02 15:23:57
 */
@Mapper
public interface UserOrgAdminMapper extends SuperMapper<UserOrgAdmin> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<UserOrgAdmin> findList(Page<UserOrgAdmin> page, @Param("p") Map<String, Object> params);
}
