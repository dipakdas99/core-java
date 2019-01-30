package com.mathemetics;

import java.util.Scanner;

public class ReverseDigits {
	private static String doReverse(int n){
		String s = "";
		int d = 0;
		while (n > 0){
			d = n%10;
			s +=d;
			n = n/10;
		}
		s = s.replaceFirst("^0*", "");
		return s;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfInput = sc.nextInt();
		for (int i = 0; i < noOfInput; i++){
			int n = sc.nextInt();
			String result = doReverse(n);
			System.out.println(result);
		}
	}

}
