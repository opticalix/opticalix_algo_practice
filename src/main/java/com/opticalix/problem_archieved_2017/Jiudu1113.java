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
 * *** 不用真的建树
 * 
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1113 {

	private static Scanner sc;
	private static BufferedReader br;
	private static LinkedList<Integer> queue;

	public static void main(String args[]) throws IOException {
		useSc();
		// useBr();
		System.exit(0);
	}

	private static void useSc() throws IOException {
		sc = new Scanner(System.in);
		queue = new LinkedList<Integer>();
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			if (m == 0 && n == 0)
				break;
			func3(m, n);
		}
		sc.close();
	}

	/**
	 * 逐层add to sum，注意边界处理
	 * @param m
	 * @param n
	 */
	private static void func3(int m, int n) {
		int sum=0, floorCnt=1, leftElement=m, rightElement=m;
		while(rightElement<=n){
			sum+=(floorCnt);
			floorCnt*=2;
			leftElement = leftElement*2;
			rightElement = rightElement*2+1;
		}
		if(n-leftElement > 0){
			sum+=(n-leftElement)+1;
		}
		p(sum);
	}

	/**
	 * time limit exceed
	 * @param m
	 * @param n
	 */
	private static void func2(int m, int n) {
		queue.clear();
		queue.offer(m);
		int sum=0;
		while(!queue.isEmpty()){
			int x = queue.poll();
			sum++;//queue poll, sum+1
			if(x*2<=n){
				queue.offer(x*2);
			}
			if(x*2+1<= n){
				queue.offer(x*2+1);
			}
		}
		p(sum);
	}

	/**
	 * time limit exceed
	 * @param m
	 * @param n
	 */
	private static void func1(int m, int n) {
		int sum = sumChildrenCnt(n, m);
		p(sum);
	}

	private static int sumChildrenCnt(int n, int m) {
		if (m > n) {
			return 0;
		} else {
			return 1 + sumChildrenCnt(n, m * 2) + sumChildrenCnt(n, m * 2 + 1);
		}
	}

	private static void useBr() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);

		}
		br.close();
	}

	public static void p(Object o) {
		System.out.println(o);
	}
}
