package org.xigua.study.javabase.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author org.xigua
 */
public class TestConcurrentHashMap {
    public static void main(String[] args) {
        concurrentHashMap();
    }

    private static void concurrentHashMap() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(16, 0.75f, 16);
        concurrentHashMap.put("", "d");
        HashMap hashMap = new HashMap();
        LinkedList l = new LinkedList();

    }

    public void t() {
    }

}
