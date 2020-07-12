package org.xigua.study.javabase.proxy;

import sun.misc.ProxyGenerator;

import java.lang.reflect.Proxy;

/**
 * 实现使用代理对象之前与之后进行相关操作
 * @author org.xigua
 */
public class Test {
    public static void main(String[] args) {
        CookManager cookManager = new CookManager();

        //获取代理，获得的是接口
        ICook iCook;
        //1、类加载器定义的代理类，2、本应该实现接口的类、实际的执行类
        iCook = (ICook) Proxy.newProxyInstance(Test.class.getClassLoader(),
                cookManager.getClass().getInterfaces(), new DynamicProxyHandler(cookManager));


        iCook = (ICook) Proxy.newProxyInstance(Test.class.getClassLoader(), cookManager.getClass().getInterfaces(), new DynamicProxyHandler(cookManager));

        //直接调用一下接口里的方法声明就行
        int result = iCook.cook("张三");
        System.out.println(result);
        System.out.println(iCook.getClass().getName());


        //输出代理类源码
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(iCook.getClass().getName(), cookManager.getClass().getInterfaces());


    }

}
