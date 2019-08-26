package com.opticalix.problem.leetcode;

import java.util.LinkedList;

/**
 * @author Felix
 * @date 24/08/2019 9:05 PM
 * @email opticalix@gmail.com
 */
public class Easy_20_ValidParentheses {
    public static void main(String[] args) {
        isValid("()");
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (stack.peek() != null && match(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    private static boolean match(char c1, char c2) {
        return Math.abs(c1 - c2) == 2 || Math.abs(c1 - c2) == 1;
    }
}
