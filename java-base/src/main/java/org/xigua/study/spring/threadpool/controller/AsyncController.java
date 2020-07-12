package org.xigua.study.spring.threadpool.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xigua.study.spring.threadpool.service.AsyncService;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutorService;

/**
 * @author xigua
 */
@Api(tags = "测试线程池")
@RestController
@RequestMapping(value = "/asyncThread/")
public class AsyncController {


    private AsyncService service;

    private ExecutorService executorService;

    @Autowired
    public AsyncController(AsyncService service, ExecutorService executorService) {
        this.service = service;
        this.executorService = executorService;
    }

    @ApiOperation("添加异步任务到线程池")
    @RequestMapping(value = "addJobToAsync", method = RequestMethod.POST)
    public String addJobToAsync(HttpServletRequest request) {
        System.out.println(Thread.currentThread().getName());
        service.addJobToAsync(request);
        System.out.println("将任务交给异步线程池，我去做其他的事");
        return "";
    }

    @ApiOperation("使用自定义线程池")
    @RequestMapping(value = "addJobToThreadPool", method = RequestMethod.POST)
    public String addJobToThreadPool(HttpServletRequest request) {
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                System.out.println("开始执行任务");
                Thread.sleep(2000);
                System.out.println("任务执行完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        System.out.println("将任务交给线程池，我去做其他的事");

        return "";

    }


}
