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
 * max, sec_max
 * 1. 可以利用三个变量记录
 * 2. 可以利用Arrays.sort
 * @author opticalix
 */
@SuppressWarnings("unused")
public class BUPT_OJ_88 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
//		useSc();
		useSc2();
//		useBr();
		System.exit(0);
	}
	
	private static void useSc2() {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] A = new int[1000];
		while(T-- > 0){
			int n = sc.nextInt();
			int max, sec_max;
			for(int i=0; i<n; i++){
				A[i] = sc.nextInt();
			}
			Arrays.sort(A, 0, n);
			sec_max = max = A[n-1];
			for(int i=n-1; i>=0; i--){//find second
				if(sec_max!=A[i]){
					sec_max = A[i];
					break;
				}
			}
			p(max+" "+sec_max);
		}
		sc.close();
	}

	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			int n = sc.nextInt();
			int max, sec_max=Integer.MIN_VALUE, bak_sec_max=Integer.MIN_VALUE;
			max = sc.nextInt();
			n--;
			while(n-- > 0){
				int x = sc.nextInt();
				if(max < x){
					sec_max = max;
					max = x;
				}
				if(bak_sec_max < x){
					bak_sec_max = x;
				}
			}
			if(sec_max==Integer.MIN_VALUE){
				//first one is max..
				sec_max = bak_sec_max;
			}
			p(max+" "+sec_max);
		}
		sc.close();
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
