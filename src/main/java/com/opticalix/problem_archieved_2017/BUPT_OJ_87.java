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
 * 
 * @author opticalix
 */
@SuppressWarnings("unused")
public class BUPT_OJ_87 {

	private static Scanner sc;
	private static BufferedReader br;
	static final int[] common_mon_days = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static final int[] yeap_mon_days = new int[] { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public static void main(String args[]) throws IOException {
		useSc();
		System.exit(0);
	}
	
	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-- > 0){
			String line = sc.nextLine();
			String[] yearMonDay = line.split(":");
			int result;
			if(isYeap(yearMonDay[0])){
				result = countDays(yearMonDay, yeap_mon_days);
			}else{
				result = countDays(yearMonDay, common_mon_days);
			}
			p(result);
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

	private static int countDays(String[] yearMonDay, int[] mon_days) {
		int mon = Integer.valueOf(yearMonDay[1]);
		int day = Integer.valueOf(yearMonDay[2]);
		int cnt=0;
		int workMon = 1;
		//count by mon
		while(workMon<mon){
			cnt+=mon_days[workMon];
			workMon++;
		}
		//count by days
		cnt+=day;
		return cnt;
	}

	public static void p(Object o) {
		System.out.println(o);
	}
	
	private static boolean isYeap(String y) {
		int year=0;
		if((y instanceof String)){
			year = Integer.valueOf(y);
		}
		return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
	}
}
