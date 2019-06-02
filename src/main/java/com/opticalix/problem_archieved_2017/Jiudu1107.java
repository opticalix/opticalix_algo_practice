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
public class Jiudu1107 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useSc();
//		useBr();
		System.exit(0);
	}
	
	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			if(n==0) break;
			PriorityQueue<Integer> priorityQ = new PriorityQueue<Integer>();
			while(n-- > 0){
				priorityQ.add(sc.nextInt());
			}
			int result=0;
			while(priorityQ.size()!=1){
				int sum = priorityQ.poll()+priorityQ.poll();
				priorityQ.add(sum);
				result+=sum;
			}
			p(result);
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
