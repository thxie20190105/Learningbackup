package org.xigua.study.javabase.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xigua
 * @description
 * @date 2020/5/14
 **/
public class TestThread {
    public static void main(String[] args) throws InterruptedException {

        Map map = new HashMap<>();
        Map map1 = Collections.synchronizedMap(map);

        TestThread.test4();

    }

    private static void test4() throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程被中断，程序退出");
                    return;
                }
                try {
                    System.out.println("睡眠钱" + Thread.currentThread().isInterrupted());
                    Thread.sleep(3000);
                    System.out.println("睡眠后" + Thread.currentThread().isInterrupted());

                    System.out.println("输出");
                } catch (InterruptedException e) {
                    System.out.println("睡眠线程被中断");
                    Thread.currentThread().interrupt();
                }

                try {
                    Thread.currentThread().wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();
        Thread.sleep(2000);
        System.out.println("主线程睡眠后");
        thread.interrupt();
        System.out.println("子线程中断" + thread.isInterrupted());
    }


}
