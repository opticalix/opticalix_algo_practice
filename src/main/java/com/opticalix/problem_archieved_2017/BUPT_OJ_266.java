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
 * * 一点小技巧 记得化成最简真分式
 * @author opticalix
 */
@SuppressWarnings("unused")
public class BUPT_OJ_266 {
	
	private static Scanner scanner;

	public static void main(String args[]) throws IOException{
		scanner = new Scanner(System.in);
		Integer t = Integer.valueOf(scanner.nextLine());
		while(t-- > 0){
			StringTokenizer st = new StringTokenizer(scanner.nextLine());
			Integer a = Integer.valueOf(st.nextToken());
			Integer b = Integer.valueOf(st.nextToken());
			int max = a>b?a:b;
			int min = a>b?b:a;
			int numerator = (int) Math.pow(2, max-min)+1;
			int dominator = (int) Math.pow(2, max);
			
			//simplest form
			while(numerator%2==0 && dominator%2==0){
				numerator/=2;
				dominator/=2;
			}
			p(numerator+"/"+dominator);
		}
		scanner.close();
		System.exit(0);
	}

	public static void swap(char[] chArr, int a, int b) {
		char tmp = chArr[a];
		chArr[a] = chArr[b];
		chArr[b] = tmp;
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
}
