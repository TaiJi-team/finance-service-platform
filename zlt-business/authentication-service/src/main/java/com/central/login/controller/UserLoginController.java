package com.central.login.controller;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import cn.hutool.core.util.IdUtil;
import com.central.common.redis.template.RedisRepository;
import com.central.common.utils.VerifyCode;
import com.central.login.config.PassToken;
import com.central.login.config.UserLoginToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.login.model.User;
import com.central.login.service.IUserLoginService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

import javax.imageio.ImageIO;
import javax.servlet.http.*;
import javax.swing.*;

/**
 * 一般用户表
 *
 * @author yzb
 * @date 2020-10-29 15:52:09
 */
@Slf4j
@RestController
@RequestMapping("/userLogin")
@Api(tags = "一般用户表")
public class UserLoginController extends HttpServlet implements HttpSessionListener {

    @Autowired
    private IUserLoginService userService;
    @Autowired
    private RedisRepository redisRepository;
    /**
     * 保存生成验证码文本
     */
    private static String vckey;


    /**
     * 列表
     */
    @PassToken
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public PageResult list(@RequestParam Map<String, Object> params) {
        return userService.findList(params);
    }

    /**
     * 验证码
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/verifyCode")
    @ResponseBody
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        VerifyCode code = new VerifyCode();
        BufferedImage image = code.getImage();
        //将验证码文本存到Redis
        vckey = IdUtil.randomUUID();
        redisRepository.setExpire(vckey, code.getText(), 60);
        String value = (String) redisRepository.get(vckey);
        System.out.println(value);
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    /**
     * 前台获取验证码文本的标识
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/verifyCodeText")
    @ResponseBody
    public String verifyCodeText(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(vckey);

        return vckey;
    }

    /**
     * 登录
     */
    @ApiOperation(value = "用户登录")
    @PostMapping(path = "/userLogin")
    public Object userLogin(@RequestBody User user) {
        String vckey1 = null;
        if (StringUtils.isNotBlank(vckey)) {
            vckey1 = vckey;
        }
        return userService.userLogin(user, vckey1);
    }

    /**
     * 注册
     */
    @ApiOperation(value = "用户注册")
    @PostMapping("/userRegister")
    public Result userRegister(@RequestBody User user) {
        String msg = userService.userRegister(user);
        return Result.succeed(msg);
    }

    /**
     * 测试接口
     *
     * @return
     */
    @ApiOperation(value = "用户注册")
    @PostMapping("/user")
    @UserLoginToken
    public String user() {
        return "请求成功";
    }

}
