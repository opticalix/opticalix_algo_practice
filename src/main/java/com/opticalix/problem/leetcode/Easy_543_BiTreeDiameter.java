package com.opticalix.problem.leetcode;

import com.opticalix.lib.TreeNode;
import com.opticalix.lib.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Felix
 * @date 24/08/2019 10:05 PM
 * @email opticalix@gmail.com
 */
public class Easy_543_BiTreeDiameter {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.l = new TreeNode<>(2);
        root.r = new TreeNode<>(3);
        root.l.l = new TreeNode<>(4);
        root.l.r = new TreeNode<>(5);
        root.l.r.r = new TreeNode<>(6);

//        Utils.p(getDepth(root));
        Utils.p(diameterOfBinaryTree(root));
        LinkedList linkedList = new LinkedList();
    }

    /**
     * 回顾树高度求法，边数即树高-1
     * @param t
     * @return
     */
    private static int getDepth(TreeNode<Integer> t) {
        if (t == null) return 0;
        return Math.max(getDepth(t.l), getDepth(t.r)) + 1;
    }

    private static int max = 0;
    /**
     * 树的直径
     * 直径路径不一定过root，遍历树找到所有过当前点的左树高+右树高
     * @param root
     * @return
     */
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        if (root == null) return 0;
        depth(root);
        return max;
    }

    private static int depth(TreeNode<Integer> t) {
        if (t == null) return 0;
        int lDepth = depth(t.l);
        int rDepth = depth(t.r);
        max = Math.max(lDepth + rDepth, max);
        return Math.max(lDepth, rDepth) + 1;
    }
}
