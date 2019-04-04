package com.tree;

public class SegmentTree {
	int[] st;
	SegmentTree(int[] arr, int n){
		int x = (int)(Math.ceil(Math.log(n)/ Math.log(2)));
		int max_size = 2 * (int) Math.pow(2, x)- 1;
		st = new int[max_size];
		constractSegmentTree(arr, 0, n-1, 0);
	}
	
	private int constractSegmentTree(int[] arr, int start, int end, int k) {
		if (start == end){
			st[k] = arr[start] ;
			return arr[start];
		}else{
			int mid = getMidElement(start, end);
			st[k] = constractSegmentTree(arr, start, mid, 2*k + 1) + constractSegmentTree(arr, mid+1, end,  2*k+2);
			return st[k];
		}
	}

	private int getMidElement(int start, int end) {
		return start + (end-start) / 2;
	}

	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 7, 9, 11};
		int n = arr.length;
		SegmentTree tree = new SegmentTree(arr, n);
		System.out.println("Sum of values in given range = " + tree.getSum(n, 1, 3)); 
		tree.updateValue(arr, n, 1, 10); 
		System.out.println("Sum of values in given range = " + tree.getSum(n, 1, 3));
	}

	private void updateValue(int[] arr, int n, int i, int new_val) {
		if (i < 0 || i > n-1)
			return;
		int diff = new_val - arr[i];
		arr[i] = new_val;
		updateValueUtil(0, n-1, i, diff, 0);
	}

	private void updateValueUtil(int ss, int se, int i, int diff, int k) {
		if (ss > i || se < i)
			return;
		st[k] = st[k] + diff;
		if (ss != se){
			int mid = getMidElement(ss, se);
			updateValueUtil(ss, mid, i, diff, 2*k+1);
			updateValueUtil(mid+1, se, i, diff, 2*k+2);
		}
	}

	private int getSum(int n, int start, int end) {
		if (start < 0 || end > n-1 || start > end)
			return -1;
		return getSumUtil(0, n-1, start, end, 0);
	}

	private int getSumUtil(int i, int j, int start, int end, int k) {
		if (start <= i && end >= j )
			return st[k];
		if (j < start || i > end)
			return 0;
		int mid = getMidElement(i, j);
		
		return getSumUtil(i, mid, start, end, 2*k+1)+getSumUtil(mid+1, j, start, end, 2*k+2);
	}

}
