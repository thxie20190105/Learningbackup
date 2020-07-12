package com.tdubbo.controller;

import com.tdubbo.entity.DDep;
import com.tdubbo.service.DepService;
import com.tdubbo.entities.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author xigua
 * @description
 * @date 2020/7/10
 **/
@Controller
@Api(tags = "部门接口")
@RequestMapping(value = "/dep")
public class DepController {

    DepService service;

    RedisTemplate template;

    public DepController(DepService service, @Qualifier("redisTemplate") RedisTemplate template) {
        this.service = service;
        this.template = template;
    }

    @ApiOperation("查看所有部门")
    @RequestMapping(value = {"/get", "/get/{id}", "/get/{name}", "/get/{name}/{level}"},
            method = RequestMethod.GET)
    @ResponseBody
    public CommonResult get(@PathVariable(required = false) String level,
                            @PathVariable(required = false) String name,
                            @PathVariable(required = false) String id) {

        List list;
        if (!StringUtils.isEmpty(id)) {
            HashMap hashMap = (HashMap) template.opsForHash().entries(id + "");
            if (hashMap.size() == 0) {
                list = service.get(StringUtils.isEmpty(id) ? 0 : Integer.parseInt(id), level, name);
            } else {
                return new CommonResult<>(200, "查询成功", hashMap);
            }
        } else {
            list = service.get(StringUtils.isEmpty(id) ? 0 : Integer.parseInt(id), level, name);
        }
        return new CommonResult<>(200, "查询成功", list);

    }

    @ApiOperation("增加新部门")
    @RequestMapping(value = "/createDep", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createDep(DDep dDep, @RequestParam("data") String data) {

        int b = service.createDep(dDep);
        if (b > 0) {
            return new CommonResult(200, "新增成功");
        }
        return new CommonResult(202, "新增失败");

    }

    @ApiOperation("删除部门")
    @RequestMapping(value = "/delById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delById(@PathVariable String id) {
        int b = service.delById(StringUtils.isEmpty(id) ? 0 : Integer.parseInt(id));

        if (b > 0) {
            return new CommonResult(200, "删除成功");
        } else {
            return new CommonResult(202, "无数据");
        }
    }

    @ApiOperation("更新部门信息")
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class, timeout = 1)
    public CommonResult updateById(DDep dDep) {

        int b = service.updateById(dDep);

        if (true) {
            throw new RuntimeException("人工异常处理");
        }

        if (b > 0) {
            return new CommonResult(200, "更新成功");
        } else {
            return new CommonResult(202, "无数据");
        }

    }


    @ApiOperation("异常方法调用")
    @RequestMapping(value = "/callEx", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult callEx() throws Exception {

        throw new Exception("人工异常处理");


    }


}
