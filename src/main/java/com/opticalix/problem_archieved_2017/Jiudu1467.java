package com.opticalix.problem_archieved_2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
 * ※ 大水题
 * ※※ 小水题
 * ※※※ 稍难 数据结构&数学技巧
 * ※※※※ 复杂数据结构&贪心&动归
 * ※※※※※ 无法AC
 */

/**
 * ***
 * 注意 2^26 < 10^8 < 2^27
 * @author opticalix
 */
public class Jiudu1467 {

	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try {
				Integer n = Integer.valueOf(br.readLine());
				StringTokenizer st = new StringTokenizer(br.readLine());
				SortedTree tree = null;
				while(st.hasMoreTokens()){
					Integer x = Integer.valueOf(st.nextToken());
					if(tree == null){
						tree = SortedTree.create(x);
						p("-1");
					}else{
						Node last = tree.add(new Node(x));
						p(""+last.val);
					}
				}
			} catch (Exception e){
				break;
			}
		}
		System.exit(0);
	}
	static class SortedTree{
		Node rootNode;
		public SortedTree(int root){
			rootNode = new Node(root);
		}
		
		public static SortedTree create(int root){
			return new SortedTree(root);
		}
		
		public Node add(Node node){
			if(rootNode==null){
				throw new RuntimeException("no root ret");
			}
			Node p = rootNode;
			Node last = null;
			boolean turnLeft = false;
			while(p!=null){
				last = p;
				if(p.val>node.val){
					p = p.l;
					turnLeft = true;
				}else{
					p = p.r;
					turnLeft = false;
				}
			}
			if(turnLeft){
				last.l = node;
			}else{
				last.r = node;
			}
			return last;
		}
	}
	static class Node{
		int val;
		Node l;
		Node r;
		
		public Node(int val) {
			super();
			this.val = val;
		}
		
	}

	public static void p(Object o) {
		System.out.println(o);
	}

	public static void pArr(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void pArr(String[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void pArr(Object[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static <T> void pList(ArrayList<T> list, T[] t) {
		list.toArray(t);
		pArr(t);
	}
	
	public static void swap(char[] chArr, int a, int b) {
		char tmp = chArr[a];
		chArr[a] = chArr[b];
		chArr[b] = tmp;
	}

}
