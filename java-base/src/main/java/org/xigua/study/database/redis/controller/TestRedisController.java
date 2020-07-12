package org.xigua.study.database.redis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xigua.study.database.redis.service.TestRedisService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xigua
 */
@Api(tags = "redis练习")
@RestController(value = "/testRedis/")
public class TestRedisController {

    private TestRedisService testRedisService;

    @Autowired
    public TestRedisController(TestRedisService testRedisService) {
        this.testRedisService = testRedisService;
    }

    @ApiOperation(value = "向redis添加数据")
    @RequestMapping("add")
    public String add(HttpServletRequest request) {

        return testRedisService.add(request);
    }
}
