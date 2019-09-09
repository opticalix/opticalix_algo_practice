package com.opticalix.problem.corp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 奇安信
 * @author Felix
 * @date 09/09/2019 8:16 PM
 * @email opticalix@gmail.com
 */
public class TestQax {
    /**
     * 找公共祖先节点
     * 貌似输入的是满二叉树节点 不存在用-1表示
     * 1 这里用数组实现，栈保存父节点idx并对比找到最深的
     * 2 如果node有parent指针，也可以找到同一深度，双指针向上对比实现
     * https://www.xuebuyuan.com/3195482.html
     *
     * 4
     * 9 6 15 2 -1 12 25 -1 -1 -1 -1 -1 -1 20 37
     * 12 20
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();
        if (level <= 0) return;
        sc.nextLine();
        String line = sc.nextLine();
        String[] split = line.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);//placeholder
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.valueOf(split[i]));
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int aIdx = list.indexOf(a);
        int bIdx = list.indexOf(b);
        LinkedList<Integer> s1 = new LinkedList<>();
        LinkedList<Integer> s2 = new LinkedList<>();
        while (aIdx > 0) {
            s1.push(aIdx);
            aIdx /= 2;
        }
        while (bIdx > 0) {
            s2.push(bIdx);
            bIdx /= 2;
        }
        int lastSame = -1;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            Integer pop1 = s1.pop();
            Integer pop2 = s2.pop();
            if (pop1 != pop2) {
                break;
            } else {
                lastSame = pop1;
            }
        }
        if (lastSame > 0 && lastSame < list.size()) {
            System.out.println(list.get(lastSame));
        } else {
            System.out.println(-1);
        }
    }
}
