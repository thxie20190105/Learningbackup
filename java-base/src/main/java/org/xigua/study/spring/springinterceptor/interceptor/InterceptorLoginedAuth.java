package org.xigua.study.spring.springinterceptor.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.xigua.study.spring.springinterceptor.annotation.LoginedAuth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author xigua
 */
public class InterceptorLoginedAuth implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            if (clazz.isAnnotationPresent(LoginedAuth.class) || method.isAnnotationPresent(LoginedAuth.class)) {
                //主要通过对请求参数中的用户信息进行获取和判断
            }
        }
        return true;
    }

}
