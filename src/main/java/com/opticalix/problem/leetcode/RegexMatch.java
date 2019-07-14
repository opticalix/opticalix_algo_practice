package com.opticalix.problem.leetcode;

import com.opticalix.lib.Utils;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching
 * 递归解法会超时
 */
public class RegexMatch {
    public static void main(String[] args) {
//        boolean result = isMatch("a", "ab*");//t
//        boolean result = isMatch("aab", "c*a*b");//t
//        boolean result = isMatch("mississippi", "mis*is*p*.");//f
//        boolean result = isMatch("a", "ab*c*");//t
//        boolean result = isMatch("ab", ".*c");
        boolean result = isMatch("a", ".*..a*");
        Utils.p(result);
    }

    @Deprecated
    public static boolean isMatch(String s, String p, int sStart, int pStart) {
        if (s.length() < sStart || p.length() < pStart) {
            return false;
        }
        s = s.substring(sStart, s.length());
        p = p.substring(pStart, p.length());
        if (isEmpty(s) && isEmpty(p)) {
            return true;
        }
        if (!isEmpty(s) && isEmpty(p)) {
            return false;
        }
        if (isStarPattern(p)) {//带*
            if (p.charAt(0) == '.' || (s.length() > 0 && p.charAt(0) == s.charAt(0))) {
                return isMatch(s, p, sStart, pStart + 2)//0个
                        || isMatch(s, p, sStart + 1, pStart + 2)//1个
                        || isMatch(s, p, sStart + 1, pStart);//>1个
            } else {
                return isMatch(s, p, sStart, pStart + 2);
            }
        } else {
            if (p.charAt(0) == '.' || (s.length() > 0 && p.charAt(0) == s.charAt(0))) {
                return isMatch(s, p, sStart + 1, pStart + 1);
            } else {
                return false;
            }
        }
    }

    /**
     * 重点是分割子问题 以及子问题要考虑全面
     */
    public static boolean isMatch(String s, String p) {
        if (isEmpty(s) && isEmpty(p)) {
            return true;
        }
        if (!isEmpty(s) && isEmpty(p)) {
            return false;
        }
//        if (isEmpty(s) && isStarPattern(p)) {
//            return isMatch(s, p.substring(2, p.length()));
//        }
        if (isStarPattern(p)) {//带*
            if (s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
                return isMatch(s, p.substring(2, p.length()))//0个
                        || isMatch(s.substring(1, s.length()), p.substring(2, p.length()))//1个
                        || isMatch(s.substring(1, s.length()), p);//>1个
            } else {
                return isMatch(s, p.substring(2, p.length()));
            }
        } else {
            if (s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
                return isMatch(s.substring(1, s.length()), p.substring(1, p.length()));
            } else {
                return false;
            }
        }
    }

    private static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    private static boolean isStarPattern(String p) {
        return p.length() > 1 && p.charAt(1) == '*';
    }
}
