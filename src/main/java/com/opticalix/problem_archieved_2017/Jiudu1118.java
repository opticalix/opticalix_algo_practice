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
 * 进制转换
 * @author opticalix
 */
@SuppressWarnings("unused")
public class Jiudu1118 {

	private static Scanner sc;
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		useBr();
		System.exit(0);
	}
	
	private static void useSc() throws IOException{
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			Integer fromScale = Integer.valueOf(st.nextToken());
			String numStr = st.nextToken();
			Integer toScale = Integer.valueOf(st.nextToken());
			
			long numDec = Long.parseLong(numStr, fromScale);
			String finalNumStr = convertDecToAnoScale(numDec, toScale);
			p(finalNumStr);
		}
		sc.close();
	}
	private static String convertDecToAnoScale(long numDec, Integer toScale) {
		String ret = "";
		if(numDec==0){
			return "0";
		}
		while(numDec != 0){
			ret = singleIntToChar((int)numDec%toScale)+ret;
			numDec/=toScale;
		}
		return ret;
	}
	
	private static String singleIntToChar(int num){
		if(num < 10){
			return String.valueOf((char)('0'+num));
		}else{
			int dif = num-10;
			return String.valueOf((char)('A'+dif));
		}
	}

	private static void useBr() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=br.readLine()) != null){
			//use Java API..
			StringTokenizer st = new StringTokenizer(line);
			Integer fromScale = Integer.valueOf(st.nextToken());
			String numStr = st.nextToken();
			Integer toScale = Integer.valueOf(st.nextToken());
			
			String ret = Integer.toString(Integer.valueOf(numStr, fromScale), toScale).toUpperCase();
			p(ret);
		}
		br.close();
	}

	public static void p(Object o) {
		System.out.println(o);
	}
}
