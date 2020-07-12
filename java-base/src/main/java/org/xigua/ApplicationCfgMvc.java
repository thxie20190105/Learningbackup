package org.xigua;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.MultipartConfigElement;

/**
 * //开启mvc的一些默认配置书
 * //配置扫描
 *
 * @author xigua
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "org.xigua")
public class ApplicationCfgMvc implements WebMvcConfigurer {

    /**
     * 配置前后缀
     *
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //后缀
        viewResolver.setSuffix(".html");
        return viewResolver;
    }

    /**
     * 配置文件上传
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("104857600");
        return factory.createMultipartConfig();
    }

    /**
     * 人工添加静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/META-INF/resources/templates/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        // 你要请求的静态资源，静态资源在本地的位置
        registry.addResourceHandler("/static/*.html")
                .addResourceLocations("classpath:/static/");
    }
}
