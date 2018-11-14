package com.BST;

import java.util.Scanner;

public class UniqueBST {

	private static int findUniqueBST(int n){
		// Calculate value of 2nCn 
		int c = binomialCoeff(2 * n, n); 

		// return 2nCn/(n+1) 
		return c / (n + 1); 
	}

	static int binomialCoeff(int n, int k) 
	{ 
		int res = 1; 
		// Since C(n, k) = C(n, n-k) 
		if (k > n - k) 
			k = n - k; 
		// Calculate value of  
		for (int i = 0; i < k; ++i) 
		{ 
			res *= (n - i); 
			res /= (i + 1); 
		} 
		return res; 
	} 


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		System.out.println("Enter a number");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			result = findUniqueBST(input);
			System.out.println(result);
		}
		
		
	}

}
