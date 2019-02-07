package com.mathemetics;

import java.util.Scanner;

public class PrintTheKthDigit {
	private static void findKthDigit(int a, int b, int k){
		long e = 0;
		long pow =(long) Math.pow(a, b);
		for(int i=1;i<=k;i++)
		{
			e=0;
			e=pow%10;
			pow=pow/10;
		}
		System.out.println(e);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfInput = sc.nextInt();
		for (int i = 0; i < noOfInput; i++){
			int A = sc.nextInt();
			int B = sc.nextInt();
			int K = sc.nextInt();
			findKthDigit(A,B,K);
		}
	}

}
