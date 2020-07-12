package com.tdubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tdubbo.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xigua
 * @description
 * @date 2020/7/12
 **/
@Controller
@RequestMapping(value = "/emp")
public class EmpController {

    @Reference
    private EmpService service;

    @RequestMapping(value = "/getNewEmp")
    @ResponseBody
    public Object getNewEmp(int id) {

        return service.getEmp(id);
    }

}
