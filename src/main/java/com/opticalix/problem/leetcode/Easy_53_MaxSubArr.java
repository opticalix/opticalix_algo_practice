package com.opticalix.problem.leetcode;

import com.opticalix.lib.Utils;

import java.util.Arrays;

/**
 * 最大子序列和
 * @author Felix
 * @date 23/08/2019 10:47 PM
 * @email opticalix@gmail.com
 */
public class Easy_53_MaxSubArr {
    public static void main(String[] args) {
        Utils.p(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int[] maxSum = new int[nums.length];
        maxSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxSum[i - 1] > 0) {
                maxSum[i] = nums[i] + maxSum[i - 1];
            } else {
                maxSum[i] = nums[i];
            }
        }
        Arrays.sort(maxSum);
        return maxSum[maxSum.length - 1];
    }
}
