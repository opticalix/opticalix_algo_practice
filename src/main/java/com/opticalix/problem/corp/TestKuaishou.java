package com.opticalix.problem.corp;

import com.opticalix.lib.TreeNode;
import com.opticalix.lib.Utils;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Felix
 * @date 26/08/2019 10:00 AM
 * @email opticalix@gmail.com
 */
public class TestKuaishou {
    public static void main(String[] args) {
//        System.out.println(serialize(TreeNode.testTree()));
//        System.out.println(TreeNode.testTree().toString());
//        System.out.println(new Gson().fromJson(TreeNode.testTree().toString(), TreeNode.class));
        System.out.println(deserialize("531$$$6$$"));
        System.out.println(serialize(deserialize("531$$$6$$")));
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

    /**
     * 二叉树序列化
     * 其实用先序遍历即可，空用特殊字符实现
     * @param root
     * @return
     */
    private static String serialize(TreeNode<Integer> root) {
        if (root == null) {
            return "$";
        } else {
            return root.val + serialize(root.l) + serialize(root.r);
        }
    }

    /**
     * 二叉树的反序列化
     * 这里不能用param传递参数 要用全局queue或list 这样直接remove就好了
     * @param s
     * @return
     */
    private static TreeNode<Integer> deserialize(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> queue = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            queue.add(chars[i]);
        }
        return deserialize(queue);
    }

    private static TreeNode<Integer> deserialize(LinkedList<Character> q) {
        if (q == null || q.isEmpty()) {
            return null;
        } else {
            TreeNode<Integer> node = new TreeNode<>();
            Character c = q.removeFirst();
            if (c == '$') {
                return null;
            } else {
                node.val = c - '0';
                node.l = deserialize(q);
                node.r = deserialize(q);
            }
            return node;
        }
    }
}
