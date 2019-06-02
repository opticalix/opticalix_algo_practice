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

//4
//4 3
//1 3
//2 3
//2 4
//1 0
//3 3
//1 2
//1 3
//2 3
//4 2
//1 2
//2 3

/**
 * ****
 * AC
 * 邻接矩阵：遍历 求两点间距离 BFS即可 还没用上Dijkstra
 * 
 * @author opticalix
 */
@SuppressWarnings("unused")
public class BUPT_OJ_272 {
	
	private static Scanner scanner;

	public static void main(String args[]) throws IOException{
		scanner = new Scanner(System.in);
		Integer t = Integer.valueOf(scanner.nextLine());
		while(t-- > 0){
			StringTokenizer st = new StringTokenizer(scanner.nextLine());
			int n = Integer.valueOf(st.nextToken());
			int m = Integer.valueOf(st.nextToken());
			UnweightGraph unweightGraph = new UnweightGraph(n);
			while(m-- > 0){
				StringTokenizer st2 = new StringTokenizer(scanner.nextLine());
				int from = Integer.valueOf(st2.nextToken());
				int to = Integer.valueOf(st2.nextToken());
				unweightGraph.addEdge(from, to);
			}
			p(unweightGraph.coreIndex());
		}
		
		scanner.close();
		System.exit(0);
	}
	
	/**
	 * 
	 * 无权图 Dijkstra较简单
	 * 邻接表法
	 * @author opticalix
	 */
	static class UnweightGraph{
		int dist[];
		int path[];
		ArrayList[] vertex;
		
		public UnweightGraph(int n) {
			vertex = new ArrayList[n+1];
			dist = new int[n+1];
			path = new int[n+1];
			
			for(int i=0; i<n+1; i++){
				dist[i] = -1;
				path[i] = -1;
				vertex[i] = new ArrayList();
			}
		}
		
		public void addEdge(int src, int dest){
			vertex[src].add(dest);
			vertex[dest].add(src);
		}
		
		private void clearDist(){
			for(int i=0; i<dist.length; i++){
				dist[i] = -1;
				path[i] = -1;
			}
		}
		
		public int coreIndex(){
			int core = 1;
			int len = Integer.MAX_VALUE;
			for(int i=1; i<dist.length; i++){
				bfs(i);
				int allJointLen = countConnectedNodeLen(i);
				if(allJointLen < len){
					len = allJointLen;
					core = i;
				}
			}
			return core;
		}
		
		public int countConnectedNodeLen(int src){
			int ret = 0;
			for(int i=1; i<dist.length; i++){
				if(dist[i]>=0){
					ret += dist[i];
				}else{//if a node is separated from others, set their distance=N
					ret += dist.length-1;
				}
			}
			return ret;
		}
		
		/**
		 * like bfs
		 * 关键在于是无权图，经过节点最少的路径一定最短
		 * @param src
		 */
		public void bfs(int src){
			clearDist();
			dist[src] = 0;
			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.add(src);
			while(!queue.isEmpty()){
				Integer head = queue.poll();
				for(int i=0; i<vertex[head].size(); i++){
					Integer jointIndex = (Integer) vertex[head].get(i);
					if(dist[jointIndex] == -1){//not reached
						dist[jointIndex] = dist[head]+1;
						path[jointIndex] = head;
						queue.add(jointIndex);
					}
				}
			}
		}
		
	}
	
	/**
	 * has problem..
	 * @author opticalix
	 *
	 */
	static class Graph{
		
		public Graph(int n) {
			toOthersLen = new int[n+1];
			visited = new int[n+1];
			edge = new int[n+1][n+1];
			
			//initial
			for(int i=0; i<n+1; i++){
				for(int j=0; j<n+1; j++){
					edge[i][j] = -1;
				}
			}
		}

		//[0] not use
		int edge[][];
		int toOthersLen[];
		int visited[];
		
		public void connect(int from, int to){
			edge[from][to] = 1;
			edge[to][from] = 1;
		}
		
		public void clearVisited(){
			for(int i=1; i<edge.length; i++){
				visited[i] = 0;
			}
		}
		
		public void calcToOthersLen(){
			for(int i=1; i<edge.length; i++){
				for(int j=1; j<edge.length; j++){
					clearVisited();
					int pathLen = pathLen(i, j);
					toOthersLen[i] += pathLen>0?pathLen:0;
				}
			}
		}
		
		public int pathLen(int from, int to){
			if(from == to){
				return -1;
			}
			if(edge[from][to] != -1){
				return edge[from][to];
			}else{
				for(int i=1; i<edge.length; i++){
					if(from!=i && i!=to && edge[from][i] != -1 && visited[i]!=1){
						//IMPORTANT 注意防止重复1-2-1-2-1-2查询
						visited[from] = 1;
						int pathLen = pathLen(i, to);
						if(pathLen>0){
							return pathLen+1;
						}else{
							continue;
						}
					}
				}
				return -1;
			}
		}
		
		public int coreIndex(){
			int min=Integer.MAX_VALUE, ret=1;
			for(int i=1; i<edge.length; i++){
				if(toOthersLen[i]>0 && toOthersLen[i]<min){
					ret = i;
					min = toOthersLen[i];
				}
			}
			return ret;
		}
	}

	public static void p(Object o) {
		System.out.println(o);
	}

	public static void pArr(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void pArr(String[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void pArr(Object[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}
