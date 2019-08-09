package com.opticalix.lib;

import java.util.List;

/**
 * 单链表节点
 * @author Felix
 * @date 09/08/2019 8:32 PM
 * @email opticalix@gmail.com
 */
public class Node<T> {
    public Node<T> next;
    public T val;

    public Node(T val) {
        this.val = val;
    }

    public static <T> Node<T> create(List<T> data) {
        Node<T> head = null;
        Node<T> curr = null;
        for (T t : data) {
            Node<T> node = new Node<>(t);
            if (curr == null) {
                curr = node;
                head = node;
            } else {
                curr.next = node;
                curr = node;
            }
        }
        return head;
    }

    public static <T> void printLinkedList(Node<T> head) {
        if (head != null) {
            StringBuilder builder = new StringBuilder();
            Node i;
            for (i = head; i != null; i = i.next) {
                builder.append(i.val);
                if (i.next != null) {
                    builder.append(" -> ");
                }
            }
            Utils.p(builder.toString());
        }
    }

    public static <T> Node<T> tail(Node<T> head) {
        while (head != null && head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static <T> Node<T> findOnly(Node<T> head, T target) {
        while (head != null) {
            if (head.val.equals(target)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
