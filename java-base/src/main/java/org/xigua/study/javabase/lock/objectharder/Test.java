package org.xigua.study.javabase.lock.objectharder;

import org.openjdk.jol.info.ClassLayout;
import org.xigua.util.ThreadPoolUtil;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xigua
 * @description
 * @date 2020/5/27
 **/
public class Test {
    static L l = new L();

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        //System.out.println(l.hashCode());
        while (true) {
            ThreadPoolUtil.addThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ClassLayout.parseInstance(l).toPrintable());

                }
            });

        }
    }

}
