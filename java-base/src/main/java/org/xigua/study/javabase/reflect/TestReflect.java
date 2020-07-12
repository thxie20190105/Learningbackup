package org.xigua.study.javabase.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * //练习java反射
 * @author org.xigua
 */
public class TestReflect {
    public static void main(String[] args) {
        //查看变量和方法，
        test();

        //调用方法
        callMethod();

        //修改变量
        updateField();
    }

    private static void updateField() {
        Class c = TestClass.class;
        //获得全部公共字段
        Field[] fields = c.getFields();
        //获得私有字段
        try {
            Field field = c.getDeclaredField("amt");
            field.setAccessible(true);
            try {
                System.out.println("金额为" + TestClass.amt);
                field.set(field, "90000");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println("修改后金额为" + TestClass.amt);

            for (Field f : fields) {
                System.out.println("字段为" + f);
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static void callMethod() {
        //获得私有方法
        Method methods1;
        Method[] methods;
        TestClass p = new TestClass();
        Class c = TestClass.class;

        try {
            //传入方法名称，后面可以穿一堆方法参数
            methods1 = c.getDeclaredMethod("echo1");
            //获得访问权限
            methods1.setAccessible(true);
            //调用私有方法
            methods1.invoke(p);

            //调用公用方法
            methods = c.getDeclaredMethods();
            System.out.println("call public method");
            for (Method method : methods) {
                //设置权限，不然在调用私有方法的时候会报异常
                method.setAccessible(true);
                if (method.getParameters().length == 0) {
                    method.invoke(p);
                } else {
                    if (String.class == method.getParameterTypes()[0]) {
                        method.invoke(p, "");
                    } else {
                        method.invoke(p, new Integer(9));
                    }
                }
            }

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private static void test() {
        Class c = TestClass.class;
        System.out.println("类的名称" + c.getName());

        //获得所有public访问的变量，包括父类的public变量
        Field[] fields = c.getFields();

        //输出所获得的访问变量
        for (Field field : fields) {
            System.out.println("字段类型" + field.getType().getName());
            System.out.println("字段名称" + field.getName());
        }

        //过得所有公共方法
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            //输出返回值类型
            System.out.println("方法返回值类型" + method.getReturnType().getName());
            //输出方法名
            System.out.println("方法名称" + method.getName());
            //输出方法第一个参数
            Parameter[] parameter = method.getParameters();
            for (Parameter parameter1 : parameter) {
                System.out.println("方法参数名称" + parameter1.getName());
            }
            //输出方法抛出的异常
            Class[] exceptionC = method.getExceptionTypes();
            for (Class cd : exceptionC) {
                System.out.println("方法抛出的异常类" + cd.getName());
            }
        }


    }

    static class TestClass extends Parent {
        public String p;
        private String name;
        private int age;
        private static String amt = "100000";

        public String getName() {
            System.out.println("getname");
            return name;
        }

        public void setName(String name) {
            System.out.println("setname");
            this.name = name;
        }

        public int getAge() {
            System.out.println("getage");
            return age;
        }

        public void setAge(int age) {
            System.out.println("setage");
            this.age = age;

        }

        public void testException() throws InterruptedException {
            Thread.sleep(100);
        }


        private void echo1() {
            System.out.println("hello word");
        }
    }

    static class Parent {
        public String parent;

    }
}
