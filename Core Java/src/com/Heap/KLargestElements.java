package com.Heap;

import java.util.Arrays;

public class KLargestElements {
	private static void findKthLargestElements(int[] arr, int n, int k){
		Arrays.sort(arr);
		for (int i = n-1; i >=(n-k); i--){
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		int arr[]={12, 5, 787, 1, 23};
		int n = arr.length;
		int k = 2;
		
		findKthLargestElements(arr,n,k);
	}

}
