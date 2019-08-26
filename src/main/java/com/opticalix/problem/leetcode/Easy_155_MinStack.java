package com.opticalix.problem.leetcode;

import com.opticalix.lib.Utils;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 多一个min stack记录最小值 只要求getMin常数时间 push/pop时可以调整
 */
class Easy_155_MinStack {

    public static void main(String[] args) {
        Easy_155_MinStack minStack = new Easy_155_MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        Utils.p(minStack.getMin());
        minStack.pop();
        Utils.p(minStack.getMin());
        minStack.pop();
        Utils.p(minStack.getMin());
        minStack.pop();
        Utils.p(minStack.getMin());
    }

    LinkedList<Integer> stack;
    LinkedList<Integer> min;
    int minElement;

    /**
     * initialize your data structure here.
     */
    public Easy_155_MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x < minElement) {
            min.push(x);
            minElement = x;
        } else {
            final int size = min.size();
            for (int i = 0; i < size; i++) {
                if (min.get(i) >= x) {
                    min.add(i, x);
                    break;
                }
            }
            minElement = getMin();
        }
    }

    public void pop() {
        int x = stack.pop();
        Iterator<Integer> iterator = min.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == x) {
                iterator.remove();
                break;
            }
        }
//        min.removeIf(integer -> integer == x);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}