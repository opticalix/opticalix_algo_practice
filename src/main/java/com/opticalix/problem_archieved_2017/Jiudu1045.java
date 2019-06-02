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
 * ※※
 * @author opticalix
 *
 */
@SuppressWarnings("unused")
public class Jiudu1045 {
	
	private static Scanner scanner;

	public static void main(String args[]) throws IOException{
		scanner = new Scanner(System.in);
		chickenQuestion();
		scanner.close();
		System.exit(0);
	}

	/**
	 * http://ac.jobdu.com/problem.php?pid=1045 x+y+z=100 5x+3y+(1/3)z<=n
	 * 5 3 1/3
	 */
	public static void chickenQuestion() {
		while(scanner.hasNextInt()){
			int n = scanner.nextInt();
			int x, y;
			for (x = 0; x <= n / 5; x++) {
				for (y = 0; y <= n / 3; y++) {
					int z = 100 - x - y;
					if (x + y + z == 100 && (5 * x + 3 * y + z / 3f) <= n) {
						p("x="+x + ",y=" + y + ",z=" + z);
					}
				}
			}
		}
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
