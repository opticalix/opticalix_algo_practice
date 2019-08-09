package com.opticalix.lib;

import org.junit.Test;

import java.util.Arrays;

public class NodeTest {

    @Test
    public void create() {
        Node<Integer> head = Node.create(Arrays.asList(1, 2, 3));
        Node.printLinkedList(head);
    }

    @Test
    public void tail() {
        Node<Integer> head = Node.create(Arrays.asList(1, 2, 3));
        Node<Integer> tail = Node.tail(head);
        Node.printLinkedList(tail);
    }

    @Test
    public void findOnly() {
        Node<Integer> head = Node.create(Arrays.asList(1, 2, 3));
        Node<Integer> find = Node.findOnly(head, 2);
        Node.printLinkedList(find);
    }
}