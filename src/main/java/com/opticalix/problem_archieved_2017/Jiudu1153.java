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
public class Jiudu1153 {

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
			String line = scanner.nextLine();
			LinkedList<Wrapper> stack = new LinkedList<Wrapper>();
			for(int i=0; i<line.length(); i++){
				if(line.charAt(i)=='('){
					stack.push(new Wrapper('(', i));
				}else if(line.charAt(i)==')'){
					if(!stack.isEmpty() && stack.peek().c=='('){
						stack.pop();
					}else{
						stack.push(new Wrapper(')', i));
					}
				}
				System.out.print(line.charAt(i));
			}
			System.out.println();
			char[] ans = new char[line.length()];
			while(!stack.isEmpty()){
				Wrapper w = stack.pop();
				ans[w.pos] = w.c=='('?'$':'?';
			}
			for(int i=0; i<line.length(); i++){
				if(ans[i] == 0){//default char[] filled with 0??
					System.out.print(" ");
				}else{
					System.out.print(ans[i]);
				}
			}
			System.out.println();
		}
		scanner.close();
	}
	
	static class Wrapper{
		char c;
		int pos;
		public Wrapper(char c, int pos) {
			super();
			this.c = c;
			this.pos = pos;
		}
		
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
