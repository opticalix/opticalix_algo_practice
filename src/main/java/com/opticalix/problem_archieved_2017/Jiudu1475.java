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
 * IP头+Tcp头，IP头在外
 * 包头部分长度可变!
 * ***
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1475 {
	
	private static Scanner scanner;

	public static void main(String args[]) throws IOException{
		scanner = new Scanner(System.in);
		Integer n = Integer.valueOf(scanner.nextLine());
		int cnt = 0;
		while(n-- > 0){
			String line = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(line);
			String[] split = line.split(" ");
			int ihl = hexToDec(split[0].charAt(1))*4;
			int len = hexToDec(split[2]+split[3]);
			p(String.format("Case #%d", ++cnt));
			p(String.format("Total length = %d bytes", len));
			p(String.format("Source = %d.%d.%d.%d", hexToDec(split[12]),hexToDec(split[13]),hexToDec(split[14]),hexToDec(split[15])));
			p(String.format("Destination = %d.%d.%d.%d", hexToDec(split[16]),hexToDec(split[17]),hexToDec(split[18]),hexToDec(split[19])));
			p(String.format("Source Port = %d", hexToDec(split[ihl]+split[ihl+1])));
			p(String.format("Destination Port = %d", hexToDec(split[ihl+2]+split[ihl+3])));
			System.out.println();
		}
		scanner.close();
		System.exit(0);
	}
	
	private static int hexToDec(char ch){
		return hexToDec(""+ch);
	}
	
	private static int hexToDec(String s){
		final int HEX_FACTOR = 16;
		char[] charArray = s.toCharArray();
		int factor = 1;
		int ret = 0;
		for(int i=charArray.length-1; i>=0; i--,factor*=HEX_FACTOR){
			char ch = charArray[i];
			int chInt;
			if(ch>='a'){
				chInt = 10+(ch-'a');
			}else{
				chInt = ch-'0';
			}
			ret += chInt*factor;
		}
		return ret;
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
