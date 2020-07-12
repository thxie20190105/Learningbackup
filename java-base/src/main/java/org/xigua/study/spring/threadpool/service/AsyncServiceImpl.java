package org.xigua.study.spring.threadpool.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xigua
 */
@Service
public class AsyncServiceImpl implements AsyncService {


    /**
     * 不允许有返回值，既然新启了线程那么主线程获取不到它的值。
     *
     * @param request
     */
    @Override
    @Async
    public void addJobToAsync(HttpServletRequest request) {
        System.out.println(Thread.currentThread().getName());

        try {
            System.out.println("开始执行任务");
            Thread.sleep(3000);
            System.out.println("任务执行完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
