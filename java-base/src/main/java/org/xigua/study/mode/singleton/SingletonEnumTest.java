package org.xigua.study.mode.singleton;

/**
 * @author xigua
 * @description
 * @date 2020/7/4
 **/
public class SingletonEnumTest {
    public static void main(String[] args) {
        SingletonEnumTest.getInstance();
        System.out.println(Singleton.INSTANCE.instance);

    }


    private SingletonEnumTest() {
    }


    private enum Singleton{
        INSTANCE;

        private final SingletonEnumTest instance;


        Singleton() {
            instance = new SingletonEnumTest();
        }

        private SingletonEnumTest getInstance(){
            return instance;
        }
    }


    public static SingletonEnumTest getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
}
