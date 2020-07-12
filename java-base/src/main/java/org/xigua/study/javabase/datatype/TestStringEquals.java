package org.xigua.study.javabase.datatype;

/**
 * @author xigua
 */
public class TestStringEquals {

    public static void main(String[] args) {


        //在常亮池中创建abc
        String str1 = "abc";
        //发现常量池里有直接引用
        String str2 = "abc";
        //发现常量池里有直接在堆内存中开辟新地址空间拷贝一份
        String str3 = "abc";
        //同上
        String str4 = "abc";

        System.out.println("str1\t" + System.identityHashCode(str1));
        System.out.println("str2\t" + System.identityHashCode(str2));
        System.out.println("str3\t" + System.identityHashCode(str3));
        System.out.println("str4\t" + System.identityHashCode(str4));


        //比较运算符，比较他们的地址引用是否一样
        System.out.println(str1 == str2);
        //直接比较引用
        System.out.println(str1.equals(str2));
        //两个对象的地址不一样，所以false
        System.out.println(str3 == str4);
        //equals不光比较地址的引用还比较值是否相同
        System.out.println(str3.equals(str4));
        //一个引用的是常亮池里的地址，一个引用的是内存空间的
        System.out.println(str1 == str3);


    }

}
