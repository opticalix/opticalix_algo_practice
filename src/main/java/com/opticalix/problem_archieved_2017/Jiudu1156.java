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
 * Hash，以书为key，可以快速链接两人
 * Input模板：
 * while(sc.hasNext()){
 * sc.nextInt();
 * sc.nextLine();
 * }
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1156 {

	private static Scanner scanner = new Scanner(System.in);
	// private static BufferedReader br = new BufferedReader(new
	// InputStreamReader(System.in));

	public static void main(String args[]) throws IOException {
		while (scanner.hasNext()) {
			 try {
				int n = scanner.nextInt();
				int m = scanner.nextInt();
				scanner.nextLine();
				int[] favorite = new int[n + 1];// save one's favorite. n->m
				int[][] r = new int[m + 1][n + 1];
				for (int i = 1; i <= n; i++) {
					int fa = scanner.nextInt();
					scanner.nextLine();
					favorite[i] = fa;
					r[fa][i] = 1;
				}
				for (int i = 1; i <= n; i++) {
					int cnt = 0;
					for (int j = 1; j <= n; j++) {
						cnt += r[favorite[i]][j];
					}
					if (cnt == 1) {
						p("BeiJu");
					} else {
						System.out.format("%d\n", --cnt);
					}
				}
			} catch (NumberFormatException e) {
			}
		}
		scanner.close();
		System.exit(0);
	}

	private static void acFunc() {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt(), m = in.nextInt();

			if (n < 2 || m < 2 || n > 200 || m > 200)
				break;

			int[] readers = new int[n], books = new int[m + 1];

			for (int i = 0; i < n; i++) {
				int temp = in.nextInt();
				if (temp > m || temp < 1)
					continue;
				readers[i] = temp;
				// point! the book has one more reader
				books[readers[i]]++;
			}

			for (int i = 0; i < n; i++) {
				// your favoriate book has only been read by yourself, poor!
				if (books[readers[i]] <= 1)
					System.out.println("BeiJu");
				else if ((books[readers[i]] > 1))
					System.out.println(books[readers[i]] - 1);
			}

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
