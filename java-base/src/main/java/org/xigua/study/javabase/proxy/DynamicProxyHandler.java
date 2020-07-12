package org.xigua.study.javabase.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实际实现的类需要实现InvocationHandler接口
 * @author org.xigua
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object realCookManager;
    //被代理的对象

    public DynamicProxyHandler() {
    }

    /**
     * @param realCookManager 使用构造函数传入要代理的目标
     */
    public DynamicProxyHandler(Object realCookManager) {
        this.realCookManager = realCookManager;
    }

    /**
     * @param proxy  产生代理的实例
     * @param method 需要代理的方法
     * @param args   方法参数
     * @return 代理方法返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method before ....");
        for (int i = 0, j = args.length; i < j; i++) {
            System.out.println("参数有" + args[i]);
        }
        //使用反射执行方法。
        Object result = method.invoke(realCookManager, args);

        System.out.println("Method after .....");
        return result;
    }
}
