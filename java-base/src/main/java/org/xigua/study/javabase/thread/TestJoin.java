package org.xigua.study.javabase.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xigua
 * @description
 * @date 2020/5/30
 **/
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        List list = new ArrayList();

        for (int i = 0, j = 20; i < j; i++) {

            Job job = new Job();
            job.start();
            list.add(job);
        }

        for (int i = 0; i < list.size(); i++) {
            Job job = (Job) list.get(i);
            job.join();
        }


        System.out.println("hello");
    }
}


class Job extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Thread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
