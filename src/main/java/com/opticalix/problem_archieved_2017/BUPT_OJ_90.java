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
 * **水题
 * ac
 * @author opticalix
 */
@SuppressWarnings("unused")
public class BUPT_OJ_90 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useSc();
		System.exit(0);
	}
	
	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		int eachChCnt[] = new int[26];
		while(t-- > 0){
			String line = sc.nextLine();
			
			//count each char
			Arrays.fill(eachChCnt, 0);
			for(int i=0; i<line.length(); i++){
				eachChCnt[line.charAt(i)-'a']++;
			}
			
			int ret=Integer.MAX_VALUE;
			for(int i=0; i<26; i++){
				if(eachChCnt[i]!=0){
					//line has that char
					//target ch='a'+i
					int cost=0;
					for(int j=0; j<line.length(); j++){
						int p = (line.charAt(j)-'a');
						int d = Math.abs(p-i);
						cost+=(d>(26-d)?(26-d):d);
					}
					if(cost<ret){
						ret=cost;
					}
				}
			}
			p(ret);
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
