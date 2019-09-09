package com.opticalix.problem.leetcode;

import com.opticalix.lib.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯
 * TODO easy个p啊 还没搞懂
 * @author Felix
 * @date 07/09/2019 1:57 PM
 * @email opticalix@gmail.com
 */
public class Easy_784_LetterPermutation {

    public static void main(String[] args) {
        Utils.p(letterCasePermutation("a1b1"));
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        dg(S.toCharArray(), 0, ans);
        return ans;
    }

    public static void dg(char[] s, int i, List<String> ans) {
        Utils.p("s=" + String.valueOf(s) + ", i=" + i);
        if (i == s.length) {
            ans.add(String.valueOf(s));
            return;
        }
        dg(s, i + 1, ans);
        if (Character.isLetter(s[i])) {
            s[i] ^= (1 << 5);
            dg(s, i + 1, ans);
        }
    }
}
