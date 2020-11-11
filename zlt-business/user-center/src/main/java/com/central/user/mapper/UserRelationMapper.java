package com.central.user.mapper;

import com.central.user.model.UserRelation;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.user.model.UserRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户关联表
 *
 * @author yzb
 * @date 2020-11-07 22:59:38
 */
@Mapper
public interface UserRelationMapper extends SuperMapper<UserRelation> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<UserRelation> findList(Page<UserRelation> page, @Param("p") Map<String, Object> params);

    /**
     *增加sys_user_relation表
     * @param userRelation
     * @return
     */
    void saveRelation(UserRelation userRelation);
    /**
     *增加sys_user_role表
     * @param userRole
     * @return
     */
    void saveUserRole(UserRole userRole);
    /**
     *修改sys_user_relation表
     * @param userRelation
     * @return
     */
    void updateRelation(UserRelation userRelation);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    List<UserRelation> findUserById(String id);
}
