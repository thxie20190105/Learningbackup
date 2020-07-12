package org.xigua;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

/**
 * EnableAsync，让spring开启异步可用，这样以后想把某个方法中的任务异步的放在另一个线程，直接在方法上加上@async即可
 * @author xigua
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig implements AsyncConfigurer {


    @Override
    public Executor getAsyncExecutor() {
        //定义线程池工厂与线程名字格式
        ThreadFactory factory = new ThreadFactoryBuilder()
                .setNameFormat("consumer-queue-thread-%d")
                .build();
        return new ThreadPoolExecutor(
                8,
                8,
                30,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(200),
                factory,
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

    /**
     * 配置一个线程池
     *
     * @return
     */
    @Bean
    public ExecutorService getThreadPool() {
        ThreadFactory factory = new ThreadFactoryBuilder()
                .setNameFormat("consumer-queue-thread-%d")
                .build();
        return new ThreadPoolExecutor(
                10,
                20,
                30,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(200),
                factory,
                new ThreadPoolExecutor.AbortPolicy()
        );
    }


}
