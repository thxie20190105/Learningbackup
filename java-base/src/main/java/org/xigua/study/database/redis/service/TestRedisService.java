package org.xigua.study.database.redis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author xigua
 */
@Service
public class TestRedisService {


    private static Logger logger = LoggerFactory.getLogger(TestRedisService.class);

    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public TestRedisService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public String add(HttpServletRequest request) {
        String key = "redis";
        String value = "value";
        long expire = 10000;

        //存入
        try {

            ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
            /*
            * RedisTemplate中定义了对5种数据结构操作：

                redisTemplate.opsForValue();//操作字符串
                redisTemplate.opsForHash();//操作hash
                redisTemplate.opsForList();//操作list
                redisTemplate.opsForSet();//操作set
                redisTemplate.opsForZSet();//操作有序set
             *
            * */
            valueOperations.set(key, value);
            //设置存活时间
            stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);

        } catch (Exception e) {
            logger.error("写入redis失败" + e.getMessage());
        }

        //判断是否存在
        try {
            if (stringRedisTemplate.hasKey(key)) {
                System.out.println("存在");
            } else {
                System.out.println("不存在");
            }
        } catch (Exception e) {
            logger.error("不存在" + key + "对应值" + e.getMessage());
        }

        //读取
        try {
            ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
            String o = valueOperations.get(key);
            System.out.println(key + "对应值" + o);
        } catch (Exception e) {
            logger.error("读取失败" + e.getMessage());
        }

        //删除
        try {
            if (stringRedisTemplate.delete(key)) {
                System.out.println("delete success");
            } else {
                System.out.println("delete fail");
            }
        } catch (Exception e) {
            logger.error("删除失败" + e.getMessage());
        }


        return "";
    }
}
