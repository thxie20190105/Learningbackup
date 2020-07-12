package org.xigua.study.javabase.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 更改虚拟机参数
 * -Xms8m -Xmx8m
 * @author xigua
 */
public class FixedThreadPoolOom {

    /**
     *
     */
    private static ExecutorService executorService = new ThreadPoolExecutor(
            1,
            1,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(),
            new ThreadFactoryBuilder()
                    .setNameFormat("consumer-queue-thread-%d")
                    .build());


    public static void main(String[] args) {
        for (int i = 0, j = Integer.MAX_VALUE; i < j; i++) {
            executorService.execute(new SubTread());
        }
    }

}

class SubTread implements Runnable {

    @Override
    public void run() {
        try {
            //延长任务时间
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
