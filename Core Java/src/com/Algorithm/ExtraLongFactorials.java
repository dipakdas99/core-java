package com.Algorithm;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
	static void extraLongFactorials(int n) {
		BigInteger result = new BigInteger("1");
		for (int i = 2; i <= n; i++){
			result = result.multiply(BigInteger.valueOf(i)); 
		}
		System.out.println(result);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
