package com.opticalix.problem.corp;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Felix
 * @date 05/09/2019 2:41 PM
 * @email opticalix@gmail.com
 */
public class TestXRS {
    public static void main(String[] args) {
        p2();
    }
    /**
     * 假设今年网校有N个校招生以及笔试对应的分数,寻找出这个N个校招生的前0.1%（向上取整）,假设网校校招人数不超过1 000 000.
     * 使用堆。如何保证堆的固定size?
     * 最小堆
     */
    private static void p2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double rate = 0.1;
        int size = 1 + (int) (n * rate);
        PriorityQueue<Integer> heap = new PriorityQueue<>(size, Comparator.comparingInt(i -> i));
        while (n-- > 0) {
            int a = sc.nextInt();
            if (heap.size() < size) {
                heap.add(a);
            } else {
                if (heap.peek() != null && heap.peek() < a) {
                    heap.remove();
                    heap.add(a);
                }
            }
        }
        heap.forEach(System.out::println);
    }

    /**
     * 自实现链表node，保留第一个绝对值
     */
    private static void p1() {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        Node head = null, curr = null;
        String line = sc.nextLine();
        String[] split = line.split(" ");
        for (int i = 0; i < split.length; i++) {
            int a = Integer.valueOf(split[i]);
            int abs = Math.abs(a);
            if (!set.contains(abs)) {
                if (head == null) {
                    head = new Node(abs);
                    curr = head;
                } else {
                    curr.next = new Node(abs);
                    curr = curr.next;
                }
                set.add(abs);
            }
        }
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" ");
            }
            head = head.next;
        }
    }

    public static class Node {
        public Node next;
        public Integer val;

        public Node(Integer val) {
            this.val = val;
        }
    }

}
