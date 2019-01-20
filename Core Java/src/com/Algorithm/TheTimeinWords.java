package com.Algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TheTimeinWords {
	static String timeInWords(int h, int m) {
		Map<Integer, String> hmap = new HashMap<Integer,String>();
		hmap.put(1, "one");
		hmap.put(2, "two");
		hmap.put(3, "three");
		hmap.put(4, "four");
		hmap.put(5, "five");
		hmap.put(6, "six");
		hmap.put(7, "seven");
		hmap.put(8, "eight");
		hmap.put(9, "nine");
		
		hmap.put(10, "ten");
		hmap.put(11, "eleven");
		hmap.put(12, "tweleve");
		hmap.put(13, "thirteen");
		hmap.put(14, "fourteen");
		hmap.put(15, "quater");
		hmap.put(16, "sixteen");
		hmap.put(17, "seventeen");
		hmap.put(18, "eighteen");
		hmap.put(19, "nineteen");
		hmap.put(20, "Tweenty");
		hmap.put(30, "half");
		if (hmap.containsKey(h)){
			System.out.println(hmap.get(h));
		}
		return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);
        System.out.println(result);
        scanner.close();
    }

}
