package org.xigua.study.javabase.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 山五洲
 */
public class TestArrayListSort {
    public static void main(String[] args) {
        //testArrayListRemove();

        //7与8最大的区别就是是否更改原有集合
        testSortJava7();
        testSortJava8();

    }

    private static void testSortJava8() {
        List<User1> list = new ArrayList<>();
        list.add(new User1(1));
        list.add(new User1(3));
        list.add(new User1(5));
        list.add(new User1(2));
        list.add(new User1(4));

        //使用lambda进行遍历
        list.forEach(user1 -> System.out.print(user1.getAge()));
        System.out.println();
        //自然排序,对象必须实现comparable在对象的内部做升序降序。
        //可以选择不更改原有集合的顺序，返回一个新集合
        List<User1> list2 = list.stream().sorted().collect(Collectors.toList());
        list2.forEach(user1 -> System.out.print(user1.getAge()));
        System.out.println();

        //通过comparator来排序一个list
        List<User1> list1 = list.stream().sorted(Comparator.comparing(User1::getAge)).collect(Collectors.toList());
        list1.forEach(user1 -> System.out.print(user1.getAge()));
        System.out.println();

        //反序
        List<User1> list3 = list.stream().sorted(Comparator.comparing(User1::getAge).reversed()).collect(Collectors.toList());
        list3.forEach(user1 -> System.out.print(user1.getAge()));
        System.out.println();


    }

    @SuppressWarnings("unchecked")
    private static void testSortJava7() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(4));
        userList.add(new User(5));
        userList.add(new User(1));
        List<User1> list = new ArrayList<>();
        list.add(new User1(4));
        list.add(new User1(2));
        list.add(new User1(1));
        list.add(new User1(3));

        int o = 4;
        //如果类没有实现comparable，就需要传递两个参数
        Collections.sort(userList, new Comparator<User>() {
            //前减去后是升序
            @Override
            public int compare(User o1, User o2) {
                //可以引用外部参数或变量
                System.out.println(o);
                return o2.getAge() - o1.getAge();
            }
        });
        for (User user : userList) {
            System.out.println(user.getAge());
        }
        //像user1就实现了comparable，直接调用就行。
        //this-参数对象是升序

        Collections.sort(list);
        for (User1 user1 : list) {
            System.out.println(user1.getAge());
        }

    }


    /**
     * 测试按照哦下标位置删除
     */
    private static void testArrayListRemove() {
        List<Integer> list = new ArrayList<>();
        for (int j = 0, i = 10; j < i; j++) {
            list.add(j);

        }
        list.remove(2);
        for (int i = 0, h = list.size(); i < h; i++) {
            System.out.println(list.get(i));
        }


    }


    public static class User {
        private String name;

        private int age;

        public User(int i) {
            this.age = i;

        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class User1 implements Comparable {
        private String name;

        private int age;

        public User1(int i) {
            this.age = i;

        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Object o) {
            return this.getAge() - ((User1) o).getAge();
        }
    }

}