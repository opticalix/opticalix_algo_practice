package com.opticalix.problem.corp;

import com.opticalix.lib.Utils;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Felix
 * @date 26/08/2019 10:00 AM
 * @email opticalix@gmail.com
 */
public class TestKuaishou {
    public static void main(String[] args) {
        p1();
    }

    private static void p2() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        while (n-- > 0) {
            int num = sc.nextInt();
            int total = 0;
            for (int i = 0; i < 1000; i++) {
                while (num > 0) {
                    int v = num % 10;
                    num = num / 10;
                    total = total + v * v;
                }
                if (total == 1) {
                    break;
                } else {
                    num = total;
                    total = 0;
                }
            }
            if (total == 1) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }

        }
    }

    private static void p3() {
        Scanner sc = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        StringTokenizer t1 = new StringTokenizer(line1);
        StringTokenizer t2 = new StringTokenizer(line2);
        int n = t1.countTokens();
        int m = t2.countTokens();
        int cnt = 0;
        if (n > 0 && m > 0) {
            for (int i = 0; i < n; i++) {
                builder.append(t1.nextToken());
                builder.append(" ");
                if (i % 4 == 3) {
                    builder.append(t2.nextToken());
                    builder.append(" ");
                    cnt++;
                    if (cnt == m) break;
                }
            }
        }
        while (t1.hasMoreTokens()) {
            builder.append(t1.nextToken());
            builder.append(" ");
        }
        while (t2.hasMoreTokens()) {
            builder.append(t2.nextToken());
            builder.append(" ");
        }
        String s = builder.toString();
        System.out.println(s.substring(0, s.length() - 1));
    }

    private static void p1() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[] fmt1 = new int[4];
        int[] fmt2 = new int[4];
        while (n-- > 0) {
            String line = sc.nextLine();
            String[] vers = line.split(" ");
            String v1 = vers[0];
            String v2 = vers[1];

            getFmt(v1, fmt1);
            getFmt(v2, fmt2);

            Utils.pArr(fmt1);
            Utils.pArr(fmt2);

            boolean bt = false;
            for (int i = 0; i < 4; i++) {
                if (fmt2[i] < fmt1[i]) {
                    bt = false;
                    break;
                } else if (fmt2[i] > fmt1[i]){
                    bt = true;
                    break;
                }
            }
            System.out.println(bt);
        }
    }

    private static void getFmt(String v1, int[] fmt1) {
        String[] split = v1.split("\\.");
        for (int i = 0; i < 4; i++) {
            if (i < split.length) {
                fmt1[i] = Integer.valueOf(split[i]);
            } else {
                fmt1[i] = 0;
            }
        }
    }
}
