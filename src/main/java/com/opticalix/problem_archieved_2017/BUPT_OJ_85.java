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
 * ***
 * 三点共线判断：
 * 有两点重合，必共线
 * 距离d1 d2 d3，有d1+d2=d3
 * 根据两点决定直线，求斜率看第三点是否也满足该斜率。O(n^3) 排列组合中C(m,n)的for循环
 * @author opticalix
 */
@SuppressWarnings("unused")
public class BUPT_OJ_85 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useSc();
//		useBr();
		System.exit(0);
	}
	
	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		Integer t = Integer.valueOf(sc.nextLine());
		Point[] points = new Point[100];
		while(t-- > 0){
			//read
			Integer n = Integer.valueOf(sc.nextLine());
			for(int i=0; i<n; i++){
				points[i] = new Point(sc.nextFloat(), sc.nextFloat());
			}
			sc.nextLine();
			
			//judge
			boolean found = false;
			out: for(int i=0; i<n; i++){
				for(int j=i+1; j<n; j++){
					for(int k=j+1; k<n; k++){
						float s1 = calcSlope(points[i], points[j]);
						float s2 = calcSlope(points[i], points[k]);
						if((Float.compare(Float.NaN, s1)==0||Float.compare(Float.NaN, s1)==0) //same point
								|| (s1==Float.POSITIVE_INFINITY && s2==Float.POSITIVE_INFINITY) //straight
								|| Math.abs(Math.abs(s1)-Math.abs(s2)) <= 0.0000001f){//0.0000001
							found = true;
							break out;
						}
					}
				}
			}
			p(found?"Yes":"No");
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
	
	static class Point{
		float x;
		float y;
		public Point(float x, float y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Float.floatToIntBits(x);
			result = prime * result + Float.floatToIntBits(y);
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
			Point other = (Point) obj;
			if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
				return false;
			if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
				return false;
			return true;
		}
		
	}
	
	/**
	 * 垂直=INFINITE 水平=0
	 * @param a
	 * @param b
	 * @return
	 */
	public static float calcSlope(Point a, Point b){
		float dist_y = b.y-a.y;
		float dist_x = b.x-a.x;
		if(dist_y==0 && dist_x==0){
			return Float.NaN;
		}else if(dist_x==0){
			return Float.POSITIVE_INFINITY;
		}
		return dist_y/dist_x;
	}
}
