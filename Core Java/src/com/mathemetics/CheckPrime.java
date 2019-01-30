package com.mathemetics;

import java.util.Scanner;

public class CheckPrime {
	private static void checkPrime(int n){
		boolean flag = false;
		if (n == 0 || n== 1)
			flag = true;
		for (int i = 2; i <= Math.sqrt(n); i++){
			if (n%i == 0){
				flag = true;
			}
		}
		if (flag)
			System.out.println("No");
		else
			System.out.println("Yes");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfInput = sc.nextInt();
		for (int  i = 0; i < noOfInput; i++){
			int n = sc.nextInt();
			checkPrime(n);
		}
	}

}
