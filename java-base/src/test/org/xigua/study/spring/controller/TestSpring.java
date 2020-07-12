package org.xigua.study.spring.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSpring {

    HttpServletRequest request;

    @Autowired
    private TestController controller;

    @Test
    public void testIoC() {
        controller.testIoC(request);
    }

    /**
     * 直接调用好像不走拦截器
     */
    @Test
    public void testLoginedAuth() {
        controller.testLoginedAuth(request);
    }


    @Test
    public void testAop() {
        // controller.testAop(request);
    }


}
