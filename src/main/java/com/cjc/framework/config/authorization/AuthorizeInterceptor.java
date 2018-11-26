package com.cjc.framework.config.authorization;

import com.cjc.framework.core.annotation.NoAuthorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Author: chengjunchao
 * @Date: 2018/11/23 15:31
 * @Description:
 */
@Component
@Slf4j
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String uri = request.getRequestURI();
        //如果不是方法 则让通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //如果有NoAuthorization注解 则不鉴权
        if (method.getAnnotation(NoAuthorization.class) != null) {
            return true;
        }
        boolean bLogin = true;
        if (!bLogin) {
            redirectLogin(request, response);
        }
        return true;
    }

    /**
     * 退出
     *
     * @param request
     * @param response
     */
    private void redirectLogin(HttpServletRequest request, HttpServletResponse response) {
        try {
            if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                response.setStatus(499);
                response.getWriter().write("timeout");
            } else {
                response.sendRedirect("login.html");
            }
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
