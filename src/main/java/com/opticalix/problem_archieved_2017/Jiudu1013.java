package com.opticalix.problem_archieved_2017;

import java.util.*;
import java.io.*;

@SuppressWarnings("unused")
/**
 * ※ 大水题
 * ※※ 小水题
 * ※※※ 稍难 数据结构&数学技巧
 * ※※※※ 复杂数据结构&贪心&动归
 * ※※※※※ 无法AC
 * 
 * ※※
 * 读稍复杂的格式，化str为int比较
 * @author opticalix
 *
 */
public class Jiudu1013 {

	private static Scanner scanner;

	public static void main(String args[]) throws IOException {
		scanner = new Scanner(System.in);

		int n = Integer.valueOf(scanner.nextLine());
		while (n-- > 0) {
			String firstId="",lastId="";
			int first=24*60*60-1, last=0;
			int m = Integer.valueOf(scanner.nextLine());
			while (m-- > 0) {
				StringTokenizer st = new StringTokenizer(scanner.nextLine());
				Record r = new Record(st.nextToken(), Record.toTimeStamp(st.nextToken()), Record.toTimeStamp(st.nextToken()));
				if(first>r.in){
					firstId = r.getId();
					first = r.in;
				}
				if(last<r.out){
					lastId = r.getId();
					last = r.out;
				}
			}
			if(firstId.length() != 0 || lastId.length() != 0){
				p(firstId+" "+lastId);
			}
		}
		scanner.close();
		System.exit(0);
	}

	static class Record {
		String id;
		int in;
		int out;

		public Record(String id, int in, int out) {
			super();
			this.id = id;
			this.in = in;
			this.out = out;
		}

		public static int toTimeStamp(String time) {
			String[] split = time.split(":");
			int ret = 0;
			ret += Integer.valueOf(split[2]);
			ret += Integer.valueOf(split[1]) * 60;
			ret += Integer.valueOf(split[0]) * 60 * 60;
			return ret;
		}

		public String getId() {
			return id;
		}

		public int getIn() {
			return in;
		}

		public int getOut() {
			return out;
		}

	}

	public static void swap(char[] chArr, int a, int b) {
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
