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
public class BUPT_OJ_89 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useSc();
		System.exit(0);
	}
	
	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		int t = Integer.valueOf(sc.nextLine());
		int first[] = new int[2];
		int second[] = new int[2];
		while(t-- > 0){
			//read
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " :\n\r\t");
			first[0] = Integer.valueOf(st.nextToken());
			first[1] = Integer.valueOf(st.nextToken());
			StringTokenizer st2 = new StringTokenizer(sc.nextLine(), " :\n\r\t");
			second[0] = Integer.valueOf(st2.nextToken());
			second[1] = Integer.valueOf(st2.nextToken());
			
			//calc
			int diff=0;
			//if 1st > 2nd
			if(second[0]<first[0] || second[0]==first[0]&&second[1]<first[1]){
				while(first[0]>second[0]){
					first[0]--;
					diff+=60;
				}
				diff+=(first[1]-second[1]);
				diff=24*60-diff;
			}else{
				while(second[0]>first[0]){
					second[0]--;
					diff+=60;
				}
				diff+=(second[1]-first[1]);
			}
			p(diff);
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
