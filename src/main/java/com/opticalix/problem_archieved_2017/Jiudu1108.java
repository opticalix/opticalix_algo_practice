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
public class Jiudu1108 {

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
			sc.nextLine();
			LinkedList<Integer> stack = new LinkedList<Integer>();
			while(n-- > 0){
				String line = sc.nextLine();
				if(line.startsWith("P")){
					StringTokenizer st = new StringTokenizer(line);
					st.nextToken();
					stack.push(Integer.valueOf(st.nextToken()));
				}else if(line.startsWith("O")){
					if(!stack.isEmpty()){
						stack.pop();
					}
				}else if(line.startsWith("A")){
					if(stack.isEmpty()){
						p("E");
					}else{
						p(""+stack.peek());
					}
				}
			}
			System.out.println();
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
