package org.xigua.study.javabase.lock.sync;

/**
 * @author xigua
 * @description
 * @date 2020/5/31
 **/
public class TestSecurity {
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        final TestSecurity testSecurity = new TestSecurity();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                testSecurity.f1();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                TestSecurity.f3();
            }
        });


        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

        System.out.println(TestSecurity.i);
    }

    public static synchronized void f3() {

        i++;
    }

    public void f2() {

        i++;
    }

    public synchronized void f1() {

        i++;
    }
}
