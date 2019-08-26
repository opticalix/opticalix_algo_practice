package com.opticalix.lib;

import java.util.LinkedList;

/**
 * 貌似不是自己实现的
 * @param <T>
 */
public class TreeNode<T> {
	
	public TreeNode(T val) {
		super();
		this.val = val;
	}
	public TreeNode() {
		super();
	}

	public static void main(String[] args){
	}

	public TreeNode<T> l;
	public TreeNode<T> r;
	public T val;
	
	public static <T> void preOrderTraversal(TreeNode<T> root){
		System.out.print(root.val);
		if(root.l != null){
			preOrderTraversal(root.l);
		}
		if(root.r != null){
			preOrderTraversal(root.r);
		}
	}
	
	public static <T> void inOrderTraversal(TreeNode<T> root){
		if(root.l != null){
			inOrderTraversal(root.l);
		}
		System.out.print(root.val);
		if(root.r != null){
			inOrderTraversal(root.r);
		}
	}
	
	public static <T> void postOrderTraversal(TreeNode<T> root){
		if(root.l != null){
			postOrderTraversal(root.l);
		}
		if(root.r != null){
			postOrderTraversal(root.r);
		}
		System.out.print(root.val);
	}
	
	public static <T> void preOrderNonRecursively(TreeNode<T> root){
		LinkedList<TreeNode<T>> stack = new LinkedList<TreeNode<T>>();
		TreeNode<T> curr=null;
		while(curr!=null || !stack.isEmpty()){
			//turn left...until end
			while(curr!=null){
				System.out.print(curr.val);
				stack.push(curr);
				curr=curr.l;
			}
			if(!stack.isEmpty()){
				curr = stack.pop();
				curr = curr.r;
			}
		}
	}
	
	public static <T> void inOrderNonRecursively(TreeNode<T> root){
		LinkedList<TreeNode<T>> stack = new LinkedList<TreeNode<T>>();
		TreeNode<T> curr=null;
		while(curr!=null || !stack.isEmpty()){
			//turn left...until end
			while(curr!=null){
				stack.push(curr);
				curr=curr.l;
			}
			if(!stack.isEmpty()){
				curr = stack.pop();
				System.out.print(curr.val);
				curr = curr.r;
			}
		}
	}
	
	
	public static <T> void levelOrderTraversal(TreeNode<T> root){
		LinkedList<TreeNode<T>> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode<T> head = queue.poll();
			if(head.l!=null){
				queue.offer(head.l);
			}
			if(head.r!=null){
				queue.offer(head.r);
			}
			System.out.print(head.val);
		}
	}
}
