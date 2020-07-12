package org.xigua.study.javabase.collections;

import java.util.*;

/**
 * @author org.xigua
 */
public class TestCollection {
    static TreeSet treeSet = new TreeSet();
    static HashSet hashSet = new HashSet();
    static LinkedHashSet linkedHashSet = new LinkedHashSet();
    private static ArrayList<java.io.Serializable> arrayList = new ArrayList<java.io.Serializable>();
    private static LinkedList<Integer> linkedList = new LinkedList<>();
    private static List<Object> arrayList1 = Collections.synchronizedList(new ArrayList<>());
    private static List<Object> linkedList1 = Collections.synchronizedList(new LinkedList<>());

    public static void main(String[] args) {
        //TCollection.TArrayList();
        //TCollection.TLinkedList();
    }

    private static void testArrayList() {
        List list = new ArrayList();
        for (int i = 0, j = 9000; i < j; i++) {
            list.add(i);
        }
        arrayList.add("hello");
        arrayList.addAll(list);
        arrayList.remove("apple");
        arrayList.set(1120, "pig");

        String s = (String) arrayList.get(1);
        System.out.println(arrayList.get(0));
        //为什么用要用hashNext,如果还有下一个元素,需要判断是否有下一个元素，有的话才去执行.next方法
        Iterator iterator2 = arrayList.listIterator();
        iterator2.next();
        for (Iterator iterator = arrayList.listIterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
            //指针下移
        }
        arrayList.clear();
        for (Iterator iterator = arrayList.listIterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next() + "hhhhh");
        }


    }

    private static void testPerformanceForIterator() {
        ListIterator<java.io.Serializable> listIterator = arrayList.listIterator();
        ListIterator<Integer> listIterator1 = linkedList.listIterator();
        ListIterator listIterator2 = arrayList1.listIterator();
        ListIterator listIterator3 = linkedList1.listIterator();
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间" + (startTime));
        for (int i = 1, j = 100000; i < j; i++) {
            listIterator.add(new Integer(i));
            //10173
            listIterator1.add(new Integer(i));
            //3513
            listIterator2.add(new Integer(i));
            //10023
            listIterator3.add(new Integer(i));
            //3643
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用迭代子添加数据所需时间" + (endTime - startTime));


    }

}

class Obj {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}