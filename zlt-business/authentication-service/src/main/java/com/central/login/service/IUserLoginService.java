package com.central.login.service;

import com.central.login.model.User;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 一般用户表
 *
 * @author yzb
 * @date 2020-10-29 15:52:09
 */
public interface IUserLoginService extends ISuperService<User> {
    /**
     * 列表
     *
     * @param params
     * @return
     */
    PageResult<User> findList(Map<String, Object> params);

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    String userRegister(User user);

    /**
     * 用户登录
     *
     * @param user
     * @param vckey1
     * @return
     */
    Object userLogin(User user, String vckey1);

    /**
     * 通过id查询对应的用户
     *
     * @param id
     * @return
     */
    User findUserById(Long id);
}

