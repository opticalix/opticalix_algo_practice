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
 * **
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1473 {
	
	private static Scanner scanner;

	public static void main(String args[]) throws IOException{
		scanner = new Scanner(System.in);
		int n = Integer.valueOf(scanner.nextLine());
		char[] result = new char[28];
		while(n-->0){
			int x = Integer.valueOf(scanner.nextLine());
			if(x==0){
				p("0");
				continue;
			}
			for(int i=27; i>=0; i--){
				int pow = (int) Math.pow(2,i);
				if(x/pow==1){
					result[i]='1';
					x-=pow;
				}else{
					result[i]='0';
				}
			}
			
			//print
			boolean zeroPrefix = true;
			for(int i=27; i>=0; i--){
				if(zeroPrefix&&result[i]=='0'){
					continue;
				}else{
					zeroPrefix = false;
					System.out.print(result[i]);
				}
			}
			System.out.println();
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
