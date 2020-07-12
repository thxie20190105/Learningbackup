package org.xigua;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.xigua.study.spring.springioc.HelloWorld;
import org.xigua.study.spring.springioc.HelloWorldService;

/**
 * @author org.xigua
 */
@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@MapperScan(basePackages = "org.xigua.*.*.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public HelloWorld helloWorld() {
        HelloWorldService h = new HelloWorldService();
        return h;
    }


}
