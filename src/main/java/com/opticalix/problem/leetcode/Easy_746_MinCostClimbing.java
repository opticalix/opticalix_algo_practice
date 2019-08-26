package com.opticalix.problem.leetcode;

import com.opticalix.lib.Utils;

/**
 * @author Felix
 * @date 24/08/2019 2:21 PM
 * @email opticalix@gmail.com
 */
public class Easy_746_MinCostClimbing {
    public static void main(String[] args) {
        Utils.p(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        Utils.p(minCostClimbingStairs(new int[]{0, 0, 0, 1}));
    }

    //f(n)为到n层最小花费
    //f(n) = min(f(n-1), f(n-2)) + cost[n]
    public static int minCostClimbingStairs(int[] cost) {
        int[] totalCost = new int[cost.length];
        totalCost[0] = cost[0];
        totalCost[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            totalCost[i] = Math.min(totalCost[i - 1], totalCost[i - 2]) + cost[i];
        }
        return Math.min(totalCost[cost.length - 1], totalCost[cost.length - 2]);
    }
}
