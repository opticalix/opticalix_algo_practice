package com.opticalix.problem.leetcode;

import com.opticalix.lib.Utils;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/largest-values-from-labels/solution/tan-xin-hen-jian-dan-de-si-lu-han-ti-yi-fen-xi-by-/
 */
public class largestValuesFromLabels {
    public static void main(String[] args) {
        int ret = largestValsFromLabels2(new int[]{9,8,8,7,6}, new int[]{0,0,0,1,1}, 3, 2);
        Utils.p("ret=" + ret);
    }

    /**
     * 其实按values排序从大到小即可 贪心 条件到边界则中断
     * @param values
     * @param labels
     * @param num_wanted
     * @param use_limit
     * @return
     */
    public static int largestValsFromLabels2(int[] values, int[] labels, int num_wanted, int use_limit) {
        if (num_wanted == 0 || use_limit == 0) {
            return 0;
        }
        int ret = 0;
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
        Map<Integer, Integer> labelCnt = new HashMap<>();

        //val-label map
        for (int i = 0; i < values.length; i++) {
            int k = values[i];
            PriorityQueue<Integer> maxHeap = map.get(k);
            if (maxHeap == null) {
                map.put(k, new PriorityQueue<>());
            }
            map.get(k).add(labels[i]);
            labelCnt.put(labels[i], 0);
        }
        int nums = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            Integer val = entry.getKey();
            for (Integer l : entry.getValue()) {
                if (nums >= num_wanted) {
                    return ret;
                }
                if (labelCnt.get(l) < use_limit) {
                    nums++;
                    labelCnt.put(l, labelCnt.get(l) + 1);
                    ret += val;
                }
            }
        }
        return ret;
    }

    /**
     * 思路错了 不能按label遍历 有可能某label中值很小 不值得浪费一个名额
     * @param values
     * @param labels
     * @param num_wanted
     * @param use_limit
     * @return
     */
    @Deprecated
    public static int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            int k = labels[i];
            PriorityQueue<Integer> maxHeap = map.get(k);
            if (maxHeap == null) {
                map.put(k, new PriorityQueue<>(Comparator.reverseOrder()));
            }
            map.get(k).add(values[i]);
        }
        PriorityQueue<Integer> tmp = new PriorityQueue<>(Comparator.reverseOrder());
        int ret = 0;
        while (use_limit-- > 0) {
            for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
                Integer label = entry.getKey();
                Integer largest = entry.getValue().poll();
                if (largest != null) {
                    tmp.add(largest);
                }
            }
            for (int i = 0; i < num_wanted; i++) {
                //top k sum
                Integer v = tmp.poll();
                if (v != null) {
                    ret += v;
                }
            }
            num_wanted -= tmp.size();
            tmp.clear();
        }
        return ret;
    }
}
