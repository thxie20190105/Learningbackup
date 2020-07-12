package org.xigua.study.javabase.ineerclass;

/**
 * @author xigua
 * @description
 * @date 2020/6/13
 **/
public class Test2 {
    public static void main(String[] args) {
        Test test = new Test() {
            @Override
            public Test print() {
                System.out.println("2");
                return null;
            }
        }.print();
    }
}
