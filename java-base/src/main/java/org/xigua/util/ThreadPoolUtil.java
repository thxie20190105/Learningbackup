package org.xigua.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xigua
 */
public class ThreadPoolUtil {

    private static ThreadPoolExecutor threadPoolExecutor;


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

    public static void addThread(Runnable runnable) {

        if (threadPoolExecutor == null) {
            init();
        }

        threadPoolExecutor.execute(runnable);

    }
}
