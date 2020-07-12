package com.tdubbo.service;

import com.tdubbo.entity.DDep;
import com.tdubbo.mapper.DDepMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author xigua
 * @description
 * @date 2020/7/10
 **/
@Service
public class DepService {
    DDepMapper mapper;

    public DepService(DDepMapper mapper) {
        this.mapper = mapper;
    }

    public int delById(int id) {
        return mapper.delById(id);
    }

    public int createDep(DDep dDep) {
        return mapper.createDep(dDep);
    }

    public List get(int id, String level, String name) {
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("id", id);
        map.put("level", level);
        map.put("name", name);

        return mapper.get(map);
    }

    public int updateById(DDep dDep) {
        mapper.createLog();
        return mapper.updateById(dDep);
    }
}
