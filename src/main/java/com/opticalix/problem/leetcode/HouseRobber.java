package com.opticalix.problem.leetcode;

import com.opticalix.lib.Utils;

public class HouseRobber {
    public static void run(String[] args) {
        int[] nums = {5, 2, 3, 9, 1};
        int result = rob1(nums);
        Utils.p("result=" + result);
    }

    /**
     * 子问题是：以i为结尾的houses，最大抢劫金额。其实和斐波那契数列、跳台阶都还是一类问题，
     * 可以使用O(n)的memo，也可以使用2个变量记录-O(1)
     * https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
     * @param nums
     * @return money
     */
    public static int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] robMax = new int[nums.length];
        robMax[0] = nums[0];
        robMax[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length; i++) {
            if (robMax[i-2] + nums[i] > robMax[i-1]) {
                robMax[i] = robMax[i-2] + nums[i];
            } else{
                robMax[i] = robMax[i-1];
            }
        }
        return robMax[nums.length - 1];
    }

    //TODO
    public static int rob2(int[] nums) {
        return 0;
    }
}
