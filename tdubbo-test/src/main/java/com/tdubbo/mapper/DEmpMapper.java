package com.tdubbo.mapper;

import com.tdubbo.entity.DEmp;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

public interface DEmpMapper {

    List<DEmp> get(HashMap hashMap);
}