package org.xigua.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xigua
 * @description
 * @date 2020/6/28
 **/
public class Lc3无重复字符的最长子串 {
    public static void main(String[] args) {

        Lc3无重复字符的最长子串.MylengthOfLongestSubstring("bbbb");
    }

    private static int MylengthOfLongestSubstring(String s) {
        //思路 所有的组合维护到一个hash桶中，k是键 v是重复次数，先遍历剔除有重复字母的，最后遍历出键最长的。
        char[] chars = s.toCharArray();
        HashMap<String, Integer> hashMap = new HashMap<>(16);
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j <= chars.length; j++) {
                //i 到 i.length
                String key = s.substring(i, j);
                Object value = hashMap.get(key);

                if (value != null) {
                    int version = (int) value;
                    version = version + 1;
                    hashMap.put(key, version);
                } else {
                    hashMap.put(key, 1);
                }
            }
        }

        //生成一个无重复字母的集合
        HashMap<String, Integer> hashMap1 = new HashMap(16);
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = "";
            boolean b = false;
            String key = (String) entry.getKey();
            int value = (int) entry.getValue();

            char[] chars1 = key.toCharArray();

            for (int i = 0; i < chars1.length; i++) {
                String ch = String.valueOf(chars1[i]);
                if (str.contains(ch)) {
                    b = false;
                    break;
                } else {
                    b = true;
                    str = str + ch;
                }
            }
            if (b) {
                hashMap1.put(key, value);
            }
        }
        hashMap.clear();

        //找出最大长度的
        int maxSize = 0;
        for (Map.Entry entry : hashMap1.entrySet()) {
            String str = (String) entry.getKey();
            if (maxSize <= str.length()) {
                maxSize = str.length();
            }
        }
        System.out.println(maxSize);
        return maxSize;
    }
}
