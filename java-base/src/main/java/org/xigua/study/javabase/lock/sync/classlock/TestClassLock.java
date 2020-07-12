package org.xigua.study.javabase.lock.sync.classlock;

/**
 * @author xigua
 * @description 测试结果 synchronize修饰静态方法锁住的是class类对象。
 * @date 2020/7/6
 **/
public class TestClassLock {

    public static void main(String[] args) throws InterruptedException {


        /*new Thread(() -> {
            try {
                MethodTest methodTest = new MethodTest();
                methodTest.m3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/

        /*new Thread(() -> {
            try {
                MethodTest.m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                MethodTest.m2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/


        new Thread(() -> {
            try {
                MethodTest methodTest = new MethodTest();
                methodTest.m4();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                MethodTest methodTest = new MethodTest();
                methodTest.m4();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }


}
