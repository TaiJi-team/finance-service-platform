package com.central.user.config;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Slf4j
public class GlobalInterceptor implements HandlerInterceptor {
//public class GlobalInterceptor  {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        String secretKey = request.getHeader("from");
        String token = request.getHeader("Authorization");
        log.info("-----------------  secretkey: {}, token: {}, request uri: {} --------------- ", secretKey, token, request.getRequestURI());
        String[] arr = {"gateway", "uaaServer"};
        if(StringUtils.isAllEmpty(token, token) || (StringUtils.isNotEmpty(secretKey) && !StringUtils.containsAny(token, arr))) {
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write("error");
            log.info("-----------------  response error, request uri: {} --------------- ", request.getRequestURI());
            return false;
        }
        log.info("-----------------  response common, request uri: {} --------------- ", request.getRequestURI());
        return true;
    }

}