package com.test.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
public class MergeKSortedArrays {
	public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
    {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		ArrayList<Integer> sortElements = new ArrayList<Integer>();
		for (int i = 0; i < k; i++){
			for (int j = 0; j < k; j++){
				minHeap.offer(arrays[i][j]);
			}
		}
		while (!minHeap.isEmpty())
			sortElements.add(minHeap.poll());
		
		return sortElements;
    }
	public static void main(String[] args) {
		int arr[] [] ={{1, 2, 3},
					   {4, 5, 6},
					   {7, 8, 9}};
		int k = 3;
		ArrayList<Integer> list = mergeKArrays(arr, k);
		for (Integer data : list){
			System.out.print(data+" ");
		}
	}

}
