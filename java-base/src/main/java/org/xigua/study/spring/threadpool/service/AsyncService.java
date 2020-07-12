package org.xigua.study.spring.threadpool.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xigua
 */
public interface AsyncService {

    /**
     * 添加到异步线程池
     * @param request 请求参数
     */
    void addJobToAsync(HttpServletRequest request);

}
