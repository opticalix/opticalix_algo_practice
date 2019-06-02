package com.opticalix.problem_archieved_2017;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.io.*;

/*
 * ※ 大水题
 * ※※ 小水题
 * ※※※ 稍难 数据结构&数学技巧
 * ※※※※ 复杂数据结构&贪心&动归
 * ※※※※※ 无法AC
 */

/**
 * CountDownLatch, 每个子类拿到开始倒计，到零时从CountDownLatch.await()处唤醒
 * CyclicBarrier, 可re-use的栅栏，只有await方法，调用时该线程查看是否达到party数，未凑齐则等待
 * @author opticalix
 */
@SuppressWarnings("unused")
public class ThreadProblem {

	private static Scanner scanner;
	private static volatile boolean stop = false;

	public static void main(String args[]) throws IOException {
		scanner = new Scanner(System.in);
		// testCD();
		testCB();

		scanner.close();
		System.exit(0);
	}

	private static void testCB() {
		CyclicBarrier cb = new CyclicBarrier(5);
		int[][] m = new int[5][5];
		new Thread(new CBInnerThread(cb, m, 0)).start();
		new Thread(new CBInnerThread(cb, m, 1)).start();
		new Thread(new CBInnerThread(cb, m, 2)).start();
		new Thread(new CBInnerThread(cb, m, 3)).start();
		new Thread(new CBInnerThread(cb, m, 4)).start();
		while (!stop) {}//wait for end
	}

	private static void testCD() {
		try {
			CountDownLatch cd = new CountDownLatch(4);
			new InnerThread(cd).start();
			new InnerThread(cd).start();
			new InnerThread(cd).start();
			new InnerThread(cd).start();
			p("main finish");
			cd.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class InnerThread extends Thread {
		CountDownLatch cd;

		public InnerThread(CountDownLatch cd) {
			super();
			this.cd = cd;
		}

		@Override
		public void run() {
			try {
				p(this.toString() + " start");
				Thread.sleep(new Random().nextInt(3000));
				if (cd != null) {
					cd.countDown();
				}
				p(this.toString() + " end");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static class CBInnerThread implements Runnable {
		CyclicBarrier cb;
		int[][] matrix;
		int row;

		public CBInnerThread(CyclicBarrier cb, int[][] matrix, int row) {
			super();
			this.cb = cb;
			this.matrix = matrix;
			this.row = row;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(new Random().nextInt(2000));
				p("fill matrix in row=" + row);
				process(matrix, row);
				if (cb.await() == 0) {
					pArr(matrix);
					stop = true;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

		private void process(int[][] matrix2, int row2) {
			for (int i = 0; i < matrix2[0].length; i++) {
				matrix[row2][i] = i;
			}
		}

		private void pArr(int[][] matrix) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					System.out.print(matrix[i][j] + ",");
				}
				System.out.println();
			}
		}
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
