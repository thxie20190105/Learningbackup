package org.xigua.study.javabase.atomic;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xigua
 * @description
 * @date 2020/7/3
 **/
public class TestAtomic {
    public static AtomicInteger atomicInteger = new AtomicInteger();


    public static void main(String[] args) throws InterruptedException {

        add add = new add();
        add add2 = new add();
        new Thread(add).start();
        new Thread(add2).start();


        Unsafe unsafe = sun.misc.Unsafe.getUnsafe();


        ConcurrentHashMap hashMap = new ConcurrentHashMap();

        TimeUnit.SECONDS.sleep(2);
        System.out.println(TestAtomic.atomicInteger);

    }


}


class add implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            TestAtomic.atomicInteger.incrementAndGet();
        }
    }
}
