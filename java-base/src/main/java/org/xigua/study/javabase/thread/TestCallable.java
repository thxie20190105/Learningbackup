package org.xigua.study.javabase.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xigua
 * @description
 * @date 2020/5/15
 **/
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable.test5();
    }

    private static void test5() throws ExecutionException, InterruptedException {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {

                Thread.sleep(3000);

                return "2";
            }
        };
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();

        Thread.sleep(1000);

        if (futureTask.get() != null) {
            System.out.println(futureTask.get());

        }

    }
}
