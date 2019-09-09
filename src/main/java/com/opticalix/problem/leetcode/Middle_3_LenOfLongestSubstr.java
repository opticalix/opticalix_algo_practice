package com.opticalix.problem.leetcode;

import com.opticalix.lib.Utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 最长无重复子序列
 * @author Felix
 * @date 28/08/2019 10:14 AM
 * @email opticalix@gmail.com
 */
@SuppressWarnings("Duplicates")
public class Middle_3_LenOfLongestSubstr {
    public static void main(String[] args) {
        Utils.p(lengthOfLongestSubstring("abcac"));//3
        Utils.p(lengthOfLongestSubstring("pwwkew"));//3
        Utils.p(lengthOfLongestSubstring("bbbbb"));//1
        Utils.p(lengthOfLongestSubstring(""));//0
        Utils.p(lengthOfLongestSubstring(" "));//1
        Utils.p(lengthOfLongestSubstring("a"));//1
    }

    /**
     * Sliding window
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring_(String str) {
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        int s = 0, e = -1;
        //外循环为窗口尾，内循环修正窗口头
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (set.contains(c)) {
                maxLen = Math.max(maxLen, e - s + 1);
                while (set.contains(c)) {
                    set.remove(str.charAt(s++));
                }
            }
            e++;
            set.add(c);
        }
        maxLen = Math.max(maxLen, e - s + 1);
        return maxLen;
    }

    /**
     * 换while写滑动窗口
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring(String str) {
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        int s = 0, e = 0;
        int len = str.length();
        while (s < len && e < len) {
            while (e < len && !set.contains(str.charAt(e))) {
                set.add(str.charAt(e));
                e++;
            }
            maxLen = Math.max(maxLen, e - s);
            while(s < e && set.contains(str.charAt(s))) {
                set.remove(str.charAt(s++));
            }
        }
        return maxLen;
    }

    /**
     * 利用map记录重复char位置 减少内循环次数 TODO
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring3(String str) {
        int maxLen = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        int s = 0, e = 0;
//        int len = str.length();
//        while (s < len && e < len) {
//            while (e < len && !map.containsKey(str.charAt(e))) {
//                map.put(str.charAt(e), e);
//                e++;
//            }
//            maxLen = Math.max(maxLen, e - s);
//            while(s < e && map.containsKey(str.charAt(s))) {
//                set.remove(str.charAt(s++));
//            }
//        }
        return maxLen;
    }
}
