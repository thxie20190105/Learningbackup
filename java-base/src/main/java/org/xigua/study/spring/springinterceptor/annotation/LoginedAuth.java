package org.xigua.study.spring.springinterceptor.annotation;

import java.lang.annotation.*;

/**
 * @author org.xigua
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginedAuth {

}
