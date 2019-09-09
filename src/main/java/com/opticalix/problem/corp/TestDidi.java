package com.opticalix.problem.corp;

import java.util.Scanner;

/**
 * @author Felix
 * @date 28/08/2019 9:47 AM
 * @email opticalix@gmail.com
 */
public class TestDidi {

    /**
     * 项目分配问题，求矩阵列最大值即可
     */
    private static void p1() {

    }
    /**
     * 公式调换数字问题
     * FIXME
     * 6
     * 3 + 2 + 1 + -4 * -5 + 1
     */
    private static void p2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String oriExpr = sc.nextLine();
        String[] ele = oriExpr.split(" ");
//        ArrayList<Integer> opNum = new ArrayList<>();
//        ArrayList<String> opAdd = new ArrayList<>();
//        ArrayList<String> opMul = new ArrayList<>();
//        ArrayList<String> opOther = new ArrayList<>();

        int s = -1, e = -1;
        String pre = null;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ele.length; i++) {
            String v = ele[i];
            if (!isOp(v)) continue;
            //找连续加和连续乘
            if ("+".equals(v) || "*".equals(v)) {
                if (s == -1) {
                    pre = v;
                    s = i;
                }
            } else {
                if (s != -1) {
                    e = i;
                    builder.append(ele[s - 1]);
                    builder.append(" ");
                    for (int j = s; j <= e; j++) {
                        //sort
                        builder.append(pre);
                    }
                    builder.append(ele[e + 1]);
                    builder.append(" ");

                    //reset
                    s = -1;
                    e = -1;
                    pre = null;
                }
            }
        }
        System.out.println(builder.toString());
    }


    private static boolean isOp(String c) {
        return c.equals("+")
                || c.equals("-")
                || c.equals("*")
                || c.equals("/");
    }

    private static boolean isOp(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
