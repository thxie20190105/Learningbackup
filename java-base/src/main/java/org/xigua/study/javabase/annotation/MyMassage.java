package org.xigua.study.javabase.annotation;


import java.lang.annotation.*;

/**
 * 定义注解
 *
 * @author org.xigua
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyMassage {
    String name() default "Tom";

    int num() default 0;

    String desc();

}
