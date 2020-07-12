package org.xigua.study.quartz.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xigua
 */

public class ThreadPool {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPool.class);

    private static ThreadPoolExecutor threadPoolExecutor;


    /**
     * 线程池初始化
     */
    private static void init() {

        threadPoolExecutor = new ThreadPoolExecutor(
                8,
                8,
                1,
                TimeUnit.DAYS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactoryBuilder()
                        .setNameFormat("consumer-queue-thread-%d")
                        .build()
        );

    }

    /**
     * 添加工作线程
     *
     * @param runnable
     */
    public static void addThread(Runnable runnable) {


        if (threadPoolExecutor == null) {
            init();
        }

        LOGGER.info("当前线程" + Thread.currentThread().getName());
        threadPoolExecutor.execute(runnable);

    }
}
