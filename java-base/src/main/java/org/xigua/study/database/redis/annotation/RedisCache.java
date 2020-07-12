package org.xigua.study.database.redis.annotation;

import java.lang.annotation.*;

/**
 * @author xigua
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {
}
