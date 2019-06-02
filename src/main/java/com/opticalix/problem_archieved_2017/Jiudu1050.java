package com.opticalix.problem_archieved_2017;

import java.util.*;
import java.io.*;

/**
 * ※ 大水题
 * ※※ 小水题
 * ※※※ 稍难 数据结构&数学技巧
 * ※※※※ 复杂数据结构&贪心&动归
 * ※※※※※ 无法AC
 * 
 * ※※水题
 * 注意，各个小于它的约数（真约数,列出某数的约数，去掉该数本身，剩下的就是它的真约数）的和等于它本身的自然数叫做完全数（Perfect number）
 * @author opticalix
 *
 */
@SuppressWarnings("unused")
public class Jiudu1050 {
	
	private static Scanner scanner;

	public static void main(String args[]) throws IOException{
		scanner = new Scanner(System.in);
		
		//read n
		while(scanner.hasNextInt()){
			int n = scanner.nextInt();
			StringBuilder sb = new StringBuilder();
			for(int i=1; i<=n; i++){
				if(isPerfectNum(i)){
					sb.append(i+" ");
				}
			}
			if(sb.length()>0){
				System.out.println(sb.substring(0, sb.length()-1));
			}
		}
		scanner.close();
		System.exit(0);
	}

	/**
	 * judge n is a Perfect Number or not
	 * @param n
	 * @return
	 */
	private static boolean isPerfectNum(int n) {
		boolean factors[] = new boolean[n];//except itself
		for(int i=1; i<=Math.ceil(Math.sqrt(n)); i++){
			int j = n/i;
			if(i*j==n){
				factors[i-1]=true;
				factors[j-1]=true;
			}
		}
		int sum=0;
		for(int i=0; i<n-1; i++){
			if(factors[i]){
				sum+=(i+1);
			}
		}
		return sum==n;
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
