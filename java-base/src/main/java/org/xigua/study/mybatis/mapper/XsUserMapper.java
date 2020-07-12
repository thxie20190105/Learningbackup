package org.xigua.study.mybatis.mapper;

import org.springframework.stereotype.Component;
import org.xigua.study.mybatis.entity.XsUser;

import java.util.List;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xigua
 * @since 2020-04-13
 */
@Component
public interface XsUserMapper {

    /**
     * 查询
     *
     * @return
     */
    List<XsUser> select();
}
