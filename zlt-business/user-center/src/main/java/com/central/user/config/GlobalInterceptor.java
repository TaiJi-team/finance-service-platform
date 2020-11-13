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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        String secretKey = request.getHeader("from");
        String token = request.getHeader("Authorization");
        log.info("-----------------  secretkey: {}, token: {}, request uri: {} --------------- ", secretKey, token, request.getRequestURI());
        String[] range = {"gateway", "uaaServer"};
        if(request.getRequestURI().startsWith("/users") || StringUtils.isNotEmpty(token) || (StringUtils.isNotEmpty(secretKey) && StringUtils.containsAny(secretKey, range))) {
            log.info("-----------------  response common, request uri: {} --------------- ", request.getRequestURI());
            return true;
        }
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("false");
        log.info("-----------------  response error, request uri: {} --------------- ", request.getRequestURI());
        return false;
    }

}