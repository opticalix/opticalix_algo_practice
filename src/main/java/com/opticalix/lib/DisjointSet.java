package com.opticalix.lib;

/**
 * UnionFindSet 所有元素初始应为独立分组，鉴于此性质用数组表示更合适，保存其父的index，初始为-1表示无父亲 
 * Ref: 
 * http://www.cnblogs.com/hapjin/p/5478352.html
 * http://www.cnblogs.com/archimedes/archive/2014/06/10/disjoint-set.html
 * 
 * 路径压缩两种方法：
 * 1.find时巧妙递归
 * 2.union时先找出根，再沿路径将所有元素的父更新为该根
 * @author opticalix
 *
 */
public class DisjointSet {

	private int[] s;
	private int groupCnt;// 子集合个数

	public DisjointSet(int n) {
		super();
		s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = -1;
		}
		groupCnt = n;
	}

	/**
	 * 将两个元素合并为一组，返回该组的根
	 * 
	 * @param x
	 *            序号
	 * @param y
	 *            序号
	 * @return 序号
	 */
	public void union(int x, int y) {
		int x_root = find(x);
		int y_root = find(y);
		if (x_root == y_root) {
			return;// already same group
		}
		//optimize
		s[y_root] = x_root;
		groupCnt--;
	}

	public void union(String x, String y) {
		union(Integer.valueOf(x), Integer.valueOf(y));
	}

	/**
	 * 找到给定元素的根
	 * 
	 * @param t
	 *            序号
	 * @return 序号
	 */
	public int find(int t) {
		// return s[t] == -1 ? t : find(s[t]);

		// 多一步赋值 就能将find路径上的所有节点直接上接至‘根’，即路径压缩
		return s[t] == -1 ? t : (s[t] = find(s[t]));
	}

	public int getGroupCnt() {
		return groupCnt;
	}

}
