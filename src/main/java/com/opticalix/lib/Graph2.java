package com.opticalix.lib;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 使用邻接矩阵存储有向图
 */
public class Graph2 {
    private ArrayList vertexList;//存储点的链表
    private int[][] edges;//邻接矩阵，用来存储边
    private int numOfEdges;//边的数目

    public Graph2(int n) {
        //初始化矩阵，一维数组，和边的数目
        edges = new int[n][n];
        vertexList = new ArrayList(n);
        numOfEdges = 0;
    }

    //得到结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i的数据
    public Object getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1,v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //插入结点
    public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(), vertex);
    }

    //插入结点
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        numOfEdges++;
    }

    //删除结点
    public void deleteEdge(int v1, int v2) {
        edges[v1][v2] = 0;
        numOfEdges--;
    }

    //得到第一个邻接结点的下标
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来取得下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    int[][] getEdges() {
        return edges;
    }

    void dfs(int i, int[] visited) {
        int j;
        System.out.println("dfs visit: " + i + ", " + this.getValueByIndex(i));
        visited[i] = 1;
        for (j = 0; j < this.getNumOfVertex(); j++) {
            if (this.getWeight(i, j) > 0 && visited[j] == 0) {
                dfs(j, visited);
            }
        }
    }

    void bfs(int i, int[] visited) {
        //i is start index
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(i);
        int[][] edges = getEdges();
        while(queue.size() > 0) {
            int j = queue.poll();
            if (visited[j] == 0) {
                System.out.println("bfs visit: " + j + ", " + this.getValueByIndex(j));
                visited[j] = 1;
            }
            for (int k = 0; k < this.getNumOfVertex(); k++) {
                if (edges[j][k] > 0 && visited[k] == 0) {
                    queue.offer(k);
                }
            }
        }
    }

    public static void main(String args[]) {
        int n = 4, e = 4;//分别代表结点个数和边的数目
        String labels[] = {"V1", "V2", "V3", "V4"};
        Graph2 graph = new Graph2(n);
        // insert labels
        for (String label : labels) {
            graph.insertVertex(label);//插入结点
        }
        //insert edges
        graph.insertEdge(0, 1, 2);
        graph.insertEdge(0, 2, 5);
        graph.insertEdge(2, 3, 8);
        graph.insertEdge(3, 0, 7);

        System.out.println("结点个数是：" + graph.getNumOfVertex());
        System.out.println("边的个数是：" + graph.getNumOfEdges());

//        graph.deleteEdge(0, 1);//删除<V1,V2>边
//        System.out.println("删除<V1,V2>边后...");
//        System.out.println("结点个数是：" + graph.getNumOfVertex());
//        System.out.println("边的个数是：" + graph.getNumOfEdges());

        // 用于取v1的所有临接结点
//        System.out.println("" + graph.getFirstNeighbor(0));
//        System.out.println("" + graph.getFirstNeighbor(1));
//        System.out.println("" + graph.getFirstNeighbor(2));
//        System.out.println("" + graph.getFirstNeighbor(3));
//        System.out.println("" + graph.getNextNeighbor(0, 2));

        //dfs
//        graph.dfs(0, new int[graph.getNumOfVertex()]);
        graph.bfs(2, new int[graph.getNumOfVertex()]);
    }
}