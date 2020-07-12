package org.xigua.study.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xigua.study.mybatis.entity.XsUser;
import org.xigua.study.mybatis.mapper.XsUserMapper;

import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xigua
 * @since 2020-04-13
 */
@Service
public class XsUserServiceImpl {


    private XsUserMapper mapper;

    @Autowired
    public XsUserServiceImpl(XsUserMapper mapper) {
        this.mapper = mapper;
    }


    public void select() {
        List<XsUser> list = mapper.select();
        list.forEach(xsUser -> System.out.println(xsUser.toString()));
    }
}
