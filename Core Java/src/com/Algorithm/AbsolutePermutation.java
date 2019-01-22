package com.Algorithm;

import java.util.Scanner;

public class AbsolutePermutation {
	static int[] absolutePermutation(int n, int k) {
		String s = "";
		for (int i = 1; i <= n; i++){
			s += i;
		}
		int[] res = doPermutation(s, 0, s.length(), k);
		
		return res;
    }

    private static int[] doPermutation(String s, int low, int high, int k) {
    	int count = 0;
    	if (low == high){ 
    		int result[] = new int[s.length()];
    		for (int i = 1; i <= s.length(); i++){
    			int val = Character.getNumericValue(s.charAt(i-1));
    			if ((val - i) == k){
    				result[i-1] = val;
    				count++;
    			}
    		}
    		if (count == s.length())
    			return result;
    	}
        else { 
            for (int i = low; i <= high; i++) { 
                s = swap(s, low, i, k); 
                doPermutation(s, low + 1, high, k); 
                s = swap(s, low, i, k); 
            } 
        } 
		return new int[]{-1};
	}

	private static String swap(String s, int i, int j, int k) {
		char temp; 
		char[] charArray = s.toCharArray(); 
		temp = charArray[i]; 
		charArray[i] = charArray[j]; 
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
//            String[] nk = scanner.nextLine().split(" ");

            int n = scanner.nextInt();

            int k = scanner.nextInt();

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
               System.out.println(result[i]);
            }

        }
        scanner.close();
    }
}
