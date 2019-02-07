package com.mathemetics;

import java.util.Scanner;

public class FactorialOfAnumber {
	private static long printFactorial(int n){
		if (n <= 1)
			return 1;
		return n * printFactorial(n-1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfInput = sc.nextInt();
		for (int i = 0; i < noOfInput; i++){
			int n = sc.nextInt();
			long result = printFactorial(n);
			System.out.println(result);
		}
	}

}
