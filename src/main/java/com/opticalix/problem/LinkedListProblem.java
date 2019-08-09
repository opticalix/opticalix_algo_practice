package com.opticalix.problem;

import com.opticalix.lib.Node;
import com.opticalix.lib.Utils;

import java.util.Arrays;

/**
 * @author Felix
 * @date 09/08/2019 8:30 PM
 * @email opticalix@gmail.com
 */
public class LinkedListProblem {
    public static void main(String[] args) {
        //链表反转
        Node<Integer> head = Node.create(Arrays.asList(1,2,3,4));
        Node.printLinkedList(linkedListReverse(head));

        //链表合并
        Node<Integer> n1 = Node.create(Arrays.asList(2, 5, 10));
        Node<Integer> n2 = Node.create(Arrays.asList(1, 3, 10));
        Node.printLinkedList(linkedListMerge(n1, n2));

        /*
        x x x x
            x   x
              x
         */
        Node<Integer> headWithRing = Node.create(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Node.tail(headWithRing).next = Node.findOnly(headWithRing, 4);
        Node<Integer> ringEntr = findLinkedListRingEntr(headWithRing);
        Utils.p(ringEntr.val);
    }

    /**
     * 合并有序子链表为升序链表, 递归
     * @param n1
     * @param n2
     */
    private static Node<Integer> linkedListMergeRecursively(Node<Integer> n1, Node<Integer> n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.val < n2.val) {
            n1.next = linkedListMergeRecursively(n1.next, n2);
            return n1;
        } else {
            n2.next = linkedListMergeRecursively(n1, n2.next);
            return n2;
        }
    }

    /**
     * 合并有序子链表为升序链表
     * @param n1
     * @param n2
     */
    private static Node<Integer> linkedListMerge(Node<Integer> n1, Node<Integer> n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        Node<Integer> head = null;
        Node<Integer> curr = null;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                if (curr == null) {
                    curr = n1;
                    head = n1;
                } else {
                    curr.next = n1;
                    curr = curr.next;
                }
                n1 = n1.next;
            } else {
                if (curr == null) {
                    curr = n2;
                    head = n2;
                } else {
                    curr.next = n2;
                    curr = curr.next;
                }
                n2 = n2.next;
            }
        }
        return head;
    }

    private static Node<Integer> linkedListReverse(Node<Integer> head) {
        Node<Integer> pre = null, curr = head, next;
        while (curr != null) {
            next = curr.next;//记录next
            curr.next = pre;//改变指向
            pre = curr;//指针更新
            curr = next;//指针更新
        }
        return pre;
    }

    /**
     * a是起点到环入口长度，b是环入口到双指针相遇长度，R是环长度
     * 单步的 走了 s = a + b 步
     * 双步的 走了 2s = a + b + kR 步
     * 1代入2得（目的消除s，s没啥用） 2a + 2b = a + b + kR -> a = kR - b
     * 故在双指针相遇后，撤快指针放第二个慢指针从头开始，走a步与原慢指针相遇得入口位置
     *
     * 找到链表环的入口节点
     * @param head
     */
    private static Node<Integer> findLinkedListRingEntr(Node<Integer> head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node<Integer> slow, fast, slow2;
        //注意起始状态，需都定位node[0]
        slow = head.next;
        fast = head.next.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow2 = head;
        while (slow != slow2) {
            slow = slow.next;
            slow2 = slow2.next;
        }
        return slow;
    }


}
