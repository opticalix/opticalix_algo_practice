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
 * ** 矩阵加减法并统计
 * 
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1001 {
	
	private static Scanner scanner;

	public static void main(String args[]) throws IOException{
		scanner = new Scanner(System.in);
		//read into 2-D array
		//add matrix
		//count
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line=br.readLine())!=null){
			StringTokenizer st = new StringTokenizer(line);
			if(1 == st.countTokens() && st.nextToken().equals("0")){
				//end
				break;
			}else{
				int m=Integer.valueOf(st.nextToken());
				int n=Integer.valueOf(st.nextToken());
				int[][] A = new int[m][n];
				int[][] B = new int[m][n];
				int[][] result = new int[m][n];;
				read(m, n, A, br);
				read(m, n, B, br);
				calc(A, B, result);
				
				p(countZeroRowNum(result)+countZeroColNum(result));
			}
		}
		
		scanner.close();
		System.exit(0);
	}

	private static int countZeroRowNum(int[][] result) {
		int zeroRowCnt = 0;
		int rowLen = result.length;
		int colLen = result[0].length;
		for (int i = 0; i < rowLen; i++) {
			int zeroCnt = 0;
			for (int j = 0; j < colLen; j++) {
				if(result[i][j] == 0){
					zeroCnt += 1;
				}else{
					break;
				}
			}
			if(zeroCnt == colLen){
				zeroRowCnt++;
			}
		}
		return zeroRowCnt;
	}
	private static int countZeroColNum(int[][] result) {
		int zeroColCnt = 0;
		int rowLen = result.length;
		int colLen = result[0].length;
		for (int i = 0; i < colLen; i++) {
			int zeroCnt = 0;
			for (int j = 0; j < rowLen; j++) {
				if(result[j][i] == 0){
					zeroCnt += 1;
				}else{
					break;
				}
			}
			if(zeroCnt == rowLen){
				zeroColCnt++;
			}
		}
		return zeroColCnt;
	}

	private static void calc(int[][] a, int[][] b, int[][] result) {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = a[i][j]+b[i][j];
			}
		}
	}

	private static void read(int m, int n, int[][] A) {
		//read
		for(int i=0; i<m; i++){
			StringTokenizer st2 = new StringTokenizer(scanner.nextLine());
			for(int j=0; j<n; j++){
				A[i][j] = Integer.valueOf(st2.nextToken());
			}
		}
	}
	private static void read(int m, int n, int[][] A, BufferedReader br) throws IOException {
		//read
		for(int i=0; i<m; i++){
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				A[i][j] = Integer.valueOf(st2.nextToken());
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
