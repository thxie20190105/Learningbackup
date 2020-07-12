package org.xigua.study.database.redis.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

/**
 * @author xigua
 */
@Configuration
@Aspect
public class RedisCache {


    @Around("execution(* org.xigua.study.database.redis.controller.TestRedisController.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature m = (MethodSignature) proceedingJoinPoint.getSignature();

        Object result;

        result = proceedingJoinPoint.proceed();

        System.out.println("redis过滤器");
        return result;
    }
}
