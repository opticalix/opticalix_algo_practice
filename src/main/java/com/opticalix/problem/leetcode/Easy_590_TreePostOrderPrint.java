package com.opticalix.problem.leetcode;

import com.opticalix.lib.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Felix
 * @date 24/08/2019 10:05 PM
 * @email opticalix@gmail.com
 */
public class Easy_590_TreePostOrderPrint {
    public static void main(String[] args) {

    }

    /**
     * 先序遍历是 自己 左 右
     * 后序遍历是 左 右 自己
     * 借助stack能够将左右互逆。最终输出时再反过来就成了后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorder(TreeNode<Integer> root) {
        LinkedList<TreeNode<Integer>> stack = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            ret.add(node.val);
            if (node.l != null) {
                stack.push(node.l);
            }
            if (node.r != null) {
                stack.push(node.r);
            }
        }
        Collections.reverse(ret);
        return ret;
    }
}
