package com.opticalix.lib;

import java.util.List;

public class MyCollections {
	public static <T> int binarySearch(
			List<? extends Comparable<? super T>> list, T key) {
		int start=0; int end=list.size()-1;
		int ret = -1;
		while(start<=end){
			int mid = (start+end)>>>1;
			if(list.get(mid).equals(key)){
				ret = mid;
				break;
			}else if(list.get(mid).compareTo(key)>0){
				end = mid-1;
			}else{
				start = mid+1;
			}
		}
		return ret;
	}
}
