package com.mathemetics;
import java.util.Scanner;
public class ClosestNumber {
	private static int findCloset(int n, int m, int r){
		if (n % r == 0 && m % r == 0) {
			if (Math.abs(n) > Math.abs(m))
				return n;
			else
				return m;
		} else if (n % r == 0 || m % r == 0) {
			return ((n % r == 0) ? n : m);
		}

		int re = findCloset(n - 1, m + 1, r);

		return re;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfInput = sc.nextInt();
		for (int i = 0; i < noOfInput; i++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			int result = findCloset(N,N,M);
			System.out.println(result);
		}
	}

}
