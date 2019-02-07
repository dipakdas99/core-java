package com.mathemetics;

import java.util.Scanner;

public class Paalindrome {
	private static boolean checkPalindrome(int n){
		int rev = 0, d = 0, sum = 0;
		String str = Integer.toString(n);
		String splitStr[] = str.split("");
//		System.out.println(splitStr[0]);
		for (int i = 0; i < splitStr.length; i++){
			sum += Integer.parseInt(splitStr[i]);
		}
		n = sum;
		int temp = n;
		while (n > 0){
			d = n % 10;
			rev = rev * 10 + d;
			n = n / 10;
		}
		if (temp == rev)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfInput = sc.nextInt();
		for (int i = 0; i < noOfInput; i++){
			int n = sc.nextInt();
			if (checkPalindrome(n)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

}
