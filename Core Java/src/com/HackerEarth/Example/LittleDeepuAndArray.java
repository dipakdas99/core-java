package com.HackerEarth.Example;

import java.util.Scanner;

public class LittleDeepuAndArray {
	int[] st;
	public LittleDeepuAndArray(int n) {
		st = new int[n];
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		LittleDeepuAndArray st = new LittleDeepuAndArray(n);
		int arr[]=new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=s.nextInt();
		}
		st.constructST(arr, arr.length);
		int input = s.nextInt();
		for (int i = 0; i < input; i++){
			int index = s.nextInt();
			st.decrementByOne(n, index, n);
		}
	}

	private void decrementByOne(int n, int us, int ue) {
		if (us < 0 || ue >= n)
			return;
		
		decrementByOneUtil(0, 0, n-1, us, ue);
	}

	private void decrementByOneUtil(int ss, int se, int n, int us, int ue) {
		
	}

	private void constructST(int[] arr, int n) {
		constructSTUtil(arr, 0, n-1, 0);
	}

	private void constructSTUtil(int[] arr, int ss, int se, int si) {
		if (ss > se)
			return;
		if (se == ss){
			st[si] = arr[ss];
			return;
		}
		int mid = (ss+se)/2;
		constructSTUtil(arr, ss, mid, 2*si+1);
		constructSTUtil(arr, mid+1, se, 2*si+2);
	}
}
