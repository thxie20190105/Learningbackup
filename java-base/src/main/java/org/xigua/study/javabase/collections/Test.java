package org.xigua.study.javabase.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author xigua
 * @description
 * @date 2020/5/3
 **/
public class Test {
    public static void main(String[] args) {
        List<String> list = new Vector<String>();
        list.add("2");


        ok:
        while (true) {
            if (1 == 1) {
                break ok;
            }
        }
        System.out.println("出来了");

        List l2 = new LinkedList();
        Iterator iterator = l2.iterator();

    }
}
