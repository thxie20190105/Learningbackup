package org.xigua.study.mode.singleton;

/**
 * @author xigua
 * @description 静态内部类的方式
 * @date 2020/7/4
 **/
public class SingletonTest {

    private  SingletonTest() {
    }

    private static class InstanceHolder{
        private final static SingletonTest instance = new SingletonTest();

    }

    public static SingletonTest getInstance() {
        return InstanceHolder.instance;
    }



}
