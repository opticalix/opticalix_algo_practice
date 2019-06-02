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
 * 书上说二分..
 * **
 * 1632-35
 * 35-50
 * 
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1126 {

	private static Scanner scanner;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
//		useSc();
		useBr();
	}
	
	private static void useSc() throws IOException{
		scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int A[] = new int[80];
		while(n-- > 0){
			//read
			Arrays.fill(A, 0);
			int k = scanner.nextInt();
			for(int i=0; i<k; i++){
				A[i] = scanner.nextInt();
			}
			
			//analysis
			boolean empty = true;
			for(int i=0; i<k; i++){
				if(i==0){
					if(A[i]!=A[i+1]){
						if(empty){
							System.out.print(""+i);
							empty = false;
						}else{
							System.out.print(" "+i);
						}
					}
				}else if(i==k-1){
					if(A[i]!=A[i-1]){
						if(empty){
							System.out.print(""+i);
							empty = false;
						}else{
							System.out.print(" "+i);
						}
					}
				}else{
					if((A[i-1]>A[i] && A[i+1]>A[i]) ||
							(A[i-1]<A[i] && A[i+1]<A[i])){
						if(empty){
							System.out.print(""+i);
							empty = false;
						}else{
							System.out.print(" "+i);
						}
					}
				}
			}
			System.out.println();
		}
		scanner.close();
	}
	private static void useBr() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		String A[] = new String[80];
		while(n-- > 0){
			//read
			Arrays.fill(A, null);
			int k = Integer.valueOf(br.readLine());
			String[] split = br.readLine().split(" ");
//			for(int i=0; i<k; i++){
//				A[i] = Integer.valueOf(st.nextToken());
//			}
			System.arraycopy(split, 0, A, 0, split.length);
			
			//analysis
			boolean empty = true;
			for(int i=0; i<k; i++){
				if(i==0){
					if(Integer.valueOf(A[i])!=Integer.valueOf(A[i+1])){
						if(empty){
							System.out.print(""+i);
							empty = false;
						}else{
							System.out.print(" "+i);
						}
					}
				}else if(i==k-1){
					if(Integer.valueOf(A[i])!=Integer.valueOf(A[i-1])){
						if(empty){
							System.out.print(""+i);
							empty = false;
						}else{
							System.out.print(" "+i);
						}
					}
				}else{
					if((Integer.valueOf(A[i-1])>Integer.valueOf(A[i]) && Integer.valueOf(A[i+1])>Integer.valueOf(A[i])) ||
							(Integer.valueOf(A[i-1])<Integer.valueOf(A[i]) && Integer.valueOf(A[i+1])<Integer.valueOf(A[i]))){
						if(empty){
							System.out.print(""+i);
							empty = false;
						}else{
							System.out.print(" "+i);
						}
					}
				}
			}
			System.out.println();
		}
		br.close();
	}

	public static void p(Object o) {
		System.out.println(o);
	}

}
