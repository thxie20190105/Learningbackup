package org.xigua.study.mybatis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xigua.study.mybatis.service.impl.XsUserServiceImpl;

/**
 * <p>
 *
 * </p>
 *
 * @author xigua
 * @since 2020-04-13
 */
@Api(tags = "用户操作")
@RestController
@RequestMapping("/xsUser")
public class XsUserController {


    private XsUserServiceImpl xsUserService;

    @Autowired
    public XsUserController(XsUserServiceImpl xsUserService) {
        this.xsUserService = xsUserService;
    }

    /**
     * 查询数据
     */
    @ApiOperation(value = "查询")
    @RequestMapping("/select")
    public String select() {
        xsUserService.select();
        return "0";
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add() {
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update() {
    }


    /**
     * 删除数据
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public void deleteItems() {
    }

}

