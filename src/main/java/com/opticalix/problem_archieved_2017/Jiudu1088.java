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
 * 应该用线段树、树形数组
 * 1620-1638 >1000ms
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1088 {

	private static Scanner scanner;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useSc();
//		useBr();
		System.exit(0);
	}
	
	private static void useSc() throws IOException{
		scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int l = scanner.nextInt();
			int m = scanner.nextInt();
			int[] A = new int[l+1];
			while(m-- > 0){
				int s = scanner.nextInt();
				int e = scanner.nextInt();
				for(int i=s; i<=e; i++){
					A[i] = 1;
				}
			}
			int cnt = 0;
			for(int i=0; i<l+1; i++){
				if(A[i]==0){
					cnt++;
				}
			}
			p(cnt);
		}
		scanner.close();
	}
	private static void useBr() throws IOException {
		new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=br.readLine()) != null){
			StringTokenizer st = new StringTokenizer(line);
			
		}
		br.close();
	}
	
	static class Group{
		int start;
		int end;
		
		public Group(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		public int removeCount(){
			return end - start +1;
		}
		
		public Group retain(Group g){
			if(!(g.start>end || g.end<start)){
				return new Group(Math.max(g.start, start), Math.max(g.end, end));
			}else{
				return null;
			}
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
