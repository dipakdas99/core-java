package com.mathemetics;

import java.util.Scanner;

public class BinaryNumberToDecimalNumber {
	private static int convertToDecimal(String n){
		int len = n.length();
		int base = 1, dec = 0;
		for (int i = len-1; i >= 0; i--){
			if (n.charAt(i) == '1'){
				dec = dec + base;
			}
			base = base * 2;
		}
		return dec;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfInput = sc.nextInt();
		for (int i = 0; i < noOfInput; i++){
			String n = sc.next();
			int result = convertToDecimal(n);
			System.out.println(result);
		}
	}

}
