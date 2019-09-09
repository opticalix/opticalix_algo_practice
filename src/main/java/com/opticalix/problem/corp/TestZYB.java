package com.opticalix.problem.corp;

import java.util.*;

/**
 * @author Felix
 * @date 05/09/2019 9:01 PM
 * @email opticalix@gmail.com
 */
@SuppressWarnings("Duplicates")
public class TestZYB {

    private static boolean[][] sVisited;
    private static int sMax;
    private static List<List<Integer>> sNums;

    public static void main(String[] args) {
        p3_2();
    }

    /**
     * 最少硬币数 dp 自下而上法 O(MN)
     * AC
     * https://leetcode-cn.com/problems/coin-change/solution/ling-qian-dui-huan-by-leetcode/
     */
    private static void p2() {

    }

    /**
     * bfs
     */
    private static void p3_2() {
        Scanner in = new Scanner(System.in);
        sNums = new ArrayList<>();
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        sVisited = new boolean[n][m];
        for (int k = 0; k < n; k++) {
            String line = in.nextLine();
            String[] split = line.split(" ");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                list.add(Integer.valueOf(split[i]));
            }
            sNums.add(list);
        }

        sMax = 0;
        LinkedList<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Integer val = sNums.get(i).get(j);
                if (!sVisited[i][j] && val == 1) {
                    //代表未处理过的子图
                    sVisited[i][j] = true;
                    queue.add(new Integer[]{i, j});
                    int size = 0;
                    while (!queue.isEmpty()) {
                        Integer[] remove = queue.remove();
                        int x = remove[0];
                        int y = remove[1];
                        sVisited[x][y] = true;
                        size++;
                        if (isValidCoordinate(x - 1, y)) queue.add(new Integer[]{x - 1, y});
                        if (isValidCoordinate(x + 1, y)) queue.add(new Integer[]{x + 1, y});
                        if (isValidCoordinate(x, y - 1)) queue.add(new Integer[]{x, y - 1});
                        if (isValidCoordinate(x, y + 1)) queue.add(new Integer[]{x, y + 1});
                    }
                    sMax = Math.max(sMax, size);
                    queue.clear();
                }
            }
        }
        System.out.println(sMax);
    }

    private static boolean isValidCoordinate(int x, int y) {
        return x >= 0 && y >= 0 && x < sNums.size() && y < sNums.get(0).size()
                && !sVisited[x][y]
                && sNums.get(x).get(y) == 1;
    }

    /**
     * 给二维矩阵 找出孤立连接的最大个数
     * dfs
     */
    private static void p3() {
        Scanner in = new Scanner(System.in);
        sNums = new ArrayList<>();
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        sVisited = new boolean[n][m];
        for (int k = 0; k < n; k++) {
            String line = in.nextLine();
            String[] split = line.split(" ");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                list.add(Integer.valueOf(split[i]));
            }
            sNums.add(list);
        }

        sMax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int segMax = dfs(i, j);
                sMax = Math.max(sMax, segMax);
            }
        }
        System.out.println(sMax);
    }

    private static int dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= sNums.size() || j >= sNums.get(0).size() || sVisited[i][j]) {
            return 0;
        }
        Integer val = sNums.get(i).get(j);
        sVisited[i][j] = true;
        if (val == 1) {
            return  1 +
                    dfs(i - 1, j) +
                    dfs(i + 1, j) +
                    dfs(i, j - 1) +
                    dfs(i, j + 1);
        } else {
            return 0;
        }
    }
}
