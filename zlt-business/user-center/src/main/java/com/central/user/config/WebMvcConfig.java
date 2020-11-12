package com.central.user.config;

import com.central.common.config.DefaultWebMvcConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @author zlt
 * @date 2019/8/5
 */
@Configuration
public class WebMvcConfig extends DefaultWebMvcConfig {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        GlobalInterceptor interceptor = new GlobalInterceptor();
//        interceptor.setRedisUUID(redisUUID);
//        interceptor.setAuthIgnoreConfig(applicationContext.getBean(AuthIgnoreConfig.class));
//        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }
}
