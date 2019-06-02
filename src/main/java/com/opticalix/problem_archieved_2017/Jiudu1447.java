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
 *  最短路径
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1447 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useSc();
		System.exit(0);
	}

	static int edges[][] = new int[101][101];
	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			fillArr(edges, Integer.MAX_VALUE);
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(m==0 && n==0) break;
			buildGraph(n, m, edges);
			
			//calc
//			int[][] result = floyd(edges, n);
//			p(result[1][n]);
			
			//dijkstra
			dijkstra(1, n);
		}
		sc.close();
	}
	
	/*
	 * edges.len=n+1
	 * s=from
	 * t=to
	 */
	private static void dijkstra(int f, int t) {
		//initial
		boolean[] mark = new boolean[edges.length];//collected v
		int[] dist = new int[edges.length];//distance from s to t
		for(int i=0; i<edges.length; i++){
			mark[i] = false;
			dist[i] = Integer.MAX_VALUE;
		}
		mark[f] = true;
		dist[f] = 0;
		for(int i=1; i<edges[f].length; i++){
			if(edges[f][i] != Integer.MAX_VALUE){
				dist[i] = edges[f][i];
			}
		}
		
		//calc
		while(true){
			int shVertex = findShortest(mark);//find shortest path from collected vertex
			if(shVertex == -1) break;//finish, or non-connected-graph
			for(int i=1; i<edges[shVertex].length; i++){
				if(f == i || f == shVertex || i == shVertex || 
						edges[shVertex][i] ==Integer.MAX_VALUE || edges[f][shVertex] ==Integer.MAX_VALUE ||
						mark[i]) continue;//skip some situation!???
				if(edges[f][i] > edges[f][shVertex]+edges[shVertex][i])
					dist[i] = edges[f][shVertex]+edges[shVertex][i];//update dist[]
			}
			mark[shVertex] = true;//collect
		}
		p(dist[t]);
	}

	private static int findShortest(boolean[] mark) {
		int ret = -1;
		int min = Integer.MAX_VALUE;
		for(int i=1; i<mark.length; i++){
			if(!mark[i]) continue;//not collected
			for(int j=1; j<edges[i].length; j++){
				if(i!=j && !mark[j] && edges[i][j]<min){
					min = edges[i][j];
					ret = j;
				}
			}
		}
		return ret;
	}

	private static int[][] floyd(int[][] edges, int n) {
		int[][] A = new int[n+1][n+1];
		fillArr(A, Integer.MAX_VALUE);
		for (int i = 1; i < A.length; i++) {
			for (int j = 1; j < A.length; j++) {
				A[i][j] = edges[i][j];
			}
		}
		
		for (int k = 1; k < A.length; k++) {
			for (int i = 1; i < A.length; i++) {
				for (int j = 1; j < A.length; j++) {
					if(i!=k&&j!=k){
						if(A[i][j] > A[i][k]+A[k][j] && A[k][j]!=Integer.MAX_VALUE && A[i][k]!=Integer.MAX_VALUE){
							A[i][j] = A[i][k]+A[k][j];
						}
					}
				}
			}
		}
		return A;
	}

	private static void buildGraph(int n, int m, int[][] edges) {
		while(m-- > 0){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int v3 = sc.nextInt();
			edges[v1][v2] = v3;
			edges[v2][v1] = v3;//non direct
		}
	}
	
	private static void fillArr(int[][] edges, int v){
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[0].length; j++) {
				edges[i][j] = v;
			}
		}
	}

	public static void p(Object o) {
		System.out.println(o);
	}
}
