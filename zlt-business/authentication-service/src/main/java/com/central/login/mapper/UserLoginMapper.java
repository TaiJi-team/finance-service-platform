package com.central.login.mapper;

import com.central.login.model.User;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 一般用户表
 *
 * @author yzb
 * @date 2020-10-29 15:52:09
 */
@Mapper
public interface UserLoginMapper extends SuperMapper<User> {
    /**
     * 分页查询用户列表
     *
     * @param page
     * @param params
     * @return
     */
    List<User> findList(Page<User> page, @Param("p") Map<String, Object> params);

    /**
     * 通过手机号查询对应用户
     *
     * @param mobile
     * @return
     */
    User selectByPhone(String mobile);

    /**
     * 通过id查询对应用户
     *
     * @param id
     * @return
     */
    User selectUserById(Long id);

    /**
     * 添加用户
     *
     * @param user
     */
    void insertUser(User user);
}
