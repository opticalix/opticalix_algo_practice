package com.opticalix.problem.leetcode;

import org.junit.Assert;

import static org.junit.Assert.*;

public class RegexMatchTest {
    @org.junit.Test
    public void isMatch() {
        Assert.assertTrue(RegexMatch.isMatch("a", "ab*"));
        Assert.assertTrue(RegexMatch.isMatch("aab", "c*a*b"));
        Assert.assertFalse(RegexMatch.isMatch("mississippi", "mis*is*p*."));
        Assert.assertTrue(RegexMatch.isMatch("a", "ab*c*"));
        Assert.assertFalse(RegexMatch.isMatch("ab", ".*c"));
        Assert.assertFalse(RegexMatch.isMatch("a", ".*..a*"));
        Assert.assertFalse(RegexMatch.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
    }
}