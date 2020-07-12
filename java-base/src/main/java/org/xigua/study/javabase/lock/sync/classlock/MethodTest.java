package org.xigua.study.javabase.lock.sync.classlock;

import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author xigua
 * @description
 * @date 2020/7/6
 **/
public class MethodTest {

    public static Object o = new Object();

    public synchronized static void m1() throws InterruptedException {

        System.out.println("进入方法1");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("执行完方法1");

    }

    public synchronized static void m2() throws InterruptedException {
        System.out.println("进入到方法2");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("执行完方法2");
    }

    @Transactional
    public void m3() throws InterruptedException {

        synchronized (this) {
            System.out.println("进入到方法3");
            TimeUnit.SECONDS.sleep(10);
            System.out.println("执行完方法3");
        }

    }

    public void m4() throws InterruptedException {
        synchronized (MethodTest.class) {
            System.out.println("进入到方法4");
            TimeUnit.SECONDS.sleep(10);
            System.out.println("执行完方法4");
        }
    }


}
