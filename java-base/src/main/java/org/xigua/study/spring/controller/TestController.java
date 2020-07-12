package org.xigua.study.spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xigua.study.spring.service.TestService;
import org.xigua.study.spring.springinterceptor.annotation.LoginedAuth;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xigua
 */
@Api(tags = "spring相关测试接口")
@RestController
@RequestMapping("/spring/")
public class TestController {

    private TestService service;

    @Autowired
    public TestController(TestService service) {
        this.service = service;
    }

    @ApiOperation("测试ioc容器")
    @RequestMapping("testIoC")
    public String testIoC(HttpServletRequest request) {
        return service.testIoC(request);
    }

    @ApiOperation("测试记录用户信息拦截器")
    @RequestMapping("testLoginedAuth")
    @LoginedAuth
    public String testLoginedAuth(HttpServletRequest request) {
        return service.testLoginedAuth(request);
    }


    @ApiOperation("测试aop拦截")
    @RequestMapping("testAop")
    @LoginedAuth
    public String testAop(HttpServletRequest request) {
        return service.testAop(request);
    }


}
