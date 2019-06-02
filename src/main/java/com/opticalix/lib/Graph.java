package com.opticalix.lib;

import java.util.*;

/**
 * 0 -- N-1
 * @author opticalix
 *
 */
public class Graph {
	Map<Integer, List<Edge>> neighborMap;//邻接表
	int N;
	boolean directed;
	
	public Graph(int n) {
		super();
		N = n;
		neighborMap = new HashMap<Integer, List<Edge>>();
		for(int i=0; i<N; i++){
			List<Edge> edges = new ArrayList<>();
			neighborMap.put(i, edges);
		}
	}
	
	class Edge{
		int v;
		int cost;
		public Edge(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}
	}
	
	public void connect(int src, int dest, int cost){
		neighborMap.get(src).add(new Edge(dest, cost));
		if(!directed)
			neighborMap.get(dest).add(new Edge(src, cost));
	}

	/**
	 * dijkstra
	 * @param src
	 * @return dist[]
	 */
	public int[] dijkstra(int src){
		//initial
		int[] dist = new int[N];
		List<Integer> collected = new ArrayList<Integer>();//collected
		int[] path = new int[N];//path
		for(int i=0; i<N; i++){
			dist[i] = Integer.MAX_VALUE;
			path[i] = -1;
		}
		List<Edge> edges = neighborMap.get(src);
		for(int i=0; i<edges.size(); i++){
			dist[edges.get(i).v] = edges.get(i).cost;
			path[edges.get(i).v] = src;
		}
		dist[src] = 0;
		path[src] = 0;
		collected.add(src);
		
		//process
		while(true){
			int min = getClosestNeighbor(dist, collected, src);
			if(min != src){
				collected.add(min);//collect MIN only influence its neighbors
				for(int i=0; i<neighborMap.get(min).size(); i++){
					Edge edge = neighborMap.get(min).get(i);
					if(!collected.contains(edge.v)){//not collected!
						if(edge.cost+dist[min] < dist[edge.v]){//can update?
							dist[edge.v] = edge.cost+dist[min];
							path[edge.v] = min;
						}
					}
				}
			}else{
				//all vertex is considered
				break;
			}
		}
		printPath(path, src);
		return dist;
	}

	private void printPath(int[] path, int src) {
		for(int i=0; i<path.length; i++){
			if(path[i] == 0){
				continue;
			}else if(path[i] == -1){
				System.out.println(String.format("from %s to %s:\n-1", src, i).toString());
			}else{
				System.out.println(String.format("from %s to %s:", src, i).toString());
				int x = path[i];
				LinkedList<Integer> stack = new LinkedList<Integer>();
				while(x!=0){
					stack.push(x);
					x = path[x];
				}
				while(stack.size()!=0){
					System.out.print(stack.pop()+(stack.size()==0?"":","));
				}
				System.out.println();
			}
		}
	}

	/**
	 * 找到还未collect过的 dist中的最小值，即src的当前最近邻居
	 * 可用最小堆替代
	 * @param dist
	 * @param collected
	 * @param src
	 * @return 
	 */
	private int getClosestNeighbor(int[] dist, List<Integer> collected, int src){
		int minPos=src;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++){
			if(src!=i && dist[i] < min && !collected.contains(i)){
				min = dist[i];
				minPos = i;
			}
		}
		return minPos;
	}
	
	/**
	 * floyd
	 * 思路：A[i][j]表示i-j的距离，不断更新；i-j要么直接相连，要么通过k中转；
	 * 将k从0到N-1遍历即可。可画矩阵用十字交叉法助记
	 * http://www.tuicool.com/articles/6ZNZvy
	 * @return dist[][]
	 */
	public int[][] floyd(){
		int[][] A = new int[N][N];
		int[][] path = new int[N][N];//TODO check
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int directCost = directCost(i, j);
				A[i][j] = directCost;
				if(directCost != Integer.MAX_VALUE && directCost!=0){
					path[i][j]=0;
				}else{
					path[i][j]=-1;
				}
			}
		}
		
		for(int k=0; k<N; k++){
			//k即十字交叉法中 线所占的行序号或列序号
			//由于线上的某元素A[][]一定不可能被更新，所以可以跳过判断
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i!=k&&j!=k){
						if(A[i][j] > A[i][k]+A[k][j] && A[k][j]!=Integer.MAX_VALUE && A[i][k]!=Integer.MAX_VALUE){
							A[i][j] = A[i][k]+A[k][j];
							path[i][j] = k;//以k为中转
						}
					}
				}
			}
		}
		return A;
	}
	
	private int directCost(int src, int dest){
		if(src==dest){
			return 0;
		}
		List<Edge> neighbors = neighborMap.get(src);
		for (Iterator<Edge> iterator = neighbors.iterator(); iterator.hasNext();) {
			Edge edge = (Edge) iterator.next();
			if(dest == edge.v){
				return edge.cost;
			}
		}
		return Integer.MAX_VALUE;
	}
}
