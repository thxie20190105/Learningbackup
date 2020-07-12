package org.xigua.study.javabase.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 *
 * @author xigua
 */
public class TestThreadPool implements Runnable {

    public static void main(String[] args) {
        //获取cpu个数 8个
        System.out.println(Runtime.getRuntime().availableProcessors());
        //创建线程队列
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(6);
        //创建饱和策略
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();
        rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        rejectedExecutionHandler = new ThreadPoolExecutor.DiscardOldestPolicy();
        rejectedExecutionHandler = new ThreadPoolExecutor.DiscardPolicy();


        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                6,
                1,
                TimeUnit.HOURS,
                blockingQueue,
                new ThreadFactoryBuilder()
                        .setNameFormat("consumer-queue-thread-%d")
                        .build(),
                rejectedExecutionHandler
        );

        for (int i = 0, j = 15; i < j; i++) {
            executor.execute(new TestThreadPool());
            int threadSize = blockingQueue.size();
            System.out.println("线程列队的大小为" + threadSize);
        }

        //关闭线程池
        executor.shutdown();


    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
