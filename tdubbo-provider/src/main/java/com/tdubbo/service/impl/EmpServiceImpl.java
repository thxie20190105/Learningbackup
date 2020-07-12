package com.tdubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tdubbo.entity.DEmp;
import com.tdubbo.service.EmpService;

/**
 * @author xigua
 * @description
 * @date 2020/7/12
 **/
@org.springframework.stereotype.Service
@Service
public class EmpServiceImpl implements EmpService {
    @Override
    public DEmp getEmp(int id) {
        DEmp emp = new DEmp();
        emp.setId(id + 1000);
        System.out.println("被远程调用了");
        return emp;
    }
}
