package com.opticalix.problem.leetcode;

import com.opticalix.lib.Utils;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Felix
 * @date 17/08/2019 5:57 PM
 * @email opticalix@gmail.com
 */
public class TwoSum {
    public static void main(String[] args) {
        Utils.pArr(solution2(new int[]{3,3}, 6));
        Utils.pArr(solution2(new int[]{1,2,3}, 3));
    }

    private static int[] solution1(int[] ints, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            map.put(ints[i], i);
        }
        for (int i = 0; i < ints.length; i++) {
            int remain = target - ints[i];
            if (map.containsKey(remain) && map.get(remain) != i) {
                int[] ret = {map.get(remain), i};
                Arrays.sort(ret);
                return ret;
            }
        }
        return null;
    }

    /**
     * 两个对偶 第二次能检查到即可 所以不需要准备map
     */
    private static int[] solution2(int[] ints, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            int remain = target - ints[i];
            if (map.containsKey(remain) && map.get(remain) != i) {
                int[] ret = {map.get(remain), i};
                Arrays.sort(ret);
                return ret;
            } else {
                map.put(ints[i], i);
            }
        }
        return null;
    }
}
