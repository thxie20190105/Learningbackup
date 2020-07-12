package org.xigua.study.javabase.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 解析注解
 *
 * @author org.xigua
 */
public class MyMassageProcessor {

    public static void main(String[] args) throws ClassNotFoundException {

        //使用java的反射得到使用注解的字段与方法
        Class clazz = MyMassageProcessor.class.getClassLoader().loadClass("org.xigua.study.javabase.annotation.TestAnnotation");

        for (Field field : clazz.getDeclaredFields()) {
            MyMassage myMassage = field.getAnnotation(MyMassage.class);
            System.out.print("name" + myMassage.name());
            System.out.print("num" + myMassage.num());
            System.out.println("desc" + myMassage.desc());

        }

        for (Method method : clazz.getMethods()) {
            //如果有方法没有该注解会报空指针
            if (method.isAnnotationPresent(MyMassage.class)) {
                MyMassage myMassage = method.getAnnotation(MyMassage.class);
                System.out.print("name" + myMassage.name());
                System.out.print("num" + myMassage.num());
                System.out.println("desc" + myMassage.desc());
            }
        }


    }

}
