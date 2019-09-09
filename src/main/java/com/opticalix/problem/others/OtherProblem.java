package com.opticalix.problem.others;

/**
 * @author Felix
 * @date 07/09/2019 11:13 AM
 * @email opticalix@gmail.com
 */
public class OtherProblem {
    public static void main(String[] args) {
//        System.out.println(findFirstNum(new int[]{1,2,3,3,4}, 2));
    }

    /**
     * 有序数组查找第一个target，要求持续二分。当年好奇心的面试题！
     * @param nums
     * @param key
     * @return
     */
    private static int findFirstNum(int[] nums, int key) {
        int s = 0, e = nums.length - 1;
        int mid = 0;
        while (s <= e) {
            mid = (s + e) / 2;
            if (nums[mid] < key) {
                s = mid + 1;
            } else if (nums[mid] > key) {
                e = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] < nums[mid]) {
                    break;
                } else {
                    e = mid - 1;
                }
            }
        }
        if (key == nums[mid]) {
            return mid;
        } else {
            return -1;
        }
    }

}
