package com.cjc.framework.config;

import com.cjc.framework.core.constant.Const;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: chengjunchao
 * @Date: 2018/11/23 15:30
 * @Description:
 */
@Component
@Slf4j
public class AuthorizeFilter implements Filter {
    private String excludesStr = "/";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        //获取客户端ip
        String clientIp = request.getRemoteAddr();
        //是否校验 监控路由 true校验
//        String[] excludes = excludesStr.split(",");
//        for (String exclude : excludes) {
//            if (uri.matches(exclude)) {
//                redirectLogin(request, response);
//                return;
//            }
//        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private void redirectLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (Const.DictValue.AJAXVALUE.equals(request.getHeader(Const.DictValue.AJAXHEADER))) {
            response.setStatus(499);
            response.getWriter().write("timeout");
        } else {
            response.sendRedirect("login.html");
        }
        response.getWriter().flush();
    }
}
