package com.opticalix.problem_archieved_2017;

import java.util.*;
import java.util.Map.Entry;
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
 * @author opticalix
 */
@SuppressWarnings("unused")
public class BUPT_OJ_84 {
	
	private static Scanner scanner;

	public static void main(String args[]) throws IOException{
		solveUsingReader();
		System.exit(0);
	}

	private static void solveUsingReader() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			while(true){
				try {
					Integer n = Integer.valueOf(br.readLine());
					StringTokenizer st = new StringTokenizer(br.readLine());
					map.clear();
					while(st.hasMoreTokens()){
						Long key = Long.valueOf(st.nextToken());
						if(map.containsKey(key)){
							map.put(key, map.get(key)+1);
						}else{
							map.put(key, 1);
						}
					}
					Set<Entry<Long, Integer>> entrySet = map.entrySet();
					for(Entry<Long, Integer> es : entrySet){
						if(es.getValue().intValue() == 1){
							p(es.getKey()+"");
							break;
						}
					}
				} catch (NumberFormatException e) {
					break;
				} catch (IOException e) {
				}
			}
	}

	private static void solveUsingScanner() {
		scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			int n = Integer.valueOf(scanner.nextLine());
			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			StringTokenizer st = new StringTokenizer(scanner.nextLine());
			while(st.hasMoreTokens()){
				Long key = Long.valueOf(st.nextToken());
				if(map.containsKey(key)){
					map.put(key, map.get(key)+1);
				}else{
					map.put(key, 1);
				}
			}
			Set<Entry<Long, Integer>> entrySet = map.entrySet();
			for(Entry<Long, Integer> es : entrySet){
				if(es.getValue().intValue() == 1){
					p(es.getKey()+"");
				}
			}
		}
		scanner.close();
	}

	public static void p(Object o) {
		System.out.println(o);
	}

}
