package org.xigua.study.spring.springioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author org.xigua
 */
public class HelloWorldService implements HelloWorld, InitializingBean, DisposableBean, BeanPostProcessor {

    public HelloWorldService() {
    }


    @Override
    public void sayHello() {
        System.out.println("Service Say Hallo");
    }


    @Override
    public void afterPropertiesSet() {
        System.out.println("HelloWorldService-INIT操作");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("HelloWorldService-销毁bean");

    }


    //初始化初始化方法回调时的前后处理

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("HelloWorldService-初始化了");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("HelloWorldService-初始化完成了");
        return null;
    }
}
