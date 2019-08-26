package com.opticalix.problem.leetcode;

import com.opticalix.lib.Utils;

/**
 * @author Felix
 * @date 24/08/2019 12:25 PM
 * @email opticalix@gmail.com
 */
public class Easy_169_NonDecreasingArr {
    public static void main(String[] args) {
        Utils.p(checkPossibility(new int[]{1,4,3}));//T
        Utils.p(checkPossibility(new int[]{4,2,3}));//T
        Utils.p(checkPossibility(new int[]{4,2,1}));//F
        Utils.p(checkPossibility(new int[]{3,2,1}));//F
        Utils.p(checkPossibility(new int[]{1,0}));//T
        Utils.p(checkPossibility(new int[]{3,4,2,3}));//F
    }

    /**
     * O(n^2)
     * @param nums
     * @return
     */
    public static boolean checkPossibilityN2(int[] nums) {
        if (nums.length == 1) return true;
        out:
        for (int i = 0; i < nums.length; i++) {
            int pre = Integer.MIN_VALUE;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                if (pre != Integer.MIN_VALUE && pre > nums[j]) {
                    continue out;
                } else {
                    pre = nums[j];
                }
            }
            return true;
        }
        return false;
    }

    /**
     * O(N)
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        if (nums.length == 1) return true;
        int issueCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    nums[i] = nums[i + 1];
                    issueCnt++;
                }
            } else if (i == nums.length - 1) {
                if (nums[i - 1] > nums[i]) {
                    //不用修改了
                    issueCnt++;
                }
            } else {
                if (nums[i] > nums[i + 1]) {
                    if (nums[i - 1] > nums[i + 1]) {
                        nums[i + 1] = nums[i];
                    } else {
                        nums[i] = nums[i + 1];
                    }
                    issueCnt++;
                }
            }
//            if (i - 1 >= 0 && nums[i - 1] > nums[i]) {
//                nums[i] = nums[i - 1];
//                issueCnt++;
//            } else if (i + 1 < nums.length && nums[i] > nums[i + 1]) {
//                nums[i] = nums[i + 1];
//                issueCnt++;
//            }
        }
        return issueCnt <= 1;
    }
}
