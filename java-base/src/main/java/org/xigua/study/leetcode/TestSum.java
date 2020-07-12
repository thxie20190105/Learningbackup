package org.xigua.study.leetcode;

/**
 * @author xigua
 * @description
 * @date 2020/6/2
 **/
public class TestSum {
    public static void main(String[] args) {
        int[] i = {2, 3, 4, 5, 6, 7, 8, 9};

        int target = 10;
        i = TestSum.sum(i, target);
        System.out.println(i);
    }

    /**
     * 想法是对的，使用减法，但是没有用到hash表，用hash O(1)会更好。
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] sum(int[] nums, int target) {
        int[] index;
        for (int ii = 0, j = nums.length; ii < j; ii++) {
            int a = nums[ii];
            int b = target - a;
            for (int f = 0, ff = nums.length; f < ff; f++) {
                if (nums[f] == b) {
                    index = new int[]{ii, f};
                    return index;
                }
            }
        }

        return nums;
    }
}
