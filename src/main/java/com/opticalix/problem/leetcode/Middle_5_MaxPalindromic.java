package com.opticalix.problem.leetcode;

import com.opticalix.lib.Utils;

/**
 * @author Felix
 * @date 25/08/2019 1:32 PM
 * @email opticalix@gmail.com
 */
public class Middle_5_MaxPalindromic {
    public static void main(String[] args) {
        Utils.p(longestPalindrome("aacdefcaa"));
        Utils.p(longestPalindrome("babad"));
        Utils.p(longestPalindrome("cbbd"));
        Utils.p(longestPalindrome("abcda"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        if (s == null || n == 0) return "";
        int[][] tmp = new int[n][n];
        String ret = s.substring(0, 1);
        //initial state
        for (int i=0; i<n; i++) {
            tmp[i][i] = 1;
            if (i + 1 < n && s.charAt(i) == s.charAt(i+1)) {
                tmp[i][i+1] = 2;
                ret = s.substring(i, i+2);
            }
        }
        //注意遍历顺序 倒三角
        for (int i=2; i<n; i++) {//代表子串长-1
            for (int j=0; j<n-i; j++) {//代表行
                if (s.charAt(j) == s.charAt(i+j) && tmp[j+1][i+j-1] == i-1) {
                    tmp[j][i+j] = tmp[j+1][i+j-1] + 2;
                } else {
                    tmp[j][i+j] = 0;
                }
                if (tmp[j][i+j] > ret.length()) {
                    ret = s.substring(j, i+j+1);
                }
            }
        }
        return ret;
    }
}
