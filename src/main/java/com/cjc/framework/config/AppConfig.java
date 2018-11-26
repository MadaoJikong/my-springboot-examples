package com.cjc.framework.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chengjunchao
 * @Date: 2018/11/23 15:29
 * @Description:
 */
@Configuration
public class AppConfig {

    @Bean
    public AuthorizeFilter getAuthorizeFilter() {
        return new AuthorizeFilter();
    }

    /**
     * 登录拦截
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean getWebApiFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //登录过滤器
        registrationBean.setFilter(getAuthorizeFilter());
        List<String> urlPatterns = new ArrayList<String>();
        //拦截路径，可以添加多个
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    /**
     * restTemplate配置
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
