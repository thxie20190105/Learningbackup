package com.tdubbo.interceptor;


import com.sun.management.OperatingSystemMXBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.management.ManagementFactory;
import java.sql.Timestamp;

/**
 * @author org.xigua
 * 自定义拦截器，实现HandlerInterceptor方法
 * 计算请求花费时间
 */
public class InterceptorToIp implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String remoteAddr = request.getRemoteAddr();
        String host = request.getHeader("Host");

        System.out.println(remoteAddr);
        System.out.println(host);
        return true;
    }


    /**
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    /**
     * @param request
     * @param response
     * @param handler
     * @param ex       不论是否报错，最后都会走这个方法 在前台页面渲染完之后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }


}
