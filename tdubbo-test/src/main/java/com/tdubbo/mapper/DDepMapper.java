package com.tdubbo.mapper;


import com.tdubbo.entity.DDep;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

public interface DDepMapper {


    List<DDep> get(Map map);

    int delById(int id);

    int createDep(DDep dDep);

    int updateById(DDep dDep);

    void createLog();
}