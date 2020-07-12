package org.xigua.study.javabase.threadpool;

import org.xigua.util.ThreadPoolUtil;

/**
 * @author org.xigua
 */
public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        CreateThreadForExt createThreadForExt = new CreateThreadForExt("Thread1");
        createThreadForExt.setPriority(Thread.NORM_PRIORITY);
        createThreadForExt.start();

        new CreateThreadForExt("Thread2").start();
        new CreateThreadForExt("Thread3").start();
        new CreateThreadForExt("Thread4").start();
        //使用内部类的方式并且用到了lambda表达式
        ThreadPoolUtil.addThread(() -> {
            while (true) {
                System.out.println("我是内部类");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        while (true) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}

class CreateThreadForExt extends java.lang.Thread {
    CreateThreadForExt(String name) {
        this.setName(name);
    }

    private static void printThreadInfo() {
        System.out.println("当前运行线程名" + java.lang.Thread.currentThread().getName());
    }

    @Override
    public void run() {


        try {
            while (true) {
                printThreadInfo();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
