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
 * 最短路径变种
 * 
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1008 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useSc();
		System.exit(0);
	}

	static class Edge implements Comparable<Edge> {
		int d;// length
		int p;// cost

		int v1;
		int v2;
		
		public Edge(int d, int p) {
			super();
			this.d = d;
			this.p = p;
		}
		

		public Edge(int d, int p, int v1, int v2) {
			super();
			this.d = d;
			this.p = p;
			this.v1 = v1;
			this.v2 = v2;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.d == o.d) {
				return this.p - o.p;
			}
			return this.d - o.d;
		}

		public Edge add(Edge e) {
			return new Edge(this.d + e.d, this.p + e.p);
		}

	}

	private static Edge edges[][] = new Edge[1001][1001];

	private static void useSc() throws IOException {
		sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (m == 0 && n == 0)
				break;
			fillArr(edges, null);
			while (m-- > 0) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				int d = sc.nextInt();
				int p = sc.nextInt();
				edges[i][j] = new Edge(d, p, i, j);
				edges[j][i] = new Edge(d, p, j, i);
			}
			Edge best = null;
			int s = sc.nextInt();
			int t = sc.nextInt();
			//floyd
//			Edge[][] A = floyd(edges, n);
//			best = A[s][t];
			
			//dijkstra
			best = dijkstra(n, s, t);
			
			p(best.d + " " + best.p);
		}
		sc.close();
	}

	/**
	 * ac, oom
	 * @param n
	 * @param s
	 * @param t
	 * @return
	 */
	private static Edge dijkstra(int n, int s, int t) {
		Set<Integer> collected = new HashSet<Integer>();
		collected.add(s);
		Edge[] shortEdges = new Edge[n+1];
		shortEdges[s] = new Edge(0, 0);
		for(int i=0; i<edges.length; i++){
			if(i==s || edges[s][i]==null) continue;
			shortEdges[i] = edges[s][i];
		}
		
		while(collected.size()<n){
			Edge se = findShortestFromCollected(collected);
			if(se == null) break;
			
			collected.add(se.v2);
			//check and update
			for(int i=0; i<edges.length; i++){
				Edge e = edges[se.v2][i];
				if(e == null || collected.contains(e.v2)) continue;
				if(shortEdges[e.v2]==null || shortEdges[e.v2].compareTo(shortEdges[se.v2].add(e)) > 0){
					shortEdges[e.v2] = shortEdges[se.v2].add(e);
				}
			}
		}
		return shortEdges[t];
	}

	private static Edge findShortestFromCollected(Collection<Integer> collected) {
		Edge ret = null;
		Iterator<Integer> iterator = collected.iterator();
		while(iterator.hasNext()){
			Integer next = iterator.next();
			for(int j=0; j<edges.length; j++){
				Edge edge = edges[next][j];
				if(edge == null || collected.contains(edge.v2)) continue;
				if(ret == null){
					ret = edge;
				}else{
					if(edge.compareTo(ret) < 0){
						ret = edge;
					}
				}
			}
		}
		return ret;
	}

	private static void fillArr(Edge[][] edges, Edge v) {
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[0].length; j++) {
				edges[i][j] = v;
			}
		}
	}

	/**
	 * TLE
	 * @param edges
	 * @param n
	 * @return
	 */
	private static Edge[][] floyd(Edge[][] edges, int n) {
		//initial
		Edge[][] A = new Edge[n + 1][n + 1];
		fillArr(A, null);
		for (int i = 1; i < A.length; i++) {
			for (int j = 1; j < A.length; j++) {
				A[i][j] = edges[i][j];
			}
		}
		
		//try and update
		for (int k = 1; k < A.length; k++) {
			for (int i = 1; i < A.length; i++) {
				for (int j = 1; j < A.length; j++) {
					if (i != k && j != k && A[k][j] != null && A[i][k] != null) {
						if (A[i][j] == null || A[i][j].compareTo(A[i][k].add(A[k][j])) > 0) {//!!如果i-j间原先无路 现在有路 则直接修改
							A[i][j] = A[i][k].add(A[k][j]);
						}
					}
				}
			}
		}
		return A;
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
