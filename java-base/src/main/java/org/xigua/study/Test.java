package org.xigua.study;

import java.util.HashMap;

/**
 * @author xigua
 * @description
 * @date 2020/7/1
 **/
public class Test {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        System.out.println(hashMap.getClass().getClassLoader());

        Test test = new Test();
        System.out.println(test.getClass().getClassLoader());
    }
}
