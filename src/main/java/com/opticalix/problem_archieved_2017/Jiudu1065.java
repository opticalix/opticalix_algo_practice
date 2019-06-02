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
 * Java Time Exceed?
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1065 {

	private static Scanner scanner;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		scanner = new Scanner(System.in);
		br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while(scanner.hasNextLine()){
			line = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(line);
			Integer h = Integer.valueOf(st.nextToken());
			int max = (h-1)*2 + h;
			for(int i=0; i<h; i++){//line
				int ch = i*2+h;
				int sp = max - ch;
				while(sp-- > 0){
					System.out.print(" ");
				}
				while(ch-- > 0){
					System.out.print("*");
				}
				System.out.println();
			}
		}
		br.close();
		scanner.close();
		System.exit(0);
	}

}
