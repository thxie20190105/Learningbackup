package org.xigua.study.spring.cfg;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author org.xigua
 */
@Aspect
@Component
public class TestAnnotationAop {

    /**
     * @within 对象级别
     * 定义切点
     */
    @Pointcut("within(org.xigua.study.spring.controller.TestController)")
    public void serviceCut() {
    }

    /**
     * 可以采用下面这种方法,也可以蚕蛹具体实现的方法
     *
     * @param joinPoint 可以对请求的参数进行获取与处理
     * @Before("execution(* org.xigua.study.spring.cfg.Service.*(..))")
     */
    @Before("execution(* org.xigua.study.spring.controller.TestController.testAop(*))")
    public void before(JoinPoint joinPoint) {
        System.out.println("方法调用前执行增强");
        System.out.println("方法的入参" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("方法的签名" + joinPoint.getSignature());
        //还是注解来着方便，以2.0为分界线
    }

    @After("execution(* org.xigua.study.spring.controller.TestController.testAop(*))")
    public void after() {
        System.out.println("方法被调用后执行增强");
    }

    @AfterReturning(value = "execution(* org.xigua.study.spring.controller.TestController.testAop(*))", returning = "returnVal")
    public void after(Object returnVal) {
        System.out.println("方法执行成功后执行增强");
        System.out.println("返回参数" + returnVal.toString());
    }

    @Around("execution(* org.xigua.study.spring.controller.TestController.testAop(*))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        pjp.proceed();
        return null;
    }
}
