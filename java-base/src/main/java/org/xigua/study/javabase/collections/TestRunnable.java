package org.xigua.study.javabase.collections;

import org.xigua.util.ThreadPoolUtil;

/**
 * @author org.xigua
 */
public class TestRunnable {
    public static void main(String[] args) throws InterruptedException {
        //常规方法
        ThreadPoolUtil.addThread(new CreateThread());

        //内部类的方式
        ThreadPoolUtil.addThread(() -> {
            while (true) {
                System.out.println("我是内部类2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });



        while (true) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        }

    }
}


/**
 * Runnable,使用接口的方式可以解耦
 * jdk1.8 可以用lambda的方式创建线程任务
 */
class CreateThread implements Runnable {


    public static void printThreadInfo() {
        System.out.println("当前线程" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        while (true) {
            printThreadInfo();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



