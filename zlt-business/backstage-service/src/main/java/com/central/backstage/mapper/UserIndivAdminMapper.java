package com.central.backstage.mapper;

import com.central.backstage.model.UserIndivAdmin;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 个体户管理员表
 * 
 * @author ljb
 * @date 2020-11-02 15:22:48
 */
@Mapper
public interface UserIndivAdminMapper extends SuperMapper<UserIndivAdmin> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<UserIndivAdmin> findList(Page<UserIndivAdmin> page, @Param("p") Map<String, Object> params);
}
