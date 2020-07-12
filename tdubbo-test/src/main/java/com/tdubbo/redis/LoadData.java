package com.tdubbo.redis;

import com.tdubbo.entity.DEmp;
import com.tdubbo.mapper.DEmpMapper;
import com.tdubbo.util.ObjectUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author xigua
 * @description
 * @date 2020/7/11
 **/
@Component
public class LoadData implements InitializingBean {

    private static final String D_EMP_NAME = "d_emp";
    RedisTemplate template;
    DEmpMapper mapper;

    public LoadData(@Qualifier("redisTemplate") RedisTemplate template, DEmpMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.loadEmp();
    }

    private void loadEmp() {
        HashMap<String, Object> hashMap = new HashMap<>(16);
        hashMap.put("id", 0);
        List<DEmp> list = mapper.get(hashMap);

        for (DEmp dEmp : list) {
            System.out.println(dEmp.toString());
            this.hashAdd(dEmp);
        }


    }

    /**
     * 最开始的想法应该是使用hash去存。zset适合使用储存排行榜类的。
     *
     * @param dEmpName
     * @param dEmp
     */
    private void hashAdd(DEmp dEmp) {
        HashOperations hashOperations = template.opsForHash();
        try {
            hashOperations.putAll(dEmp.getId() + "", ObjectUtils.objectToMap(dEmp));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
