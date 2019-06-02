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
 * **
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1431 {

	private static Scanner scanner;
	private static BufferedReader br;
	private static volatile int flag;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		scanner = new Scanner(System.in);
		String line;
		int[] A = new int[1000001];//-500000--0 0--500000 500000--1000000
		while((line=br.readLine())!=null){
			Arrays.fill(A, 0);
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.valueOf(st.nextToken());
			int m = Integer.valueOf(st.nextToken());
			final int offset = 500000;
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			while(n-- > 0){
				int x = Integer.valueOf(st2.nextToken());
				A[x+offset]++;
			}
			int j=A.length-1;
			while(true){
				if(A[j] != 0){
					System.out.print((j-offset) + (m==1?"":" "));
					if(--m == 0){
						break;
					}
				}
				j--;
			}
			System.out.println();
		}
		scanner.close();
		br.close();
		System.exit(0);
	}

}
