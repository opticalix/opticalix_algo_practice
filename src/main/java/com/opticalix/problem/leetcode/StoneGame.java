package com.opticalix.problem.leetcode;

import com.opticalix.lib.Utils;

/**
 * DP
 * f(i,j)=max(piles[i]−f(i+1,j),piles[j]−f(i,j−1))
 * https://leetcode-cn.com/problems/stone-game/solution/dong-tai-gui-hua-by-cliant/
 */
public class StoneGame {
    public static void main(String[] args) {
        boolean win = stoneGame(new int[]{5});
        Utils.p(win);
    }

    public static boolean stoneGame(int[] piles) {
        //return true;
        int[][] tmp = new int[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++) {
            tmp[i][i] = piles[i];
        }
        for (int j = 1; j < piles.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (i > j || i < 0 || j < 0
                        || i >= piles.length || j >= piles.length)
                    continue;
                tmp[i][j] = Math.max(piles[i] - tmp[i+1][j], piles[j] - tmp[i][j-1]);
            }
        }
        Utils.pArr(tmp);
        return tmp[0][piles.length - 1] > 0;
    }
}
