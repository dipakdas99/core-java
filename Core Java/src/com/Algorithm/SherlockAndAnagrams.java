package com.Algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SherlockAndAnagrams {
	//abba
	static int sherlockAndAnagrams(String str) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

	    int totalCount = 0;

	    for(int i = 0 ; i < str.length(); i++)
	    {
	        for(int j=i+1 ; j <= str.length(); j++)
	        {
	            String currentSubString = str.substring(i,j);

	            char[] chars = currentSubString.toCharArray();
	            Arrays.sort(chars);
	            currentSubString = String.valueOf(chars);

	            if(map.containsKey(currentSubString)) 
	            {
	                int value = map.get(currentSubString);
	                totalCount=totalCount+value;

	                map.put(currentSubString, value+1);
	            } 
	            else 
	            {
	                map.put(currentSubString, 1);
	            }
	        }
	    }
	    return totalCount;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);
        }

        scanner.close();
    }

}
