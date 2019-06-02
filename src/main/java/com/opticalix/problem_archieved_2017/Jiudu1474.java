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
 * ***
 * 矩阵相乘: 三重循环能搞定
 * http://www.mamicode.com/info-detail-673908.html
 * 1h
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1474 {

	private static Scanner scanner;

	public static void main(String args[]) throws IOException {
		scanner = new Scanner(System.in);
		Integer n = Integer.valueOf(scanner.nextLine());
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(scanner.nextLine());
			int N = Integer.valueOf(st.nextToken());
			int K = Integer.valueOf(st.nextToken());
			int[][] matrix = readMatrix(N);
			int[][] result = matrix;// check
			for (int i = 1; i < K; i++) {
				result = matrixProduct2(matrix, result);
			}
			printMatrix(result);
		}
		scanner.close();
		System.exit(0);
	}

	private static void printMatrix(int[][] result) {
		int n = result[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + (j == n - 1 ? "" : " "));
			}
			System.out.println();
		}
	}

	private static int[][] readMatrix(int n) {
		int[][] ret = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(scanner.nextLine());
			for (int j = 0; j < n; j++) {
				ret[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		return ret;
	}

	public static int[][] matrixProduct2(int a[][], int b[][]) {
		int n = a[0].length;
		int[][] ret = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum=0;
				for (int k = 0; k < n; k++) {
					sum += a[i][k] * b[k][j];
				}
				ret[i][j] = sum;
			}
		}
		return ret;
	}
	
	public static int[][] matrixProduct(int a[][], int b[][]) {
		int n = a[0].length;
		int[][] ret = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ret[i][j] = simpleProduct(row(a, i), col(b, j));
			}
		}
		return ret;
	}

	private static int simpleProduct(int[] row, int[] col) {
		int ret = 0;
		for (int i = 0; i < row.length; i++) {
			ret += row[i] * col[i];
		}
		return ret;
	}

	private static int[] row(int[][] a, int pos) {
		// return a[pos];
		int[] ret = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			ret[i] = a[pos][i];
		}
		return ret;
	}

	private static int[] col(int[][] a, int pos) {
		int[] ret = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			ret[i] = a[i][pos];
		}
		return ret;
	}

	public static void p(Object o) {
		System.out.println(o);
	}
}
