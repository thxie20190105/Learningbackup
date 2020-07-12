package org.xigua.study.javabase.collections;

import java.util.*;

/**
 * @author org.xigua
 */
public class TestSet {
    public static void main(String[] args) {
        System.out.println();
        TestSet.set();
    }

    private static void set() {
        HashSet hashSet = new HashSet();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Collections.synchronizedSet(linkedHashSet);

        Map map = new HashMap();

    }

}
