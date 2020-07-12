package org.xigua.study.javabase.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author org.xigua
 */
public class TestThreadPool {
    public static void main(String[] args) {
        //创建固定大小的线程池
        ExecutorService executorService = new ThreadPoolExecutor(
                8,
                8,
                30,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(200),
                new ThreadPoolExecutor.AbortPolicy()
        );

        while (true) {
            //这lambda表达式是，蒙蒙的。
            executorService.execute(TestThreadPool::printThreadInfo);
        }
    }

    private static void printThreadInfo() {
        System.out.println("当前线程名:" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
