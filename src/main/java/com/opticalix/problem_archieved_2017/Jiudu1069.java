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
 * **
 * 1506 -1521 coding time
 * not ac..
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1069 {

	private static Scanner scanner = new Scanner(System.in);
	private static BufferedReader br;
	private static final String NO_MATCH = "No Answer!";
	
	public static void main(String args[]) throws IOException {
		while(scanner.hasNextLine()){
			func3();
		}
	}
	
	/**
	 * 先排序再二分也有一定价值，具体要根据时间复杂度估算
	 */
	private static void func3() {
		int n = Integer.valueOf(scanner.nextLine());
		Stu[] students = new Stu[n];
		for(int i=0; i<n; i++){
			StringTokenizer st = new StringTokenizer(scanner.nextLine());
			String id = st.nextToken();
			String name = st.nextToken();
			String sex = st.nextToken();
			int age = Integer.valueOf(st.nextToken());
			Stu stu = new Stu(id, name, sex, age);
			students[i] = stu;
		}
		
		//sort
		Arrays.sort(students, new Comparator<Stu>() {

			@Override
			public int compare(Stu o1, Stu o2) {
				return o1.intId()-o2.intId();
			}
		});
		
		//bSearch
		int m = Integer.valueOf(scanner.nextLine());
		while(m-- > 0){//m will dismiss
			String target = scanner.nextLine();
			int tId = Integer.valueOf(target);
			int l=0, r=n-1,mid=-1;
			while(l<=r){
				mid = (l+r)/2;
				if(tId>students[mid].intId()){
					l=mid+1;
				}else if(tId<students[mid].intId()){
					r=mid-1;
				}else{
					break;
				}
			}
			if(students[mid].intId()==tId){
				p(students[mid]);
			}else{
				p(NO_MATCH);
			}
		}
	}

	private static void func2(){
		int n = Integer.valueOf(scanner.nextLine());
		HashMap<String, Stu> map = new HashMap<String, Stu>();
		while(n-- > 0){
			StringTokenizer st = new StringTokenizer(scanner.nextLine());
			String id = st.nextToken();
			String name = st.nextToken();
			String sex = st.nextToken();
			int age = Integer.valueOf(st.nextToken());
			map.put(id, new Stu(id, name, sex, age));
		}
		int m = Integer.valueOf(scanner.nextLine());
		while(m-- > 0){
			StringTokenizer st = new StringTokenizer(scanner.nextLine());
			Stu target;
			if((target=map.get(st.nextToken())) == null){
				p(NO_MATCH);
			}else{
				p(target);
			}
		}
	}

	private static void func1() {
		int n = Integer.valueOf(scanner.nextLine());
		Stu[] students = new Stu[n];
		String idArr[] = new String[n];
		for(int i=0; i<n; i++){
			StringTokenizer st = new StringTokenizer(scanner.nextLine());
			String id = st.nextToken();
			idArr[i] = id;
			
			String name = st.nextToken();
			String sex = st.nextToken();
			int age = Integer.valueOf(st.nextToken());
			students[i] = new Stu(id, name, sex, age);
		}
		
		int m = Integer.valueOf(scanner.nextLine());
		while(m-- > 0){
			String tId = scanner.nextLine();
			boolean match = false;
			for(int i=0; i<n; i++){
				if(idArr[i].equals(tId)){
					p(students[i]);
					match = true;
					break;
				}
			}	
			if(!match){
				p(NO_MATCH);
			}
		}
	}
	
	static class Stu{
		String id;
		String name;
		String sex;
		int age;
		public Stu(String id, String name, String sex, int age) {
			super();
			this.id = id;
			this.name = name;
			this.sex = sex;
			this.age = age;
		}
		@Override
		public String toString() {
			return id+" "+name+" "+sex+" "+age;
		}
		
		public int intId(){
			return Integer.valueOf(id);
		}
	}
	public static void p(Object o) {
		System.out.println(o);
	}


}
