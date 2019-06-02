package com.opticalix.problem_archieved_2017;

import java.io.*;
import java.util.*;


/**
 * tag 并查集
 * 即无向图是否全联通且无回路！
 * 使用并查集，若union时root一样则说明二者再union会出现环路
 * 注意边界条件：0 0时直接输出yes
 * http://acm.hdu.edu.cn/submit.php?pid=1272
 */
@SuppressWarnings("unused")
public class Hoj1272 {

	private static Reader reader;

	public static class Reader {
		private StringTokenizer tokenizer;
		private BufferedReader reader;

		public Reader() {
			tokenizer = new StringTokenizer("");
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nextToken() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			String token = nextToken();
			return Integer.valueOf(token);
		}

		public String nextLine() throws IOException {
			if (tokenizer.hasMoreTokens())
				throw new RuntimeException("has unread token");
			return reader.readLine();
		}
	}

	public static void main(String[] args) throws IOException {
		hoj1272();
	}

	/**
	 * 迷宫
	 * 即无向图是否全联通且无回路！ 是否是最小生成树？
	 * http://acm.hdu.edu.cn/submit.php?pid=1272
	 */
	private static void hoj1272() {
		Scanner scanner = new Scanner(System.in);
		Hoj1272Set disjointSet = new Hoj1272Set(100001);
		HashSet<Integer> hashSet = new HashSet<Integer>();//involved cnt
		boolean badFlag = false;//have loop
		while(scanner.hasNextLine()){
			String l = scanner.nextLine();
			if(l.equals("-1 -1")){
				break;//end
			}else if(null == l || l.isEmpty()){
				continue;
			}else{
				StringTokenizer st = new StringTokenizer(l);
				for(int i=st.countTokens(); i>0; i-=2){
					Integer x = Integer.valueOf(st.nextToken());
					Integer y = Integer.valueOf(st.nextToken());
					if(x == y && x == 0){//end of segment
						if(disjointSet.getVisitCnt() == 0){
							p("Yes");
						}else{
							if(badFlag){
								badFlag = false;
								p("No");
							}else{
								int involvedCnt = hashSet.size();
								if(disjointSet.getGroupCnt()-(100001-involvedCnt) == 1){
									p("Yes");
								}else{
									p("No");
								}
							}
						}
						disjointSet.clear();
						hashSet.clear();
					}else{
						hashSet.add(x);
						hashSet.add(y);
						if(!disjointSet.union(x, y)){
							badFlag = true;
						}
					}
				}
			}
		}
	}
	

	private static class Hoj1272Set {
	
		private int[] s;
		int visitCnt;//涉及的个数
		private int groupCnt;//子集合个数 默认为数组大小n
	
		public Hoj1272Set(int n) {
			super();
			s = new int[n];
			for (int i = 0; i < n; i++) {
				s[i] = -1;
			}
			groupCnt = n;
		}
		
		public void clear(){
			visitCnt = 0;
			for (int i = 0; i < s.length; i++) {
				s[i] = -1;
			}
			groupCnt = s.length;
		}
	
		public boolean union(int x, int y) {
			int x_root = find(x);
			int y_root = find(y);
			visitCnt+=(x==y?1:2);
			if(x_root == y_root){
				return false;//already same group
			}
			//optimize?
			s[y_root]=x_root;
			groupCnt--;
			return true;
		}
		
		public int find(int t) {
			return s[t] == -1 ? t : (s[t]=find(s[t]));//压缩
		}
	
		public int getGroupCnt() {
			return groupCnt;
		}

		public int getVisitCnt() {
			return visitCnt;
		}
	
	}
	
	private static void swap(char[] chArr, int a, int b) {
		char tmp = chArr[a];
		chArr[a] = chArr[b];
		chArr[b] = tmp;
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

	public static <T> void pList(ArrayList<T> list, T[] t) {
		list.toArray(t);
		pArr(t);
	}
}