package com.opticalix.problem_archieved_2017;

import java.util.*;

import com.opticalix.lib.DisjointSet;

import java.io.*;

@SuppressWarnings("unused")
public class Jiudu1012 {
	
	private static Scanner scanner;

	public static void main(String args[]) throws IOException{
		scanner = new Scanner(System.in);
		p1012();
		scanner.close();
		System.exit(0);
	}
	
	private static void p1012() throws IOException {
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.valueOf(st.nextToken());//no such token
			if(n == 0)
				break;
			DisjointSet ds = new DisjointSet(n);
			int m = Integer.valueOf(st.nextToken());
			while(m-->0){
				StringTokenizer innerSt = new StringTokenizer(scanner.nextLine());
				ds.union(Integer.valueOf(innerSt.nextToken())-1, Integer.valueOf(innerSt.nextToken())-1);
			}
			p(ds.getGroupCnt()-1);
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
