package org.xigua.study.spring.springinterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.xigua.study.spring.springinterceptor.interceptor.InterceptorCalculateRequestTime;
import org.xigua.study.spring.springinterceptor.interceptor.InterceptorLoginedAuth;

/**
 * @author org.xigua
 * FrameWork4中的已经被弃用了，
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //多个拦截器组成一个拦截器集合
        //addPathPatterns   用于添加拦截规则
        //addInterceptor    用于添加拦截器到拦截链中
        //只有走DispatcherServlet的请求才会走拦截器链

        registry.addInterceptor(interceptorCalculateRequestTime()).addPathPatterns("/**");
        registry.addInterceptor(interceptorLoginedAuth()).addPathPatterns("/**");
    }

    @Bean
    public InterceptorCalculateRequestTime interceptorCalculateRequestTime() {
        return new InterceptorCalculateRequestTime();
    }

    @Bean
    public InterceptorLoginedAuth interceptorLoginedAuth() {
        return new InterceptorLoginedAuth();
    }

}
