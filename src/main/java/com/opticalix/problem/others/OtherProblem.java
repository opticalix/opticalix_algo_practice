package com.opticalix.problem.others;

import java.util.Scanner;

/**
 * 	//	递归实现：
 * 	public  int gcd (int a,int b)
 *        {
 * 		if(a%b==0)
 *
 * 	       return b;
 * 	else
 * 	       return gcd(b,a%b);}
 *
 * 	最小公倍数是两个数字相乘除以最大公约数
 *
 *
 * public boolean isUgly(int num) {
 *         //需要特判0
 *         if (num < 1) return false;
 *         while (num % 2 == 0) num /= 2;
 *         while (num % 3 == 0) num /= 3;
 *         while (num % 5 == 0) num /= 5;
 *         return num == 1;
 *     }
 *
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

    /**
     * https://exercise.acmcoder.com/online/online_judge_ques?ques_id=1668&konwledgeId=136
     */
    public void buyStock() {
        Scanner sc = new Scanner(System.in);
        //1 2 1 2 3 2 3 4 5 4
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int ret = 1;
            Counter cnt = new Counter();

            for (int i = 1; i < n; i++) {
                if (--cnt.k < 0) {
                    cnt.reset();
                    ret--;
                } else {
                    ret++;
                }
            }
            System.out.println(ret);
        }
    }

    static class Counter {
        public int k = 1;
        public int loop = 1;
        public void reset() {
            loop++;
            k = loop;
        }
    }

}
