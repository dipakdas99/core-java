package com.mathemetics;

import java.util.Scanner;

public class ArrayOfGCD {
	public static void findGCD(int[] arr, int n){
		int result = arr[0];
		for (int i = 1; i < n; i++){
			result = gcd(arr[i],result);
		}
		System.out.println(result);
	}
	private static int gcd(int n1, int n2) {
		if (n1 == 0)
			return n2;
		
		return gcd(n2%n1,n1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfInput = sc.nextInt();
		for (int j = 0; j < noOfInput; j++){
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++){
				arr[i] = sc.nextInt();
			}
			findGCD(arr,n);
		}
	}

}
