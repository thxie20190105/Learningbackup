package com.tdubbo.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xigua
 * @description
 * @date 2020/7/11
 **/
@Configuration
public class InterceptorCfg implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorToIp()).addPathPatterns("/**");
    }

    @Bean
    public InterceptorToIp interceptorToIp() {
        return new InterceptorToIp();
    }
}
