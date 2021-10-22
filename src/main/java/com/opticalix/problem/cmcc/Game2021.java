package com.opticalix.problem.cmcc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Game2021 {
    public static void main(String[] args) {
        System.out.println(t3_2());
    }

    /**
     * ac
     * 样例输入
     * 4 1 2
     * 样例输出
     * 15
     * @return
     */
    private static long t1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return a + b;
        }
        long sum = a + b;
        long num = a + b + 1;
        //n>2
        for (int i = 3; i <= n; i++) {
            num = (sum + 1);
            sum = (sum + num) % 1000000007;
//            System.out.println("num=" + num + ", sum=" + sum);
        }
        return sum;
    }

    /**
     * ac
     * @return
     */
    private static int t2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();

        //remember del arr[0]
        int[] arr = new int[n + 1];
        for (; s <= t; s++) {
            int timesS = s;
            while (timesS <= n) {
                arr[timesS] = arr[timesS] == 0 ? 1 : 0;
                timesS += s;
            }
        }
        int ret = 0;
        for (int i = 1; i < arr.length; i++) {
            ret+=arr[i];
        }
        return ret;
    }

    /**
     * boxes, not ac
     * 现在有很多木箱子，每一个箱子都是标准的长方体并且都是空心的。如果一个木箱子的长、宽和高都大于（不能等于）另一个木箱子，则小的箱子可以套到大的箱子里面。（注意：此处不考虑材质本身的厚度，且每一个木箱子在嵌套的时候长、宽、高都不允许旋转）
     * 现在告诉你一些长方体木箱子的长、宽和高，请问这些木箱子最多可以嵌套多少层？
     * dp, f(i)=f(j)+1 if j<i&volume_j<volume_i
     * @return
     */
    private static int t3() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] boxes = new int[n][3];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] wlh = line.split(" ");
            boxes[i][0] = Integer.parseInt(wlh[0]);
            boxes[i][1] = Integer.parseInt(wlh[1]);
            boxes[i][2] = Integer.parseInt(wlh[2]);
        }
        Arrays.sort(boxes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[2] - o2[2];
                }
            }
        });
//        System.out.println(boxes);
        if (n == 1) return 1;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            boolean bigger = true;
            for (int j = 0; j < 3; j++) {
                if (boxes[i][j] <= boxes[i-1][j]) {
                    bigger = false;
                    break;
                }
            }
            if (bigger) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * n
     * w l h
     * ...
     *
     * to check, 没找到OJ原题
     * @return
     */
    private static int t3_2() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] boxes = new int[n][3];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] wlh = line.split(" ");
            boxes[i][0] = Integer.parseInt(wlh[0]);
            boxes[i][1] = Integer.parseInt(wlh[1]);
            boxes[i][2] = Integer.parseInt(wlh[2]);
        }
        Arrays.sort(boxes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[2] - o2[2];
                }
            }
        });
        if (n == 1) return 1;
        int[] tmp = new int[n];
        Arrays.fill(tmp, 1);
        int curr = 0;
        for (int i = 1; i < n; i++) {
            boolean bigger = true;
            for (int j = 0; j < 3; j++) {
                if (boxes[i][j] <= boxes[curr][j]) {
                    bigger = false;
                    break;
                }
            }
            if (bigger) {
                tmp[i] = tmp[i-1] + 1;
                curr = i;
            } else {
                tmp[i] = tmp[i-1];
            }
        }
        return tmp[n-1];
    }

    /**
     * 7
     * 1 2 3 3 2 5 1
     * 3
     * ac
     * @return
     */
    private static String t4() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        String[] nums = line.split(" ");
        int k = Integer.parseInt(sc.nextLine());

        int[] weight = new int[n + 1];
        for (int i = 0; i < n; i++) {
            weight[i + 1] = Integer.parseInt(nums[i]);
        }
//        System.out.println("k:" + k + ", weight of k:" + weight[k]);
//        System.out.println(dfsSum(weight, 3));
        int wL = dfsSum(weight, k * 2);
        int wR = dfsSum(weight, k * 2 + 1);
        if (wL > wR) {
            return "L";
        } else if (wL < wR) {
            return "R";
        } else {
            return "E";
        }
    }

    private static int dfsSum(int[] arr, int i) {
        if (i >= arr.length) {
            return 0;
        }
        return arr[i] + dfsSum(arr, 2 * i) + dfsSum(arr, 2 * i + 1);
    }

    /**
     * Kimi同学又在“玩”素数。他随机在N张卡片上写下了N个正整数，这N个正整数中可能存在一些相同的数字，也可能都不相同。 现在他以某一张指定的卡片作为起点，按顺时针的方向将这N张卡片连成一个圈，并且要求这个圈上面任意两张相邻卡片上的数字之和都是一个素数。当然，第1个数和最后一个数的和也为素数。这样的圈称为“素数圈”。 请问在明确起点（第1个数）的情况下有多少种不同的方案？即能够组成多少个完全不同的素数圈？ 例如：(1,2,3,4)和(2,3,4,1)是两个不同的素数圈；(1,1,2,1)和(1,2,1,1)也是两个不同的素数圈。
     * not ac
     * 题没看懂
     * @return
     */
    public static String t5() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        String[] nums = line.split(" ");

        return "No result.";
    }

    private boolean isPrimeCycle(int[] arr, int start) {
        return false;
    }

    /**
     * TODO 多重背包 DP问题
     *
     * 小明设计了一个挖掘宝石的小游戏。在游戏中有红宝石、蓝宝石、绿宝石等多种不同类型的宝石，当然也有昂贵的钻石。 现在给出一个地图，在地图上有N种不同的宝石。每一种宝石都有一颗或者多颗，同一种宝石每一颗的价值都是相同的。 此外，每一种宝石都有一个挖掘时间。 在给定的时间内，哪一个玩家挖掘的宝石的总价值最大就是游戏的赢家。 现在给出N类不同宝石的数量以及每一类宝石中每一颗的价值和挖掘时间，并且给出一个总的游戏时间T。在不考虑竞争对手的情况下，请问可以得到的最大价值是多少？
     * not ac 目前实现有误
     * @return
     */
    public static int t6() {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] split1 = line1.split(" ");
        int n = Integer.parseInt(split1[0]);
        int time = Integer.parseInt(split1[1]);
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
            arr[i][2] = Integer.parseInt(split[2]);
        }
        int[][] mem = new int[n + 1][time + 1];
        int remainTime = time;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= time; j++) {
                // 考察第i种
                if (arr[i - 1][2] <= j) {
                    int a = mem[i - 1][j];
                    int b = arr[i - 1][1] + mem[i - 1][j - arr[i - 1][2]];
//                    if (a < b) {
//                        arr[i - 1][0]--;
//                    }
                    mem[i][j] = Math.max(a, b);
                } else {
                    mem[i][j] = mem[i-1][j];
                }
            }
        }
        return mem[n][time];
    }
}
