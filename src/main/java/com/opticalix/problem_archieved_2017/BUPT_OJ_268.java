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
 * *** AC
 * children为list的树
 * 递归遍历，或借助queue做bfs，或借助stack做非递归遍历（因为要记来的路径所以用stack）
 * kill将该节点和其子节点都disable掉，不方便在递归时删节点，可以使用enable标记来标示这一节点已失效
 * 30min+30min
 * 
 * @author opticalix
 */
@SuppressWarnings("unused")
public class BUPT_OJ_268 {
	
	private static Scanner scanner;
	private static final String FORK="FORK";
	private static final String KILL="KILL";
	private static final String QUERY="QUERY";
	private static final String YES="Yes";
	private static final String NO="No";
	
	public static void main(String args[]) throws IOException{
		scanner = new Scanner(System.in);
		int t = Integer.valueOf(scanner.nextLine());
		while(t-->0){
			int n = Integer.valueOf(scanner.nextLine());
			Node root = new Node();
			while(n-->0){
				StringTokenizer st = new StringTokenizer(scanner.nextLine());
				String cmd = st.nextToken();
				if(cmd.equals(FORK)){
					int p = Integer.valueOf(st.nextToken());
					int c = Integer.valueOf(st.nextToken());
					root = forkUsingQueue(root, p, c);
				}else if(cmd.equals(KILL)){
					int pid = Integer.valueOf(st.nextToken());
					kill(root, pid);
				}else if(cmd.equals(QUERY)){
					int pid = Integer.valueOf(st.nextToken());
					int deep;
					if((deep = query(root, pid, 1)) == -1){
						p(NO);
					}else{
						p(YES);
					}
				}
			}
		}
		scanner.close();
		System.exit(0);
	}
	
	static class Node{
		boolean enable = true;
		int val;
		List<Node> children = new ArrayList<Node>();
		
		public Node(){
			val = 0;
		}
		
		public Node(int val){
			this.val = val;
		}
		
		public int locate(int target){
			int ret = -1;
			for(int i=0; i<children.size(); i++){
				if(target == children.get(i).val){
					ret = i;
					break;
				}
			}
			return ret;
		}
	}
	
	/**
	 * remove
	 * set enable_flag to false
	 * @param node
	 * @param pid
	 */
	private static void kill(Node node, int pid){
		if(node.val == pid){
			node.enable = false;
		}else{
			for(int i=0; i<node.children.size(); i++){
				kill(node.children.get(i), pid);
			}
		}
	}
	
	/**
	 * find
	 * @param node
	 * @param pid
	 * @param deep actually not necessary
	 * @return
	 */
	private static int query(Node node, int pid, int deep){
		if(node.val == pid){
			return node.enable?deep:-1;
		}else{
			for(int i=0; i<node.children.size(); i++){
				Node n = node.children.get(i);
				int ret;
				if(n.enable && (ret=query(n, pid, deep+1))!=-1){
					return ret;
				}
			}
			return -1;
		}
	}
	
	/**
	 * add
	 * @param node
	 * @param p
	 * @param c
	 * @return
	 */
	private static Node fork(Node node, int p, int c){
		if(node.val == p){
			node.children.add(new Node(c));
		}else{
			for(int i=0; i<node.children.size(); i++){
				node.children.set(i, fork(node.children.get(i), p, c));
			}
		}
		return node;
	}
	
	/**
	 * add
	 * bfs
	 * @param node
	 * @param p
	 * @param c
	 * @return In Java, must return to modify original Node
	 */
	private static Node forkUsingQueue(Node node, int p, int c){
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		Node ptr;
		while(!q.isEmpty()){
			ptr = q.poll();
			if(ptr.val == p){
				ptr.children.add(new Node(c));
				break;
			}
			for(int i=0; i<ptr.children.size(); i++){
				q.add(ptr.children.get(i));
			}
		}
		return node;
	}

	public static void p(Object o) {
		System.out.println(o);
	}
}
