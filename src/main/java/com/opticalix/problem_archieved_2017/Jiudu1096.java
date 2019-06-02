package com.opticalix.problem_archieved_2017;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

/*
 * ※ 大水题
 * ※※ 小水题
 * ※※※ 稍难 数据结构&数学技巧
 * ※※※※ 复杂数据结构&贪心&动归
 * ※※※※※ 无法AC
 */

/**
 * ** 日期差值
 * 
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1096 {

	private static Scanner scanner;

	public static void main(String args[]) throws IOException {
		scanner = new Scanner(System.in);
		// func1();
		test();
		scanner.close();
		System.exit(0);
	}

	// http://www.cnblogs.com/honoka/p/4972442.html
	private static void test() {
		while (scanner.hasNextLine()) {
			String d1 = scanner.nextLine();
			Calendar c1 = getCalendar(d1);
			long time1 = c1.getTimeInMillis();
			String d2 = scanner.nextLine();
			Calendar c2 = getCalendar(d2);
			long time2 = c2.getTimeInMillis();
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// p(sdf.format(new Date(Math.abs(time1))));
		}
	}

	private static Calendar getCalendar(String d1) {
		int year = Integer.valueOf(d1.substring(0, 4));
		int mon = Integer.valueOf(d1.substring(4, 6));
		int day = Integer.valueOf(d1.substring(6, 8));
		if (year < 1900) {
			throw new RuntimeException();
		}
		Calendar c = Calendar.getInstance(TimeZone.getDefault(), Locale.CHINA);
		c.set(year, mon - 1, day, 0, 0, 0);
		return c;
	}

	private static void func1() {
		while (scanner.hasNextLine()) {
			MyDate date1 = new MyDate(scanner.nextLine());
			MyDate date2 = new MyDate(scanner.nextLine());
			MyDate former = date1.compareTo(date2) > 0 ? date2 : date1;
			MyDate latter = date1.compareTo(date2) > 0 ? date1 : date2;
			int cnt = 1;
			while (!former.equals(latter)) {
				if (former.year < latter.year
						&& ((former.mon < latter.mon) || (former.mon == latter.mon && former.day < latter.day))) {
					cnt += former.nextYear();
				} else {
					cnt += former.nextDay();
				}
			}
			p(cnt);
		}
	}

	static class MyDate implements Comparable<MyDate> {
		final int[] common_mon_days = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		final int[] yeap_mon_days = new int[] { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int year;
		int mon;
		int day;

		public MyDate(String d1) {
			super();
			this.year = Integer.valueOf(d1.substring(0, 4));
			this.mon = Integer.valueOf(d1.substring(4, 6));
			this.day = Integer.valueOf(d1.substring(6, 8));
		}

		public MyDate(int year, int mon, int day) {
			super();
			this.year = year;
			this.mon = mon;
			this.day = day;
		}

		// iteration
		public int nextDay() {
			int maxDaysThisMon = isYeap(this) ? yeap_mon_days[this.mon] : common_mon_days[this.mon];
			if (day < maxDaysThisMon) {
				day++;
			} else {
				if (mon != 12) {
					mon++;
					day = 1;
				} else {
					year++;
					mon = 1;
					day = 1;
				}
			}
			return 1;
		}

		/**
		 * 
		 * @return skip days
		 */
		public int nextYear() {
			int ret;
			if (isYeap(this)) {
				if (mon == 2 && day == 29) {
					day = 28;
					ret = 365;
				} else {
					ret = 366;
				}
			} else {
				ret = 365;
			}
			year++;
			return ret;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + day;
			result = prime * result + mon;
			result = prime * result + year;
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
			MyDate other = (MyDate) obj;
			if (day != other.day)
				return false;
			if (mon != other.mon)
				return false;
			if (year != other.year)
				return false;
			return true;
		}

		@Override
		public int compareTo(MyDate o) {
			int year1 = Integer.valueOf(this.year);
			int mon1 = Integer.valueOf(this.mon);
			int day1 = Integer.valueOf(this.day);
			int year2 = Integer.valueOf(o.year);
			int mon2 = Integer.valueOf(o.mon);
			int day2 = Integer.valueOf(o.day);
			int ret = 0;
			if (year1 == year2) {
				if (mon1 == mon2) {
					ret = day1 - day2;
				} else {
					ret = mon1 - mon2;
				}
			} else {
				ret = year1 - year2;
			}
			return ret;
		}

		@Override
		public String toString() {
			return String.format("%d-%d-%d", year, mon, day);
		}

	}

	private static boolean isYeap(MyDate d1) {
		int year = Integer.valueOf(d1.year);
		return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
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

	public static void swap(char[] chArr, int a, int b) {
		char tmp = chArr[a];
		chArr[a] = chArr[b];
		chArr[b] = tmp;
	}

}
