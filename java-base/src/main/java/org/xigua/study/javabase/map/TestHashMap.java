package org.xigua.study.javabase.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author org.xigua
 */
public class TestHashMap {
    public static void main(String[] args) {
        TestHashMap.tHash();

        TreeMap treeMap = new TreeMap();
        treeMap.put("", "");
    }

    private static void tHash() {
        Integer o = 3;
        System.out.println(Integer.toBinaryString(o));
        int ii = 2047;
        int y = 2112;
        System.out.println(ii & y);
        System.out.println(Integer.toBinaryString(ii));
        System.out.println(Integer.toBinaryString(y));
        String s;

        //����ʱֻȷ���������ӣ�1086865489,452372241
        HashMap<String, String> hashMap = new HashMap<>(1);
        for (int i = 0, j = 1000; i < j; i++) {
            hashMap.put(i + "", String.valueOf(i));
        }
        System.out.println(hashMap.get("Aa"));

        Set set = hashMap.entrySet();
        System.out.println();


        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());


        }
    }
}
