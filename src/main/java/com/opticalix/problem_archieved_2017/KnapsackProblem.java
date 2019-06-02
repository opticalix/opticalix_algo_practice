package com.opticalix.problem_archieved_2017;

public class KnapsackProblem {

	private int[] values;
	private int[] weights;
	private int[][] result;//result
	private int packWeightLimit;

	public KnapsackProblem(int itemCnt, int packWeightLimit, int[] v, int[] w) {
		values = new int[itemCnt + 1];
		weights = new int[itemCnt + 1];
		result = new int[itemCnt + 1][packWeightLimit + 1];
		this.packWeightLimit = packWeightLimit;
		for (int i = 0; i < itemCnt + 1; i++) {
			this.values[i] = v[i];
			this.weights[i] = w[i];
		}
	}

	/**
	 * 存在重叠子问题，所以从最小的子问题开始递推，并将结果保存在矩阵
	 */
	public void solve() {
		for (int i = 1; i < values.length; i++) {
			for (int k = 1; k <= packWeightLimit; k++) {//try different available weight
				if (weights[i] <= k) {//并不是步骤递推，而是规模是i-1的子问题最优解到规模i的最优解
					if (values[i] + result[i - 1][k - weights[i]] > result[i - 1][k])
						result[i][k] = values[i] + result[i - 1][k - weights[i]];
					else
						result[i][k] = result[i - 1][k];
				} else
					result[i][k] = result[i - 1][k];
			}
		}
	}

	public void printAllResult() {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j <= packWeightLimit; j++)
				System.out.print(result[i][j] + " ");
			System.out.println();
		}
	}
	public void printResult() {
		System.out.print(result[values.length-1][packWeightLimit]);
	}

	public static void main(String[] args) {
		int[] v = { 0, 60, 100, 120 };
		int[] w = { 0, 20, 20, 30 };
		int weight = 30;
		KnapsackProblem knapsack = new KnapsackProblem(3, weight, v, w);
		knapsack.solve();
		knapsack.printResult();
	}

}
