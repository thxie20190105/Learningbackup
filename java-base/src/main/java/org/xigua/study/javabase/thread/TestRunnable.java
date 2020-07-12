package org.xigua.study.javabase.thread;

/**
 * @author xigua
 * @description
 * @date 2020/6/4
 **/
public class TestRunnable {
    public static void main(String[] args) {
        a a = new a();
        System.out.println(Thread.currentThread().getName());
        new Thread(a).start();
    }
}

class a implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        System.out.println("d");
    }
}

