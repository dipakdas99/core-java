package com.mathemetics;

import java.util.Scanner;

public class ArmstrongNumber {
	private static boolean checkArmstrong(int n){
		int sum = 0, d;
		int temp = n;
		while (n > 0){
			d = n % 10;
//			System.out.println(Math.pow(2, 3));
			sum = (int) (sum + Math.pow(d, 3));
			n = n/10;
		}
		if (temp == sum)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfInput = sc.nextInt();
		for (int i = 0; i < noOfInput; i++){
			int n = sc.nextInt();
			if (checkArmstrong(n)){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}

}
