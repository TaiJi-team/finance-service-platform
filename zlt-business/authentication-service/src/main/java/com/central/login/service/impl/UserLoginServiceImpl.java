package com.central.login.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.central.common.redis.template.RedisRepository;
import com.central.common.utils.Md5Util;
import com.central.common.utils.RegexUtils;
import com.central.common.utils.Sequence;
import com.central.login.config.tokenService;
import com.central.login.mapper.UserLoginMapper;
import com.central.login.service.IUserLoginService;
import jodd.util.CollectionUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.login.model.User;
import com.central.login.mapper.UserLoginMapper;
import com.central.login.service.IUserLoginService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 一般用户表
 *
 * @author yzb
 * @date 2020-10-29 15:52:09
 */
@Slf4j
@Service
public class UserLoginServiceImpl extends SuperServiceImpl<UserLoginMapper, User> implements IUserLoginService {

    @Autowired
    private RedisRepository redisRepository;
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<User> findList(Map<String, Object> params){
        Page<User> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<User> list  =  baseMapper.findList(page, params);
        return PageResult.<User>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    public String userRegister(User user) {
        if(StringUtil.isBlank(user.getUserName()) || !RegexUtils.isName(user.getUserName())){
            return "用户名为空或格式错误";
        }
        if(StringUtil.isBlank(user.getMobile()) || !RegexUtils.isPhone(user.getMobile())){
            return "手机号为空或格式错误";
        }
        if(StringUtil.isBlank(user.getPassword()) || !RegexUtils.isPassword(user.getPassword())){
            return "密码为空或格式错误";
        }
        //if (user.getVerify()== null && user.getVerify().toString()!="验证码方法获取验证码"){
            //return "手机验证码错误";
        //}
        //查询手机号是否被注册
       User userPhone =  baseMapper.selectByPhone(user.getMobile());
       if(userPhone==null){
           //雪花算法生成id
           Sequence sequence = new Sequence();
           user.setId(sequence.nextId());
           user.setRegDate(new Date());
           user.setEnabled(1);
           user.setIsDel(0);
           user.setPassword(Md5Util.md5(user.getPassword()));
           baseMapper.insertUser(user);
           return "注册成功";
       }else {
           return "手机号已被注册";
       }

    }

    @Override
    public Object userLogin(User user,String vckey) {
        JSONObject jsonObject=new JSONObject();
        if(!RegexUtils.isPhone(user.getMobile()) || StringUtils.isEmpty(user.getMobile())){
            return jsonObject.put("message","手机号为空或格式错误");
        }
        if(!RegexUtils.isPassword(user.getPassword()) || StringUtils.isEmpty(user.getPassword()) ){
            return jsonObject.put("message","密码为空或格式错误");
        }
        if(StringUtils.isEmpty(user.getVerify())){
            return jsonObject.put("message","验证码为空或格式错误");
        }
       /* if(StringUtils.isEmpty(user.getVerify()) || !user.getVerify().equals("验证码方法获取")){
            return "手机验证码错误";
        }*/
        String value =  (String)redisRepository.get(vckey);
        if(!user.getVerify().equals(value)){
            return jsonObject.put("message","输入验证码有误");
        }
       User user1 =  baseMapper.selectByPhone(user.getMobile());
       if(user1!=null){
           if(user1.getPassword().equals(Md5Util.md5(user.getPassword()))){
               String token = tokenService.getToken(user1);
               jsonObject.put("token", token);
               jsonObject.put("user", user1);
               jsonObject.put("message","登录成功");
             return  jsonObject;
           }
            return jsonObject.put("message","账号或密码错误");
       }
        return jsonObject.put("message","登录失败,用户不存在");
    }

    @Override
    public User findUserById(Long id) {

        return baseMapper.selectUserById(id);
    }
}
