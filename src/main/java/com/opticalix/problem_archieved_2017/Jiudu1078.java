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
 * *** 前序+中序--后序
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1078 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useSc();
//		useBr();
		System.exit(0);
	}
	
	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[] read1 = sc.nextLine().toCharArray();//x dagfe
			char[] read2 = sc.nextLine().toCharArray();//adg x fe
			//递归build树
			TreeNode<Character> root = buildTree(read1, read2, 0, read1.length-1, 0, read2.length-1);
			TreeNode.postOrderTraversal(root);
		}
		sc.close();
	}
	private static TreeNode<Character> buildTree(char[] read1, char[] read2, int s1, int e1, int s2, int e2) {
		TreeNode<Character> node = new TreeNode<Character>();
		node.val = read1[s1];
		int rPosIn2=s2;
		
		//find root index in read2 char array
		for(int i=s2; i<=e2; i++){
			if(read2[i]==read1[s1]){
				rPosIn2 = i;
				break;
			}
		}
		if(rPosIn2>s2){//has left branch
			node.l = buildTree(read1, read2, s1+1, s1+(rPosIn2-s2), s2, rPosIn2-1);
		}
		if(rPosIn2<e2){
			node.r = buildTree(read1, read2, s1+(rPosIn2-s2)+1, e1, rPosIn2+1, e2);
		}
		return node;
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
	

    static class TreeNode<T> {
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
	
	public static <T> void postOrderTraversal(TreeNode<T> root){
		if(root.l != null){
			postOrderTraversal(root.l);
		}
		if(root.r != null){
			postOrderTraversal(root.r);
		}
		System.out.print(root.val);
	}
}

}
