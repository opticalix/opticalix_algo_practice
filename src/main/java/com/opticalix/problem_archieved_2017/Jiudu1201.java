package com.opticalix.problem_archieved_2017;

import java.util.*;
import java.io.*;

/*
 * ※ 大水题
 * ※※ 小水题
 * ※※※ 稍难 数据结构&数学技巧
 * ※※※※ 复杂数据结构&贪心&动归
 * ※※※※※ 无法AC
 */

/**
 * 22:29-23:04
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1201 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useSc();
//		useBr();
		System.exit(0);
	}
	static Node root;
	static int printCnt;
	static class Node{
		int val;
		Node l;
		Node r;
		public Node(int i) {
			val = i;
		}
	}
	
	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			int realN = 0;
			root = null;
			int n = Integer.valueOf(sc.nextLine());
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			while(st.hasMoreTokens()){
				realN+=buildTree(Integer.valueOf(st.nextToken()));
			}
			
			//print
			printCnt=realN;
			preOrderNonRecursively(root);
			printCnt=realN;
			inOrderNonRecursively(root);
			printCnt=realN;
			postOrderTraversal(root);
		}
		sc.close();
	}
	
	public static void preOrderNonRecursively(Node root){
		LinkedList<Node> stack = new LinkedList<Node>();
		Node curr = root;
		while(curr!=null || !stack.isEmpty()){
			//turn left...until end
			while(curr!=null){
				System.out.print(curr.val+ (--printCnt>0?" ":" \n"));
				stack.push(curr);
				curr=curr.l;
			}
			if(!stack.isEmpty()){
				curr = stack.pop();
				curr = curr.r;
			}
		}
	}
	public static void inOrderNonRecursively(Node root){
		LinkedList<Node> stack = new LinkedList<Node>();
		Node curr = root;
		while(curr!=null || !stack.isEmpty()){
			//turn left...until end
			while(curr!=null){
				stack.push(curr);
				curr=curr.l;
			}
			if(!stack.isEmpty()){
				curr = stack.pop();
				System.out.print(curr.val+ (--printCnt>0?" ":" \n"));
				curr = curr.r;
			}
		}
	}
	
	public static void preOrderTraversal(Node root){
		System.out.print(root.val+ (--printCnt>0?" ":" \n"));
		if(root.l != null){
			preOrderTraversal(root.l);
		}
		if(root.r != null){
			preOrderTraversal(root.r);
		}
	}
	
	public static void postOrderTraversal(Node root){
		if(root.l != null){
			postOrderTraversal(root.l);
		}
		if(root.r != null){
			postOrderTraversal(root.r);
		}
		System.out.print(root.val+ (--printCnt>0?" ":" \n"));
	}
	
	public static void inOrderTraversal(Node root){
		if(root.l != null){
			inOrderTraversal(root.l);
		}
		System.out.print(root.val+ (--printCnt>0?" ":" \n"));
		if(root.r != null){
			inOrderTraversal(root.r);
		}
	}
	
	private static int buildTree(Integer i) {
		Node curr = root;
		Node parent = null;
		boolean left = true;
		while(curr!=null){
			parent = curr;
			if(curr.val > i){
				curr = curr.l;
				left = true;
			}else if(curr.val < i){
				curr = curr.r;
				left = false;
			}else{
				return 0;//ignore
			}
		}
		if(parent==null){
			root = new Node(i);
		}else{
			if(left){
				parent.l = new Node(i);
			}else{
				parent.r = new Node(i);
			}
		}
		return 1;
	}
	private static void useBr() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=br.readLine()) != null){
			StringTokenizer st = new StringTokenizer(line);
			
		}
		br.close();
	}

	public static void p(Object o) {
		System.out.println(o);
	}
}
