package org.xigua.study.javabase.thread;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xigua
 * @description
 * @date 2020/7/3
 **/
public class ThreadPoolFindFileSize {
    public static AtomicInteger integer = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        File file = new File("D:\\pgp");
        ExecutorService executorService =
                new ThreadPoolExecutor(20,
                        100,
                        0L,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>(),
                        new ThreadPoolExecutor.CallerRunsPolicy());
        executorService.submit(new returnSize(file, executorService));


        System.out.println("共有" + integer + "文件");

    }
}

class returnSize implements Runnable {

    private File directory;
    private ExecutorService poll;

    public returnSize(File directory, ExecutorService poll) {
        this.directory = directory;
        this.poll = poll;
    }

    @Override
    public void run() {
        File[] files = directory.listFiles();

        for (File f : files) {
            //是目录继续扔进线程池中
            if (f.isDirectory()) {
                poll.submit(new returnSize(f, poll));
            } else {
                System.out.println(f.getName());
                ThreadPoolFindFileSize.integer.incrementAndGet();
            }
        }

    }
}


