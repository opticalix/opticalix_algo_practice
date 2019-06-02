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
 * *
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1098 {
	
	private static Scanner scanner;

	public static void main(String args[]) throws IOException{
		scanner = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		fun(br);
		scanner.close();
		System.exit(0);
	}

	private static void fun(BufferedReader br) {
		int[] cnt = new int[26];//default fill with 0
		try {
			String line;
			while((line=br.readLine()) != null){
				Arrays.fill(cnt, 0);
				char[] charArray = line.toCharArray();
				for (int i = 0; i < charArray.length; i++) {
					if(charArray[i]>='A' && charArray[i]<='Z'){
						cnt[charArray[i]-'A']++;
					}
				}
				for(int i=0; i<26; i++){
					p(String.format("%c:%d", 'A'+i, cnt[i]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
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
