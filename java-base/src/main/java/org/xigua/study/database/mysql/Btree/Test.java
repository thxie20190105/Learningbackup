package org.xigua.study.database.mysql.Btree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author xigua
 * @description
 * @date 2020/6/3
 **/
public class Test {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            l.addFirst(i);
        }
        long startTime = System.currentTimeMillis();

        System.out.println(startTime);
        Iterator iterator = l.listIterator();
        while (iterator.hasNext()) {
            int o = (int) iterator.next();
            if (o == 8888888) {
                System.out.println(System.currentTimeMillis() - startTime);
            }

        }
        System.out.println("end" + (System.currentTimeMillis() - startTime));
    }
}
