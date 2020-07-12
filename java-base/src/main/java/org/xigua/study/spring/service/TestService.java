package org.xigua.study.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xigua.study.spring.springioc.HelloWorld;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xigua
 */
@Service
public class TestService {

    private HelloWorld helloWorld;

    @Autowired
    public TestService(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public String testIoC(HttpServletRequest request) {

        helloWorld.sayHello();
        return "";

    }

    public String testLoginedAuth(HttpServletRequest request) {

        return "";
    }

    public String testAop(HttpServletRequest request) {
        return "";
    }
}
