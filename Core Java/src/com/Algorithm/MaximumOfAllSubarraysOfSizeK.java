package com.Array;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumOfAllSubarraysOfSizeK {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int k = 3;
		int n = arr.length;
		printMaxOfSubArray(arr, k, n);
	}

	private static void printMaxOfSubArray(int[] arr, int k, int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		int count = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++){
			q.offer(arr[i]);
			max = Math.max(max, arr[i]);
			count++;
			if (count == k){
				System.out.print(max+" ");
				count = 0;
				int ele = q.remove();
			}
		}
	}
}
