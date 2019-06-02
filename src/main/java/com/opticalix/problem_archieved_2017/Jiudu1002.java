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
 * 
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1002 {
	

	private static BufferedReader br;

	public static void main(String args[]) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int P, T, g1,g2,g3,gj;
		String line;
		while((line=br.readLine())!=null){
			StringTokenizer st = new StringTokenizer(line);
			P = Integer.valueOf(st.nextToken());
			T = Integer.valueOf(st.nextToken());
			g1 = Integer.valueOf(st.nextToken());
			g2 = Integer.valueOf(st.nextToken());
			g3 = Integer.valueOf(st.nextToken());
			gj = Integer.valueOf(st.nextToken());
			if(Math.abs(g1-g2) <= T){
				p(String.format("%.1f", (g1+g2)/2f));
			}else{
				int t13 = Math.abs(g1-g3);
				int t23 = Math.abs(g2-g3);
				if(t13<=T && t23<=T){
					p(String.format("%.1f", (float)Math.max(Math.max(g1, g2), g3)));
				}else if(t13<=T || t23<=T){
					if(t13 < t23){
						p(String.format("%.1f", (g1+g3)/2f));
					}else{
						p(String.format("%.1f", (g2+g3)/2f));
					}
				}else{
					p(String.format("%.1f", (float)gj));
				}
			}
		}
		br.close();
		System.exit(0);
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
