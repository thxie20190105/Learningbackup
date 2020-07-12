package org.xigua.study.javabase.annotation;

/**
 * 使用注解
 *
 * @author org.xigua
 */
public class TestAnnotation {

    @MyMassage(num = 9, desc = "参数a")
    private static int a;

    @MyMassage(name = "Tom test", desc = "测试方法test")
    public void test() {
        System.out.println("test 方法");
    }


}
