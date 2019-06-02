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
public class Jiudu1017 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useSc();
		System.exit(0);
	}
	
	static class Edge implements Comparable<Edge>{
		int a, b;
		int cost;
		
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
		public Edge(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + cost;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (cost != other.cost)
				return false;
			return true;
		}

		
	}
	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		int[] A = new int[100];
		Edge[] edges = new Edge[4950];
		while(sc.hasNext()){
			Arrays.fill(A, -1);
			int n = sc.nextInt();
			if(n == 0){
				break;
			}
			int edgeCnt = (n*n-n)/2;
			int ans = 0;
			for(int i=0; i<edgeCnt; i++){
				Edge edge = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
				edges[i] = edge;
			}
			Arrays.sort(edges, 0, edgeCnt);
			for (int i=0; i<edgeCnt; i++) {
				Edge edge = edges[i];
				int aR = find(A, edge.a);
				int bR = find(A, edge.b);
				if(aR != bR){
					A[aR] = bR;
					ans += edge.cost;
				}
			}
			p(ans);
		}
		sc.close();
	}

	private static int find(int[] a, int i) {
		if (a[i] < 0) {
			return i;
		} else {
			int tmp = find(a, a[i]);
			a[i] = tmp;
			return tmp;
		}
	}
	
	private static int find2(int[] a, int i) {
		int ret;
		int tmp=i;
		while(a[i] != -1){
			i = a[i];
		}
		ret = i;
		i = tmp;
		while(a[i]!=-1){
			int t = a[i];
			a[i] = ret;
			i = t;
		}
		return ret;
	}

	private static void union(int[] a, int x, int y) {
		int r1 = find2(a, x);
		int r2 = find2(a, y);
		if(r1 != r2){
			int cnt_2 = Math.abs(a[r2]);
			a[r2] = r1;
			a[r1] -= cnt_2;
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
