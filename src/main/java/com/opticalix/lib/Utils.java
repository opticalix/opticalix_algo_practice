package com.opticalix.lib;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

	public static void pArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + (j == arr[0].length - 1 ? "" : ",\t"));
			}
			System.out.println();
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

	/**
	 * to fix
	 * @param A
	 * @param l
	 * @param r
	 */
	@Deprecated
	public static void qSort(int[] A, int l, int r) {
		if (l >= r) {
			return;
		}
		int start = l;
		int end = r;
		int base = A[l];
		while (start < end) {// loop before start meet end
			while (A[end] >= base && start < end) {
				end--;
			}
			while (A[start] <= base && start < end) {
				start++;
			}
			if (start < end) {
				swap(A, start, end);
			}
		}
		if(start==end && A[start]<base){
			swap(A, l,start);
		}
		qSort(A, l, start - 1);
		qSort(A, end + 1, r);
	}
	
	/**
	 * to fix
	 * @param A
	 * @param l
	 * @param r
	 */
	@Deprecated
	public static void qSort2(int v[], int start, int end){
	    if(start >= end) return;
	    //find base
	    int i, j;//pos
	    int base;//value
	    i = start;
	    j = end;
	    base = v[start];
	    
	    while (i != j) {
	        while (v[j]>base && i!=j) {
	            //find littel one, stop when i==j, start with j!
	            j--;
	        }
	        while (v[i]<base && i!=j) {
	            //find large one, stop when i==j
	            i++;
	        }
	        
	        //still need move i/j
	        if(i < j){
	            swap(v, i, j);
	        }
	    }
	    
	    //i==j already meet, need swap base with current value
	    if(i == j && v[i] < base){
	        swap(v, start, i);
	    }
	    
	    qSort2(v, start, i-1);
	    qSort2(v, i+1, end);
	}
	
	public static void qSort3(int v[], int start, int end){
		if(start >= end) return;
	    int i, j;
	    int base;//value
	    i = start;
	    j = end;
	    base = v[start];
	    
	    while (i != j) {
	        while (v[j]>=base && i!=j) {
	            j--;
	        }
            v[i]= v[j];
	        while (v[i]<=base && i!=j) {
	            i++;
	        }
            v[j]= v[i];
	    }
	    
    	v[i]=base;
	    qSort3(v, start, i-1);
	    qSort3(v, i+1, end);
	}

	public static void swap(int[] A, int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}

	public static int binSearch(int[] a, int s, int e, int target) {
		int ret = -1;
		int l = s, r = e;
		int mid;
		while (l <= r) {
			mid = (l + r) / 2;
			if (a[mid] > target) {
				r = mid - 1;
			} else if (a[mid] < target) {
				l = mid + 1;
			} else {
				ret = mid;
				break;
			}
		}
		
		//find first
		while (ret != -1 && target == a[ret] && target == a[ret - 1]) {
			ret--;
		}
		return ret;
	}
	
	public static void bubbleSort(int[] A, int start, int end) {
		for(int i=end; i>=start+1; i--){
			for(int j=start; j<i; j++){
				if(A[j] > A[j+1]){
					Utils.swap(A, j, j+1);
				}
			}
		}
	}
	
	public static void mergeSort(int[] a) {
		int start=0;
		int end = a.length-1;
		int[] tmp = new int[a.length];
		mergeSort(a, tmp, start, end);
	}
	
	private static void mergeSort(int[] a, int[] tmp, int start, int end){
		if(start >= end){
			return;
		}
		//partial deal
		int mid = (start+end)/2;
		int p=start;
		int q=mid+1;
		int to = start;
		mergeSort(a, tmp, start, mid);
		mergeSort(a, tmp, mid+1, end);
		//merge
		while(p<=mid && q<=end && to<=end){
			tmp[to++] = a[p]>a[q]?a[q++]:a[p++];
		}
		while(p<=mid && to<=end){
			tmp[to++] = a[p++];
		}
		while(q<=end && to<=end){
			tmp[to++] = a[q++];
		}
		//copy
		for(int i=start; i<=end; i++){
			a[i] = tmp[i];
		}
	}
}
