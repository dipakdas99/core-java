package com.Algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class NonDivisibleSubset {
	static int nonDivisibleSubset(int K, int[] arr) {
		 int f[] = new int[K]; 
	        Arrays.fill(f, 0); 
	      
	        // Fill frequency array with values modulo K 
	        for (int i = 0; i < arr.length; i++) 
	            f[arr[i] % K]++; 
	      
	        // if K is even, then update f[K/2] 
	        if (K % 2 == 0) 
	            f[K/2] = Math.min(f[K/2], 1);
	        int res = Math.min(f[0], 1); 
	        
	        // Choose maximum of count of numbers 
	        // giving remainder i or K-i 
	        for (int i = 1; i <= K/2; i++) 
	            res += Math.max(f[i], f[K-i]); 
	      
	        return res; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);
        System.out.println(result);
        scanner.close();
    }
}
