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
 * 
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1444 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useSc();
		System.exit(0);
	}

	private static void useSc() throws IOException {
		sc = new Scanner(System.in);
		int[] A = new int[10000001];
		while (sc.hasNext()) {
			Arrays.fill(A, -1);
			A[0] = 0;
			int n = sc.nextInt();
			while (n-- > 0) {
				union(A, sc.nextInt(), sc.nextInt());
			}
			
			for(int i=1; i<A.length; i++){
				if(A[i]<A[0]&& A[i]<0){
					A[0]=A[i];
				}
			}
			p(Math.abs(A[0]));
		}
		sc.close();
	}

	private static int find(int[] a, int i) {
		if (a[i] < 0) {
			return i;
		} else {
			int tmp = find(a, a[i]);
			a[i] = tmp;
			return tmp;
		}
	}
	
	private static int find2(int[] a, int i) {
		int ret;
		int tmp=i;
		while(a[i] != -1){
			i = a[i];
		}
		ret = i;
		i = tmp;
		while(a[i]!=-1){
			int t = a[i];
			a[i] = ret;
			i = t;
		}
		return ret;
	}

	private static void union(int[] a, int x, int y) {
		int r1 = find2(a, x);
		int r2 = find2(a, y);
		if(r1 != r2){
			int cnt_2 = Math.abs(a[r2]);
			a[r2] = r1;
			a[r1] -= cnt_2;
		}
	}

	private static void useBr() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);

		}
		br.close();
	}

	public static void p(Object o) {
		System.out.println(o);
	}
}
