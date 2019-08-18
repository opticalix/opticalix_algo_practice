package com.opticalix.problem.leetcode;

import com.opticalix.lib.Utils;

/**
 * 892
 * @author Felix
 * @date 17/08/2019 5:30 PM
 * @email opticalix@gmail.com
 */
public class ThreeDimSurfaceArea {
    public static void main(String[] args) {
        int[][] ints;
        ints = new int[][]{{1, 1}, {1, 2}};
        Utils.p(leetcode892(ints));
    }

    private static int leetcode892(int[][] grid) {
        int total = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = grid[i][j];
                if (val > 0) {
                    total += 2;
                }
                total += Math.max(0, val - neighborVal(grid, i - 1, j, n, m));
                total += Math.max(0, val - neighborVal(grid, i + 1, j, n, m));
                total += Math.max(0, val - neighborVal(grid, i, j - 1, n, m));
                total += Math.max(0, val - neighborVal(grid, i, j + 1, n, m));
            }
        }
        return total;
    }

    private static int neighborVal(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) return 0;
        return grid[i][j];
    }
}
