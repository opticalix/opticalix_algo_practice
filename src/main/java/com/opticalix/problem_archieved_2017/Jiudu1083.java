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
public class Jiudu1083 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
//		useSc();
		useSc2();
//		useBr();
		System.exit(0);
	}
	
	/**
	 * use number decompose
	 */
	private static void useSc2() {
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			//read
			int ret=0;
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			sc.nextLine();
			
			//calc
			int factor1 = 1;
			for(int i=0; i<String.valueOf(n1).length(); i++){
				int p = (n1/factor1)%10;
				factor1*=10;
				int factor2 = 1;
				for(int j=0; j<String.valueOf(n2).length(); j++){
					ret += (p*((n2/factor2)%10));
					factor2*=10;
				}
			}
			p(ret);
		}
		sc.close();
	}

	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			String num1 = st.nextToken();
			String num2 = st.nextToken();
			int ret = 0;
			for(int i=0; i<num1.length(); i++){
				for(int j=0; j<num2.length(); j++){
					ret+=((num1.charAt(i)-'0')*(num2.charAt(j)-'0'));
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
