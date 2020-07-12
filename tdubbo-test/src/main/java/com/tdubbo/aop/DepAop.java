package com.tdubbo.aop;

import com.tdubbo.entities.CommonResult;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author xigua
 * @description
 * @date 2020/7/11
 **/
@Component
@Aspect
public class DepAop {

    @Pointcut("within(com.tdubbo.controller.DepController)")
    public void controllerCut() {
    }


    @Before("com.tdubbo.aop.DepAop.controllerCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("调用前");
    }

    @Around("com.tdubbo.aop.DepAop.controllerCut()")
    public Object aroundMethod(ProceedingJoinPoint pdj) {
        Object result;

        try {
            result = pdj.proceed();
        } catch (Throwable throwable) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throwable.printStackTrace();
            result = new CommonResult(500, "系统异常");
        }

        return result;

    }


}
