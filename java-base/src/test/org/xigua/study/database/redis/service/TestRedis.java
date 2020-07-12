package org.xigua.study.database.redis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.xigua.study.mybatis.entity.XsUser;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    /**
     * 在RedisConfig文件中已经定义了，并制定了自己的序列化类
     */
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set("user", new XsUser((long) 3, "redis", 2));
        XsUser xsUser = (XsUser) redisTemplate.opsForValue().get("user");
        if (xsUser != null) {
            System.out.println(xsUser.toString());
        }
    }

    @Test
    public void testType() {
        //HashTable
        redisTemplate.opsForHash().put("testHash", "k1", "v1");


        //List
        redisTemplate.opsForList().leftPush("testList", "v1");
        redisTemplate.opsForList().rightPush("testList", "v2");

        //set
        redisTemplate.opsForSet().add("testSet", "v1", "v2", "v3");

        //Zset
        redisTemplate.opsForZSet().add("testZset", "v1", 1);
        redisTemplate.opsForZSet().add("testZset", "v2", 2);
        redisTemplate.opsForZSet().add("testZset", "v3", 3);

        //String
        redisTemplate.opsForValue().set("testString", new XsUser((long) 3, "redis", 2));
        redisTemplate.opsForValue().set("testString2", "value2");
        redisTemplate.opsForValue().set("test!!","tes",2000,TimeUnit.MILLISECONDS);


        System.out.println("开始查找HashTable");
        Set<Object> testHash = redisTemplate.opsForHash().keys("testHash");
        Map<Object, Object> testHash1 = redisTemplate.opsForHash().entries("testHash");

        Iterator iterator3 = testHash.iterator();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }
        for (Map.Entry entry : testHash1.entrySet()) {
            System.out.println("key" + entry.getKey());
            System.out.println("value" + entry.getValue());

        }

        System.out.println("开始查找List");
        List<Object> testlist = redisTemplate.opsForList().range("testList", 0, -1);
        Iterator iterator = testlist.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("开始查找Set");
        Set<Object> testSet = redisTemplate.opsForSet().members("testSet");
        Iterator iterator1 = testSet.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("开始查找zset");
        Set<Object> testZset = redisTemplate.opsForZSet().range("testZset", 0, -1);
        Iterator iterator2 = testZset.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }


        //设置超时时间
        redisTemplate.expire("testHash", 1, TimeUnit.HOURS);
        //解除超时时间
        redisTemplate.persist("testHash");
        //删除
        redisTemplate.delete("testHash");



    }


}
