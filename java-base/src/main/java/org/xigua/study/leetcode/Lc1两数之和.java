package org.xigua.study.leetcode;

import java.util.HashMap;

/**
 * @author xigua
 * @description
 * @date 2020/6/27
 **/
public class Lc1两数之和 {
    public static void main(String[] args) {

        int target = 6;
        int[] nums = {3, 2, 4};
        int[] ints = Lc1两数之和.twoSum(nums, target);
        System.out.println(ints[0]);
        System.out.println(ints[1]);

    }

    private static int[] twoSum(int[] nums, int target) {

        int[] retu = new int[2];
        HashMap hashMap = new HashMap(16);
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            Object o = hashMap.get(target - nums[i]);
            if (o != null) {
                for (int a = 0; a < nums.length; a++) {
                    if (nums[a] == (int) o && a != i) {
                        retu[0] = a;
                        retu[1] = i;
                        return retu;
                    }
                }
            }
        }

        return null;
    }

}
