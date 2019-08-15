package com.opticalix.problem;

import com.opticalix.lib.Utils;

/**
 * Data Structure
 *
 * @author Felix
 * @date 14/08/2019 11:42 AM
 * @email opticalix@gmail.com
 */
public class BasicDS {

    public static void main(String[] args) {
        int[] ints = {5, 3, 1};
        ints = mergeSort(ints, 0, ints.length - 1);
        Utils.pArr(ints);
    }

    /**
     * to fix
     *
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
                Utils.swap(A, start, end);
            }
        }
        if (start == end && A[start] < base) {
            Utils.swap(A, l, start);
        }
        qSort(A, l, start - 1);
        qSort(A, end + 1, r);
    }

    /**
     * to fix
     *
     * @param A
     * @param l
     * @param r
     */
    @Deprecated
    public static void qSort2(int v[], int start, int end) {
        if (start >= end) return;
        //find base
        int i, j;//pos
        int base;//value
        i = start;
        j = end;
        base = v[start];

        while (i != j) {
            while (v[j] > base && i != j) {
                //find littel one, stop when i==j, start with j!
                j--;
            }
            while (v[i] < base && i != j) {
                //find large one, stop when i==j
                i++;
            }

            //still need move i/j
            if (i < j) {
                Utils.swap(v, i, j);
            }
        }

        //i==j already meet, need swap base with current value
        if (i == j && v[i] < base) {
            Utils.swap(v, start, i);
        }

        qSort2(v, start, i - 1);
        qSort2(v, i + 1, end);
    }

    public static void qSort3(int v[], int start, int end) {
        if (start >= end) return;
        int i, j;
        int base;//value
        i = start;
        j = end;
        base = v[start];

        while (i != j) {
            while (v[j] >= base && i != j) {
                j--;
            }
            v[i] = v[j];
            while (v[i] <= base && i != j) {
                i++;
            }
            v[j] = v[i];
        }

        v[i] = base;
        qSort3(v, start, i - 1);
        qSort3(v, i + 1, end);
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
        for (int i = end; i >= start + 1; i--) {
            for (int j = start; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    Utils.swap(A, j, j + 1);
                }
            }
        }
    }

    public static void mergeSort(int[] a) {
        int start = 0;
        int end = a.length - 1;
        int[] tmp = new int[a.length];
        mergeSort(a, tmp, start, end);
    }

    private static void mergeSort(int[] a, int[] tmp, int start, int end) {
        if (start >= end) {
            return;
        }
        //partial deal
        int mid = (start + end) / 2;
        int p = start;
        int q = mid + 1;
        int to = start;
        mergeSort(a, tmp, start, mid);
        mergeSort(a, tmp, mid + 1, end);
        //merge
        while (p <= mid && q <= end && to <= end) {
            tmp[to++] = a[p] > a[q] ? a[q++] : a[p++];
        }
        while (p <= mid && to <= end) {
            tmp[to++] = a[p++];
        }
        while (q <= end && to <= end) {
            tmp[to++] = a[q++];
        }
        //copy
        for (int i = start; i <= end; i++) {
            a[i] = tmp[i];
        }
    }

    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h)
            return new int[]{nums[l]};

        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)
            newNum[m++] = leftArr[i++];
        while (j < rightArr.length)
            newNum[m++] = rightArr[j++];
        return newNum;
    }
}
