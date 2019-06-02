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
 * 题目1176：输出指定层所有节点
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1176 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useSc();
//		useBr();
		System.exit(0);
	}
	
	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		int[] A = new int[1001];
		while(sc.hasNext()){
			//read
			Arrays.fill(A, 0);
			int n = sc.nextInt();
			for(int i=1; i<=n; i++){
				A[i] = sc.nextInt();
			}
			//calc
			int level = sc.nextInt();
			int left = (int) Math.pow(2, level-1);
			int right = Math.min(n, (left<<1)-1);
			//handle EMPTY
			if(level<=0 || right<left){
				p("EMPTY");
				continue;
			}
			//print
			for(int i=left; i<=right; i++){
				if(i!=right){
					System.out.print(A[i]+" ");
				}else{
					System.out.print(A[i]);
				}
			}
			System.out.println();//another line!!
		}
		sc.close();
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
