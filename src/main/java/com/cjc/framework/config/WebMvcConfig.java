package com.cjc.framework.config;

import com.cjc.framework.config.authorization.AuthorizeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * spring mvc配置
 *
 * @author: chengjunchao
 * @date: 2018/11/23 13:57
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Bean
    public AuthorizeInterceptor getAuthorizeInterceptor() {
        return new AuthorizeInterceptor();
    }

    /**
     * 功能描述: 拦截器配置 用来做权限等，今后不在过滤器中做
     *
     * @param registry
     * @return: void
     * @author: chengjunchao
     * @date: 2018/6/13 9:46
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthorizeInterceptor()).addPathPatterns("/**");
    }
}
