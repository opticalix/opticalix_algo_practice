package com.opticalix.lib;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

	public static void pArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + (j == arr[0].length - 1 ? "" : ",\t"));
			}
			System.out.println();
		}
	}

	public static void pArr(int[][][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				for (int k = 0; k < arr[0][0].length; k++) {
					System.out.print(arr[i][j][k] + ",\t");
				}
				System.out.println();
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

	public static void swap(int[] A, int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}

}
