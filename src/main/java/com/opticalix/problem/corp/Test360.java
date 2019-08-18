package com.opticalix.problem.corp;

import com.opticalix.lib.Utils;

import java.util.*;

/**
 * @author Felix
 * @date 17/08/2019 6:24 PM
 * @email opticalix@gmail.com
 */
public class Test360 {
    public static void main(String[] args) {
        code_360_2();
    }

    /**
     * O(N^2*M)
     * 2个n位m进制数 自由组合后按位相加取余 求最大值
     * 5 5 4 4 1 1 1 4 3 0 1 2 -> 4 4 4 2 0
     * 3 10 8 1 1 9 1 0 -> 9 1 0
     */
    private static void code_360_2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int maxTarget = m - 1;
        int[] num1 = new int[n];
        int[] num2 = new int[n];
        List<Integer> a1ExIdx = new ArrayList<>();
        List<Integer> a2ExIdx = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            num1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            num2[i] = sc.nextInt();
        }

        while (result.size() < n) {
            for (int i = maxTarget; i >= 0; i--) {
                int[] used = twoSum(num1, num2, a1ExIdx, a2ExIdx, i, m);
                if (used != null) {
                    a1ExIdx.add(used[0]);
                    a2ExIdx.add(used[1]);
                    result.add(i);
                    //减少check次数
                    maxTarget = i;
                    break;
                }
            }
        }
        Utils.p(result);
    }

    /**
     * O(N)
     * @param a1
     * @param a2
     * @param a1ExIdx
     * @param a2ExIdx
     * @param target
     * @param m
     * @return
     */
    private static int[] twoSum(int[] a1, int[] a2, List<Integer> a1ExIdx, List<Integer> a2ExIdx, int target, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a1.length; i++) {
            if (a1ExIdx.contains(i)) {
                continue;
            }
            map.put(a1[i], i);
        }
        for (int i = 0; i < a2.length; i++) {
            if (a2ExIdx.contains(i)) {
                continue;
            }
            int remain = target - a2[i];
            //可能超m
            remain = remain >= 0 ? remain : remain + m;
            if (map.containsKey(remain)) {
                return new int[]{map.get(remain), i};
            }
        }
        return null;
    }

    /**
     * TLE
     * 有O(N^2)解法。见Leetcode892
     */
    private static void code_360_1() {
        int total = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][][] block = new boolean[n][m][100];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = sc.nextInt();
                for (int k = 0; k < cnt; k++) {
                    block[i][j][k] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 100; k++) {
                    if (!block[i][j][k]) break;
                    total += contribute(block, i - 1, j, k, n, m);
                    total += contribute(block, i + 1, j, k, n, m);
                    total += contribute(block, i, j - 1, k, n, m);
                    total += contribute(block, i, j + 1, k, n, m);
//                    total += contribute(block, i, j, k - 1, n, m);
//                    total += contribute(block, i, j, k + 1, n, m);
                }
                total += 2;
            }
        }
        System.out.println(total);
    }

    private static int contribute(boolean[][][] block, int i, int j, int k, int n, int m) {
        if (i >= 0 && i < n
                && j >= 0 && j < m
                && k >= 0 && k < 100
                && block[i][j][k]) {
            return 0;
        } else {
            return 1;
        }
    }
}
