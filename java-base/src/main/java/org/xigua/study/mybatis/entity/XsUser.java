package org.xigua.study.mybatis.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xigua
 * @since 2020-04-13
 */
public class XsUser implements Serializable {


    private static final long serialVersionUID = -1082043517065652310L;
    private Long userId;

    private String userName;

    private Integer userAge;

    public XsUser(Integer userAge) {
        this.userAge = userAge;
    }

    public XsUser(Long userId, String userName, Integer userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
    }

    public XsUser() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }


    @Override
    public String toString() {
        return userName + userAge + userId;
    }
}
