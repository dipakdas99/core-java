package com.mathemetics;
import java.util.Scanner;
public class GCD {
	private static void findGCD(int a, int b){
		int gcd = 1;
		for (int i = 1; i <= a && i <= b; i++){
			if (a % i == 0 && b % i == 0)
				gcd = i;
		}
		int lcm = (a * b) / gcd;
		System.out.println(gcd+" "+lcm);
	}
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int NoOfInput = sc.nextInt();
		for (int i = 0; i < NoOfInput; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			findGCD(a,b);
		}
	}
}
