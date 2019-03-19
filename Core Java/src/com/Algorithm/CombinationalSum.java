package com.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum {
	
	public static void main(String[] args) {
		int arr[] = {2, 2, 4, 6, 8};
		int x = 8;
		
		List<List<Integer>> result = findUniqueCombination(arr, x);
		System.out.println(result);
	}

	private static List<List<Integer>> findUniqueCombination(int[] arr, int x) {
		Arrays.sort(arr);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> r = new ArrayList<Integer>();
		findUniqueCombinationUtill(arr, x, res, r, 0);
		return res;
	}

	private static void findUniqueCombinationUtill(int[] arr, int x,
			List<List<Integer>> res, List<Integer> r, int i) {
		if (x < 0)
			return;
		if (x == 0){
			res.add(r);
			return;
		}
		 while (i < arr.length && x - arr[i] >= 0) 
		    { 
		  
		        // Till every element in the array starting 
		        // from i which can contribute to the sum 
		        r.add(arr[i]); // add them to list 
		  
		        // recur for next numbers 
		        findUniqueCombinationUtill(arr, x - arr[i], res, r, i); 
		        i++; 
		  
		        // remove number from list (backtracking) 
		        r.remove(i);
		    } 
	}
}
