package com.opticalix.problem_archieved_2017;

import java.util.*;

import com.opticalix.lib.Utils;
import com.opticalix.problem.BasicDS;

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
public class Jiudu1173 {

	private static Scanner scanner;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		test();
//		useSc();
//		useBr();
		System.exit(0);
	}
	
	private static void useSc() throws IOException{
		scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			//read
			int n = scanner.nextInt();
			int A[] = new int[n];
			for (int i = 0; i < A.length; i++) {
				A[i] = scanner.nextInt();
			}
			

			//sort+search n*logn+m*logn
			Arrays.sort(A);
			int m = scanner.nextInt();
			for (int i = 0; i < m; i++) {
				if(-1 != binSearch(A, scanner.nextInt())){
					p("YES");
				}else{
					p("NO");
				}
			}
			
			
		}
		scanner.close();
	}
	
	private static void test(){
		int[] a = new int[]{1,5,2,4,3};
//		int[] a = new int[]{43,1,43,53,645,2,34,23,4,57,568,769,879,78,54,63,52,23};
		sort(a);
		Utils.pArr(a);
		p(binSearch(a, 5));
	}
	
	private static int binSearch(int[] a, int target) {
		return BasicDS.binSearch(a, 0, a.length-1, target);
	}

	/**
	 * FIXME
	 * @param a
	 */
	private static void sort(int[] a) {
		BasicDS.qSort(a, 0, a.length-1);
//		Arrays.sort(a);
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
