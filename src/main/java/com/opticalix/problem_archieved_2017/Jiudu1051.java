package com.opticalix.problem_archieved_2017;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

/**
 * ※ 大水题
 * ※※ 小水题
 * ※※※ 稍难 数据结构&数学技巧
 * ※※※※ 复杂数据结构&贪心&动归
 * ※※※※※ 无法AC
 * @author opticalix
 *
 * ※※※  数字阶梯求和
 * 用BigInteger 或者自己模拟
 */
@SuppressWarnings("unused")
public class Jiudu1051 {
	
	private static Scanner scanner;

	public static void main(String args[]) throws IOException{
		scanner = new Scanner(System.in);
		int[] sum = new int[]{9,0,0};
		addArray(new int[]{9,9}, sum, 1);
		while(scanner.hasNextLine()){
			func2();
		}
		scanner.close();
		System.exit(0);
	}
	
	/**
	 * 用数组保存。 0为低位
	 */
	private static void func2(){
		StringTokenizer st = new StringTokenizer(scanner.nextLine());
		int i_a = Integer.valueOf(st.nextToken());
		int i_n = Integer.valueOf(st.nextToken());
		int sum[] = new int[i_n+1];
		int a[] = new int[i_n];
		if(i_a==0 || i_n==0){
			p(""+0);
			return;
		}
		a[0] = i_a;
		sum[0] = i_a;
		for(int i=1; i<i_n; i++){
			a[i] = a[i-1];//expand
			addArray(a, sum, i);//update sum
		}
		//print
		for(int i=i_n-1,flag=0; i>=0; i--){
			if(sum[i]==0&&flag==0){
				continue;
			}
			flag=1;
			System.out.print(""+sum[i]);
		}
		System.out.println();
	}

	private static void addArray(int[] a, int[] sum, int pos) {
		int carry=0;int i=0;
		for(i=0; i<=pos; i++){
			int simpleSum = sum[i]+a[i]+carry;
			carry=simpleSum/10;
			sum[i]=simpleSum%10;
		}
		sum[pos+1]=carry!=0?carry:0;
	}

	private static void func1() {
		StringTokenizer st = new StringTokenizer(scanner.nextLine());
		int a = Integer.valueOf(st.nextToken());
		int n = Integer.valueOf(st.nextToken());
		BigInteger sum=new BigInteger("0");
		BigInteger aa=new BigInteger(String.valueOf(a));
		for(int i=1; i<=n; i++){
			sum=sum.add(aa);
			aa = aa.multiply(new BigInteger("10")).add(new BigInteger(String.valueOf(a)));
		}
		p(sum.toString());
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
