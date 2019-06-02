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
 * *** 数学技巧
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1163 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useSc();
//		useBr();
		System.exit(0);
	}
	
	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		int[] A = new int[10000];
		screenPrime(A);
		while(sc.hasNext()){
			int n = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			for(int i=2; i<n; i++){
				if(A[i]==0 && i%10==1){
					sb.append(i+" ");
				}
			}
			String trim = trim(sb);
			if(trim.equals("")){
				p(-1);
			}else{
				p(trim);
			}
		}
		sc.close();
	}
	
	private static String trim(StringBuilder sb) {
		if(sb!=null && sb.length()>0){
			String substring = sb.substring(0, sb.length()-1);
			return substring;
		}
		return "";
	}

	/**
	 * find prime
	 * @param a
	 */
	private static void screenPrime(int[] a) {
		for(int i=2; i<a.length; i++){
			if(isPrime(i)){
				int tmp = i*i;//start from i*i
				while(tmp<a.length){
					a[tmp]=1;//set flag
					tmp+=i;
				}
			}
		}
	}
	
	private static boolean isPrime(int n){
		//only consider positive
		if(n<=1){
			return false;
		}
		int sqrt = (int) Math.sqrt(n);
		for(int i=2; i<=sqrt; i++){
			int j = n/i;
			if(i*j == n){
				return false;
			}
		}
		return true;
	}

	private static void useBr() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=br.readLine()) != null){
			StringTokenizer st = new StringTokenizer(line);
			
		}
		br.close();
	}

	public static void p(Object o) {
		System.out.println(o);
	}
}
