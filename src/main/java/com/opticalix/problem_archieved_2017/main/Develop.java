package com.opticalix.problem_archieved_2017.main;

import com.opticalix.lib.DisjointSet;
import com.opticalix.lib.Graph;
import com.opticalix.lib.MyCollections;
import com.opticalix.lib.Utils;
import com.opticalix.model.Cat;
import com.opticalix.model.Pet;
import com.opticalix.lib.TreeNode;
import com.opticalix.problem.BasicDS;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * 2017刷题的main类
 */
@SuppressWarnings("unused")
public class Develop {

	/**
	 * Important tool bufferedReader+ISR, strTokenizer
	 * 
	 * @author opticalix
	 *
	 */
	public static class Reader {
		private StringTokenizer tokenizer;
		private BufferedReader reader;

		public Reader() {
			tokenizer = new StringTokenizer("");
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nextToken() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public String nextLine() throws IOException {
			if (tokenizer.hasMoreTokens())
				throw new RuntimeException("has unread token");
			return reader.readLine();
		}

		public int nextInt() throws IOException {
			String token = nextToken();
			return Integer.valueOf(token);
		}
	}

	private static Scanner scanner;
	
	private static class TestParent{
		void throwEx() throws IOException{
			
		}
	}

	public static void main(String[] args) throws IOException {

		scanner = new Scanner(System.in);
		int[] toSortArray = new int[]{4,2,6,8,5,32,1};
		// judgeTriangle();
		// getMax();
		// primeNum();
		// chickenQuestion();
		// delChar();
		// ab();
		// pre_post();
		// coincidence();
		// sameSortTree();
		// largestSequence();
		// huffman();
		// findKthMin();
		// compareEvenOdd();
		// wrapArrayRotate();
		// intersectionOfTwoArrayUsingSet(new int[]{5,3,2,1,1}, new
		// int[]{5,4,1});
		// problem1177();
		// problem1178();
		// p1010();
		// p1012();
		// testgraph();
		// testMath();
		// testCollection();
		// testLIS(new int[]{1, 7, 3, 5, 9, 4, 8});
		// testFibonacci(100);
		// testPrint(new FileInputStream(new
		// File("/Users/opticalix/Documents/Work/tmp/long_text.txt")));
		// testToken();
		// testScanner();
		// testInPerformance(new FileInputStream(new
		// File("/Users/opticalix/Documents/Work/tmp/long_text.txt")));
//		testUtils();
//		testSortTree();
//		func_count_one('C');
//		testBubbleSort(toSortArray);
//		testMergeSort(toSortArray);
//		testAutoBox();
//		testLogicAnd();
//		testConstructor();
//		testMethodParam();
//		testClone();
		testCatch();
		scanner.close();
		System.exit(0);

	}
	
	static class Annoyance extends Exception {}
	static class Sneeze extends Annoyance {}

	
	private static void throwMethod() throws IllegalAccessException, InterruptedException{
		Object o = new Object();
        synchronized(o){
        	
        }
        Thread thread = new Thread();
        thread.join();
	}
	private static void testCatch() {
//		new TestParent(){
//			@Override
//			void throwEx() throws EOFException {
//				
//			}
//		};
//		
//		try {
//			throwMethod();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
		
        try {
            try {
                throw new Sneeze();
            } 
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } 
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
        
	}

	private static void testClone() {
		Pet pet = new Pet();
		p(pet);
	}

	private static void testMethodParam() {
		Pet pet = new Pet(1, 10);
		p(pet);
		func1(pet);
		p(pet);
	}
	private static void func1(Pet p){
		p.age++;
	}

	private static void testConstructor() {
		Pet pet = new Pet();
		p("--");
		Cat cat = new Cat();
	}

	private static void testLogicAnd() {
		boolean a=false;
		boolean b=true;
		boolean c=true;
		int cnt=0;
		p((a&&(++cnt==1)));//&&的话若只靠左侧bool能做决定，就直接略过右边表达式
		p(cnt);
	}

	private static void testAutoBox() {
		int a=1;
		Integer b=1;
		Integer c = new Integer(1);
		p(a==b);
		p(c==b);
		
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
	}

	private static void testMergeSort(int[] a) {
		int start=0;
		int end = a.length-1;
		int[] result = new int[a.length];
		mergeSort(a, result, start, end);
		pArr(result);
	}
	
	private static void mergeSort(int[] a, int[] tmp, int start, int end){
		if(start >= end){
			return;
		}
		int mid = (start+end)/2;
		mergeSort(a, tmp, start, mid);
		mergeSort(a, tmp, mid+1, end);
		
		int p=start;
		int q=mid+1;
		int to = start;
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

	private static void testBubbleSort(int[] A) {
		Utils.pArr(A);
		BasicDS.bubbleSort(A, 0, A.length-1);
		Utils.pArr(A);
	}

	private static void func_count_one(char c) {
		int i, j=0;
		for(i=0; i<8; i++){
			j+=((c>>i)&1);
		}
		System.out.print(j);
	}

	private static void testSortTree() {
		TreeNode<Integer> root = new TreeNode<>(5);
		root.l = new TreeNode<>(3);
		root.r = new TreeNode<>(8);
		root.l.l = new TreeNode<>(1);
		
//		TreeNode.preOrderTraversal(root);
		TreeNode.levelOrderTraversal(root);
	}

	private static void testUtils() {
		int[] v = new int[]{1,5,2,4,3};
		BasicDS.qSort2(v, 0, v.length-1);
		Utils.pArr(v);
	}

	private static void testDecimalFormat() {
		NumberFormat formatter = new DecimalFormat("000000");
		String s = formatter.format(-1234.567); // -001235
		System.out.println(s);
		formatter = new DecimalFormat("##");
		s = formatter.format(-1234.567); // -1235
		System.out.println(s);
		s = formatter.format(0); // 0
		System.out.println(s);
		formatter = new DecimalFormat("##00");
		s = formatter.format(0); // 00
		System.out.println(s);

		formatter = new DecimalFormat(".00");
		s = formatter.format(-.567); // -.57
		System.out.println(s);
		formatter = new DecimalFormat("0.00");
		s = formatter.format(-.567); // -0.57
		System.out.println(s);
		formatter = new DecimalFormat("#.#");
		s = formatter.format(-1234.567); // -1234.6
		System.out.println(s);
		formatter = new DecimalFormat("#.######");
		s = formatter.format(-1234.567); // -1234.567
		System.out.println(s);
		formatter = new DecimalFormat(".######");
		s = formatter.format(-1234.567); // -1234.567
		System.out.println(s);
		formatter = new DecimalFormat("#.000000");
		s = formatter.format(-1234.567); // -1234.567000
		System.out.println(s);

		formatter = new DecimalFormat("#,###,###");
		s = formatter.format(-1234.567); // -1,235
		System.out.println(s);
		s = formatter.format(-1234567.890); // -1,234,568
		System.out.println(s);

		// The ; symbol is used to specify an alternate pattern for negative
		// values
		formatter = new DecimalFormat("#;(#) ");
		s = formatter.format(-1234.567); // (1235)
		System.out.println(s);

		// The ' symbol is used to quote literal symbols
		formatter = new DecimalFormat(" '# '# ");
		s = formatter.format(-1234.567); // -#1235
		System.out.println(s);
		formatter = new DecimalFormat(" 'abc '# ");
		s = formatter.format(-1234.567); // - abc 1235
		System.out.println(s);

		formatter = new DecimalFormat("#.##%");
		s = formatter.format(-12.5678987);
		System.out.println(s);
	}

	private static void testgraph() {
		Graph graph = new Graph(5);
		graph.connect(0, 1, 1);
		graph.connect(0, 2, 5);
		graph.connect(1, 4, 2);
		graph.connect(2, 4, 1);
		int[] dist = graph.dijkstra(0);
		int[][] dist2 = graph.floyd();
	}

	private static Pet testContainer(Pet p, int a, List<Pet> pets) {
		// 方法中的基本变量都是局部的，对象是引用即可在方法返回后保留修改
		// collection中的对象是共享的
		// array的对象是可以跨方法共享的
		ArrayList<Pet> list = new ArrayList<Pet>();
		list.add(p);
		p.id = 1;
		a = 2;

		LinkedList<Pet> ll = new LinkedList<>();
		ll.push(pets.get(0));
		ll.pop().age = 111;
		return p;
	}

	private static void p1012() throws IOException {
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.valueOf(st.nextToken());// no such token
			if (n == 0)
				break;
			DisjointSet ds = new DisjointSet(n);
			int m = Integer.valueOf(st.nextToken());
			while (m-- > 0) {
				StringTokenizer innerSt = new StringTokenizer(scanner.nextLine());
				ds.union(Integer.valueOf(innerSt.nextToken()) - 1, Integer.valueOf(innerSt.nextToken()) - 1);
			}
			p(ds.getGroupCnt() - 1);
		}
	}

	private static void p1010() throws IOException {
		String PLUS = "+";
		String EQ = "=";
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			StringTokenizer stringTokenizer = new StringTokenizer(line);
			int result = 0;
			int num = 0;
			while (stringTokenizer.hasMoreTokens()) {
				String token = stringTokenizer.nextToken();
				if (token.equalsIgnoreCase(PLUS)) {
					result = num;
					num = 0;
				} else if (token.equalsIgnoreCase(EQ)) {
					result += num;
				} else {
					num *= 10;
					num += p1010_find_num(token);
				}
			}
			if (result != 0) {
				p(result);
			}
		}
	}

	private static int p1010_find_num(String str) {
		String[] DIC = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		int ret = -1;
		for (int i = 0; i < DIC.length; i++) {
			if (str.equalsIgnoreCase(DIC[i])) {
				ret = i;
				break;
			}
		}
		return ret;
	}

	static interface IProblem1178 {
		void pop();

		void insert(ReIm r);
	}

	/**
	 * using 插入排序
	 * 
	 * @author opticalix
	 *
	 */
	static class Problem1178Impl2 implements IProblem1178 {
		ReIm[] arr = new ReIm[1001];
		int size = 0;// real size

		public Problem1178Impl2() {
			super();
		}

		@Override
		public void pop() {
			if (size == 0) {
				p("empty");
				return;
			}
			p(arr[size - 1]);// toString
			arr[size - 1] = null;
			size--;
			pSize();
		}

		@Override
		public void insert(ReIm r) {
			int p = size - 1;
			while (p >= 0 && arr[p].compareTo(r) < 0) {
				arr[p + 1] = arr[p];
				p--;
			}
			arr[p + 1] = r;
			size++;

			pSize();
		}

		private void pSize() {
			p("SIZE = " + size);
		}
	}

	static class Problem1178Impl implements IProblem1178 {
		PriorityQueue<ReIm> queue;

		public Problem1178Impl() {
			super();
			queue = new PriorityQueue<>();
		}

		public void pop() {
			if (queue.size() == 0) {
				p("empty");
				return;
			}
			ReIm head = queue.poll();
			p(head.toString());
			pSize();
		}

		public void insert(ReIm r) {
			queue.add(r);
			pSize();
		}

		private void pSize() {
			p("SIZE = " + queue.size());
		}

	}

	static class ReIm implements Comparable<ReIm> {
		int re;
		int im;

		public ReIm(int re, int im) {
			super();
			this.re = re;
			this.im = im;
		}

		public ReIm(String str) {
			super();
			// parse
			re = Integer.valueOf(str.substring(0, str.indexOf('+')));
			im = Integer.valueOf(str.substring(str.indexOf('i') + 1));
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + im;
			result = prime * result + re;
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
			ReIm other = (ReIm) obj;
			if (im != other.im)
				return false;
			if (re != other.re)
				return false;
			return true;
		}

		@Override
		public int compareTo(ReIm o) {
			if (this.mode() == o.mode()) {
				return this.im - o.im;
			}
			return o.mode() - this.mode();
		}

		public int mode() {
			return re * re + im * im;
		}

		@Override
		public String toString() {
			return re + "+i" + im;
		}
	}

	private static void problem1178() throws IOException {
		// 1.利用堆，priorityQueue 注意compare方法
		// 2.利用数组 自己维护顺序，或每次pop、insert时再search
		Reader reader = new Reader();
		int n = reader.nextInt();
		IProblem1178 problem1178Container = new Problem1178Impl2();
		while (n-- > 0) {// CMDs number=n
			String reIm = reader.nextToken();
			String cmd = reIm;
			if (cmd.equalsIgnoreCase("POP")) {
				problem1178Container.pop();
			} else if (cmd.equalsIgnoreCase("INSERT")) {
				String num = reader.nextToken();
				problem1178Container.insert(new ReIm(num));
			}
		}
	}

	private static void problem1177() throws IOException {
		Reader reader = new Reader();
		String s = reader.nextLine();
		int cmdNum = reader.nextInt();
		String result = null;
		while (cmdNum-- > 0) {
			result = new String(s);
			String line = reader.nextLine();
			char cmd = line.charAt(0);
			int start = line.charAt(1) - '0';
			int n = line.charAt(2) - '0';
			char[] charArr = result.toCharArray();

			switch (cmd) {
			case '0':// reverse
				int l = start;
				int r = start + n - 1;
				while (l < r) {
					swap(charArr, l, r);
					l++;
					r--;
				}
				break;
			case '1':// replace
				for (int i = start, offset = 0; i < start + n; i++, offset++) {
					charArr[i] = line.charAt(3 + offset);
				}
				break;
			default:
				break;
			}
			s = new String(charArr);// update
			p(s);
		}
	}

	private static void intersectionOfTwoArrayUsingSet(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			set1.add(nums1[i]);
		}
		Set<Integer> set2 = new HashSet<Integer>();
		for (int i = 0; i < nums2.length; i++) {
			set2.add(nums2[i]);
		}
		set1.retainAll(set2);
		int[] retArr = new int[set1.size()];
		Iterator<Integer> iterator = set1.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			retArr[i++] = iterator.next();
		}
		pArr(retArr);
	}

	/**
	 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersectionOfTwoArray(int[] nums1, int[] nums2) {
		int[] longOne;
		int[] shortOne;
		if (nums1.length > nums2.length) {
			longOne = nums1;
			shortOne = nums2;
		} else {
			longOne = nums2;
			shortOne = nums1;
		}
		// sort longOne
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < longOne.length; i++) {
			list.add(longOne[i]);
		}
		Collections.sort(list);

		// bSerach
		List<Integer> retList = new ArrayList<Integer>();
		for (int i = 0; i < shortOne.length; i++) {
			int searchAns = Collections.binarySearch(list, shortOne[i]);
			if (searchAns >= 0) {
				retList.add(longOne[searchAns]);
			}
		}
		int[] retArr = new int[retList.size()];
		for (int i = 0; i < retList.size(); i++) {
			retArr[i] = retList.get(i);
		}
		return retArr;
	}

	private static void testMath() throws IOException {
		// gcd
		Reader reader = new Reader();
		int i1 = reader.nextInt();
		int i2 = reader.nextInt();
		int gcd = gcd(Math.max(i1, i2), Math.min(i1, i2));
		p(gcd);

		// 线段相交
		// 多角形面积
	}

	/**
	 * 欧几里得算法/辗转相除法
	 * 
	 * @param i1
	 * @param i2
	 * @return
	 */
	private static int gcd(int i1, int i2) {
		int tmp;
		while ((tmp = i1 % i2) != 0) {
			i1 = i2;
			i2 = tmp;
		}
		return i2;
	}

	private static void wrapArrayRotate() {
		while (true) {
			try {
				ArrayRotate();
			} catch (Exception e) {
				break;
			}
		}
	}

	/**
	 * middle http://ac.jobdu.com/problem.php?pid=1171
	 * 
	 * @throws IOException
	 */
	private static void ArrayRotate() throws IOException {
		Reader reader = new Reader();

		// read 2-D array
		int[][] A = new int[5][5];
		int[][] tmp = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				A[i][j] = reader.nextInt();
				tmp[i][j] = A[i][j];
			}
		}

		// read command
		String line = reader.nextLine();
		line = line.replaceAll(" ", "");
		int clockwise = line.charAt(0) - '0';// 1-shun 2-ni
		int width = line.charAt(1) - '0';
		int x = line.charAt(2) - '0';
		int y = line.charAt(3) - '0';

		// rotate
		// int[] nums = new int[width * width];

		for (int i = x - 1; i < width; i++) {
			for (int j = y - 1; j < width; j++) {
				if (clockwise == 1) {
					tmp[j][x - 1 + width - i - 1] = A[i][j];
				} else {
					tmp[i][j] = A[j][x - 1 + width - i - 1];
				}
			}
		}
		printTwoDimArray(tmp);

	}

	private static void printTwoDimArray(int[][] tmp) {
		// System.out.print("new array\n");
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[0].length; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * easy http://ac.jobdu.com/problem.php?pid=1169
	 * 
	 * @throws IOException
	 */
	private static void compareEvenOdd() throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int ret = 0;
		for (int i = 0; i < n; i++) {
			if (reader.nextInt() % 2 == 0) {
				ret++;
			} else {
				ret--;
			}
		}
		p(ret > 0 ? "NO" : "YES");
	}

	private static void testCollection() throws IOException {
		Reader reader = new Reader();
		Random random = new Random();
		Pet[] pets = new Pet[reader.nextInt()];
		for (int i = 0; i < pets.length; i++) {
			pets[i] = new Pet(reader.nextInt(), random.nextInt(5));
		}

		// array sort
		Arrays.sort(pets, new Comparator<Pet>() {

			@Override
			public int compare(Pet o1, Pet o2) {
				if (o1.id == o2.id)
					return o1.age - o2.age;
				return o1.id - o2.id;// id为主
			}
		});
		// pArr(pets);

		// array search
		int searchResult = Arrays.binarySearch(pets, new Pet(2, 2));
		if (searchResult > 0)
			p(pets[searchResult]);

		int[] ints = new int[] { 5, 4, 3, 2, 1 };
		p("---bSearch: " + Arrays.binarySearch(ints, 2));

		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.addAll(Arrays.asList(new Integer[] { 2, 3, 4, 5, 6, 7, 8 }));
		p("---myBinarySearch:" + MyCollections.binarySearch(intList, 6));

		// array - list
		List<Pet> petList = Arrays.asList(pets);
		petList.toArray(pets);

		// collections
		Collections.sort(petList);
		Collections.binarySearch(petList, new Pet(2, 2));
		Collections.frequency(petList, null);
		Collections.max(petList);
		Collections.reverse(petList);
		Collections.rotate(petList, 2);

		// treeSet/treeMap 红黑树，高级balance树
		TreeSet<Pet> set = new TreeSet<Pet>();
		set.add(new Pet(2, 2));
		set.add(new Pet(3, 3));
		set.add(new Pet(1, 1));
		set.add(new Pet(3, 4));
		pArr(set.toArray(new Pet[set.size()]));
	}

	/**
	 * http://ac.jobdu.com/problem.php?pid=1174
	 * 
	 * @param n
	 * @throws IOException
	 */
	private static void findKthMin(int n) throws IOException {

		Reader reader = new Reader();
		int[] intArr = new int[n];
		for (int i = 0; i < n; i++) {
			intArr[i] = reader.nextInt();
		}

		// find Kth min. Sort array
		int k = reader.nextInt();
		for (int i = 0; i < k; i++) {
			for (int j = n - 1; j > i; j--) {
				if (intArr[j] < intArr[j - 1]) {
					int tmp = intArr[j];
					intArr[j] = intArr[j - 1];
					intArr[j - 1] = tmp;
				}
			}
			if (i > 0 && intArr[i] == intArr[i - 1]) {
				k++;// extend
			}
		}
		p(intArr[k - 1]);
	}

	/**
	 * 1172
	 * 
	 * @param n
	 * @throws IOException
	 */
	private static void huffman(int n) throws IOException {

		Reader reader = new Reader();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		while (n-- > 0) {
			pq.add(reader.nextInt());
		}

		int ret = 0;
		while (pq.size() > 1) {
			int i1 = pq.poll();
			int i2 = pq.poll();
			ret += i1;
			ret += i2;
			pq.offer(i1 + i2);
		}
		p(ret);
	}

	private static int testLIS(int[] nums) {
		int result = 1;
		int[] maxLen = new int[nums.length];// record
		for (int i = 0; i < nums.length; i++) {
			maxLen[i] = 1;
		}

		for (int i = 1; i < nums.length; i++) {
			int max = 0;
			for (int j = 0; j <= i - 1; j++) {
				if ((nums[j] < nums[i]) && (maxLen[j] > max))// dp
					max = maxLen[j];
			}

			maxLen[i] = max + 1;
			if (maxLen[i] > result)
				result = maxLen[i];
		}

		return result;
	}

	private static void testFibonacci(int n) {
		int num;
		// num = fibonacciRecursively(n);
		num = fibonacci(n);
		p(num);
	}

	private static int fibonacci(int n) {
		int ret = 1;
		if (n < 3) {
			return ret;
		}
		int[] tmp = new int[] { 1, 1 };// first two
		int switchFlag = 0;
		for (int i = 3; i <= n; i++) {
			ret = tmp[0] + tmp[1];
			switchFlag = ++switchFlag % 2;
			tmp[switchFlag] = ret;
		}
		return ret;
	}

	private static int fibonacciRecursively(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			int a, b;
			a = fibonacciRecursively(n - 2);
			b = fibonacciRecursively(n - 1);
			return a + b;
		}
	}

	static class LargestSequenceResult implements Comparable<LargestSequenceResult> {
		public LargestSequenceResult(int start, int end, int largestSum, int[] arr) {
			super();
			this.start = start;
			this.end = end;
			this.largestSum = largestSum;
			this.arr = arr;
		}

		int start;
		int end;
		int largestSum;
		int[] arr;

		@Override
		public String toString() {
			return "LargestSequenceResult [start=" + start + ", end=" + end + ", largestSum=" + largestSum + ", arr="
					+ Arrays.toString(arr) + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(arr);
			result = prime * result + end;
			result = prime * result + largestSum;
			result = prime * result + start;
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
			LargestSequenceResult other = (LargestSequenceResult) obj;
			if (!Arrays.equals(arr, other.arr))
				return false;
			if (end != other.end)
				return false;
			if (largestSum != other.largestSum)
				return false;
			if (start != other.start)
				return false;
			return true;
		}

		@Override
		public int compareTo(LargestSequenceResult o) {
			if (this.largestSum - o.largestSum != 0) {
				return this.largestSum - o.largestSum;
			} else {
				if (this.start - o.start != 0) {
					return -(this.start - o.start);
				} else {
					if (this.end - o.end != 0) {
						return -(this.end - o.end);
					} else {
						return 0;
					}
				}
			}
		}

	}

	/**
	 * http://ac.jobdu.com/problem.php?pid=1011
	 */
	private static void largestSequence() {
		while (scanner.hasNext()) {
			Integer k = Integer.valueOf(scanner.nextLine());
			if (k == 0) {
				break;// exit
			}
			StringTokenizer strTokenizer = new StringTokenizer(scanner.nextLine());
			int[] intArr = new int[k];
			for (int i = 0; i < k; i++) {
				intArr[i] = Integer.valueOf(strTokenizer.nextToken());
			}
			LargestSequenceResult lsrt = calcLargestSequence(intArr);
			p(lsrt.largestSum + " " + lsrt.arr[lsrt.start] + " " + lsrt.arr[lsrt.end]);
		}
	}

	private static LargestSequenceResult calcLargestSequence(int[] intArr) {
		ArrayList<LargestSequenceResult> list = new ArrayList<LargestSequenceResult>();
		int sum = 0, maxSum = 0, start = 0, end = intArr.length - 1;// default
		for (int i = 0; i < intArr.length; i++) {
			int num = intArr[i];
			if (num < 0) {
				sum += num;
				if (sum <= 0) {
					// save temple result
					if (maxSum > 0) {
						list.add(new LargestSequenceResult(start, end, maxSum, intArr));
					}
					// give up fore-section
					if (i + 1 < intArr.length) {
						start = i + 1;
						end = intArr.length - 1;
						sum = maxSum = 0;
					}
				}
			} else {
				sum += num;
				if (sum >= maxSum) {
					end = i;
					maxSum = sum;
					list.add(new LargestSequenceResult(start, end, maxSum, intArr));
				}
			}
		}
		if (intArr[start] == intArr[end] && intArr[end] < 0 && maxSum == 0) {
			return new LargestSequenceResult(0, intArr.length - 1, 0, intArr);
		}
		return Collections.max(list);
	}

	private static void testPrint(InputStream in) throws IOException {
		long s = System.currentTimeMillis();

		BufferedReader bfr = new BufferedReader(new InputStreamReader(in));
		PrintWriter pw = new PrintWriter((System.out));
		String line;
		while ((line = bfr.readLine()) != null) {
			pw.println(line);
		}
		pw.flush();

		long e1 = System.currentTimeMillis();
		p("time=" + (e1 - s) / 1000f + "s");
	}

	private static void testToken() {
		StringTokenizer st = new StringTokenizer(scanner.nextLine());
		p(st.countTokens());
		while (st.hasMoreTokens()) {
			p(st.nextToken());
		}
	}

	private static void testScanner() {
		// read line. use flag to break loop.
		// while(scanner.hasNextLine()){
		// String line = scanner.nextLine();
		// p(line);
		// }

		// scanner.useDelimiter(",");
		// while(scanner.hasNextInt()){
		// p(scanner.nextInt());
		// }
	}

	/**
	 * bufferedReader 和 scanner 4-5倍左右的差距
	 * 
	 * @param in
	 * @throws IOException
	 */
	private static void testInPerformance(InputStream in) throws IOException {
		long s = System.currentTimeMillis();

		// BufferedReader bfr = new BufferedReader(new InputStreamReader(in));
		// String line;
		// int n=0;
		// while((line = bfr.readLine()) != null){
		// n+=line.length();
		// }
		// while((n=bfr.read()) != -1){
		//
		// }
		// long e1 = System.currentTimeMillis();
		// p("time="+(e1-s)/1000f+"s");

		// n=0;
		// while(scanner.hasNext()){
		// n+=scanner.nextLine().length();
		// }
		while (scanner.hasNext()) {
			String str = scanner.next();
		}
		long e2 = System.currentTimeMillis();
		p("time=" + (e2 - s) / 1000f + "s");
	}

	/**
	 * http://ac.jobdu.com/problem.php?pid=1009 如何判断一组序列构成的排序树相同 只有0-9 10个数
	 * 极端情况也只需要十层来存储 即1023个节点 令A[0]=size
	 */
	private static void sameSortTree() {
		int[] A = new int[1024];
		int[] B = new int[1024];

		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			scanner.nextLine();
			if (n == 0)
				break;

			// fill A
			String template = scanner.nextLine();
			char[] charArray = template.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				Integer num = Integer.valueOf(charArray[i] - '0');// 小心 char -
																	// integer
				// fillSortTree(A, num, 1);
				insertNumToSortTree(A, num);
			}
			pArr(A);

			// fill B
			while (n-- > 0) {
				Arrays.fill(B, 0);// reset B

				String needJudgeLine = scanner.nextLine();
				charArray = needJudgeLine.toCharArray();
				for (int i = 0; i < charArray.length; i++) {
					Integer num = Integer.valueOf(charArray[i] - '0');// 小心 char
																		// -
																		// integer
					// fillSortTree(B, num, 1);
					insertNumToSortTree(B, num);
				}

				pArr(B);
				// A == B?
				boolean flag = true;
				for (int i = 1; i < A.length; i++) {
					if (A[i] != B[i]) {
						flag = false;
						break;
					}
				}
				p(flag ? "YES" : "NO");
			}
		}
	}

	// iteratively
	private static void insertNumToSortTree(int[] A, int num) {
		int curr = 1;
		while (curr < 512) {
			if (A[curr] == 0) {
				A[curr] = num;
				break;
			}
			if (A[curr] > num) {
				if (A[curr * 2] == 0) {
					A[curr * 2] = num;
					break;
				} else {
					curr *= 2;
				}
			} else {
				if (A[curr * 2 + 1] == 0) {
					A[curr * 2 + 1] = num;
					break;
				} else {
					curr = curr * 2 + 1;
				}
			}
		}
	}

	// recursively
	private static void fillSortTree(int[] A, int num, int pos) {
		if (A[pos] == 0) {
			A[pos] = num;
			return;
		}
		if (num > A[pos]) {
			fillSortTree(A, num, pos * 2 + 1);
		} else {
			fillSortTree(A, num, pos * 2);
		}
	}

	/**
	 * http://ac.jobdu.com/problem.php?pid=1042 找到最长公共子序列 子序列和子串的区别！子串是不能够分割的
	 * TODO 公共子序列用动态规划-http://blog.chinaunix.net/uid-26548237-id-3374211.html
	 */
	private static void coincidence() {
		String l1 = scanner.nextLine();
		String l2 = scanner.nextLine();
		String tmp;
		if (l1.length() < l2.length()) {
			tmp = l1;
			l1 = l2;
			l2 = tmp;// make sure l1 is longer than l2
		}
		p(l1 + "," + l2);

		// 以下是公共子串长度的求法。其实就是蛮力版的模式匹配
		int max = 0;
		int cnt = 0;
		for (int i = 0; i < l1.length(); i++) {
			for (int j = 0; j < l2.length(); j++) {
				if (i + j < l1.length() && l1.charAt(i + j) == l2.charAt(j)) {
					cnt++;
				} else {
					if (cnt > max) {
						max = cnt;
						cnt = 0;
						break;
					}
				}
			}
		}
		p(max);
	}

	/**
	 * http://ac.jobdu.com/problem.php?pid=1044 知道前序和后序 求有多少种中序 ？？
	 */
	private static void pre_post() {

	}

	/**
	 * a+b http://ac.jobdu.com/problem.php?pid=1003 TODO: 如何用pattern直接读出数字
	 */
	public static void ab() {
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String aS = line.substring(0, line.indexOf(" "));
			String bS = line.substring(line.indexOf(" ") + 1, line.length());
			aS = aS.replace(",", "");
			Long aL = Long.valueOf(aS);
			bS = bS.replace(",", "");
			Long bL = Long.valueOf(bS);
			p(aL + bL);
		}
	}

	/**
	 * http://ac.jobdu.com/problem.php?pid=1048
	 */
	public static void judgeTriangle() {
		int i1 = scanner.nextInt();
		int i2 = scanner.nextInt();
		int i3 = scanner.nextInt();

		int max = Math.max(i1, Math.max(i2, i3));
		int min = Math.min(i1, Math.min(i2, i3));
		int mid = i1 + i2 + i3 - max - min;

		int res = max * max - (min * min + mid * mid);
		if (res == 0) {
			System.out.println("直角");
		} else if (res > 0) {
			System.out.println("钝角");
		} else {
			System.out.println("锐角");
		}
	}

	/**
	 * http://ac.jobdu.com/problem.php?pid=1046
	 */
	public static void getMax() {
		while (scanner.hasNext()) {
			// handle one group
			int max = scanner.nextInt();
			for (int i = 1; i < 10; i++) {
				int curr = scanner.nextInt();
				if (curr > max)
					max = curr;// update max
			}
			System.out.println("max=" + max);
		}
	}

	/**
	 * http://ac.jobdu.com/problem.php?pid=1047
	 */
	public static void primeNum() {
		int num = scanner.nextInt();
		if (num <= 1) {
			p("no");
		} else {
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					p("no");
					return;
				}
			}
			p("yes");
		}
	}

	/**
	 * http://ac.jobdu.com/problem.php?pid=1045 x+y+z=100 5x+3y+(1/3)z<=n
	 */
	public static void chickenQuestion() {
		int n = scanner.nextInt();
		int x, y;
		for (x = 0; x <= n / 5; x++) {
			for (y = 0; y <= n / 3; y++) {
				int z = 100 - x - y;
				if (x + y + z == 100 && (5 * x + 3 * y + z / 3f) <= n) {
					p(x + "," + y + "," + z);
				}
			}
		}
	}

	/**
	 * http://ac.jobdu.com/problem.php?pid=1049
	 */
	public static void delChar() {
		String line = scanner.nextLine();
		String c = scanner.nextLine();
		String replace = line.replace(c, "");
		p(replace);
	}

	private static void swap(char[] chArr, int a, int b) {
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

}
