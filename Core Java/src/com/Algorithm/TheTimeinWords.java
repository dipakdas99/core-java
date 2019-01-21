package com.Algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TheTimeinWords {
	static String timeInWords(int h, int m) {
		Map<Integer, String> hmap = new HashMap<Integer,String>();
		String time = "";
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
		hmap.put(12, "twelve"); 
		hmap.put(13, "thirteen");
		hmap.put(14, "fourteen");
		hmap.put(15, "quarter");
		hmap.put(16, "sixteen");
		hmap.put(17, "seventeen");
		hmap.put(18, "eighteen");
		hmap.put(19, "nineteen");
		hmap.put(20, "twenty");
		hmap.put(30, "half");
			if (m > 0 && m <= 30){
				if (m == 15 || m == 30)
					time = hmap.get(m)+" past "+ hmap.get(h);
				else if (m > 20 && m < 30){
					for (int i = 1; i < 10; i++){
						int minutes = 20 + i;
						if (m == minutes){
							time = hmap.get(20)+" "+hmap.get(i)+" minutes past "+ hmap.get(h);
							break;
						}
					}
				}
				else if (m == 1)
					time = hmap.get(m)+" minute past "+ hmap.get(h);
				else	
					time = hmap.get(m)+" minutes past "+ hmap.get(h);
			}
			else if(m > 30 && m <= 60) {
				int minutes = 60 - m;
				if (minutes == 15 || minutes == 30)
					time = hmap.get(minutes)+" to "+ hmap.get(h+1);
				else if (minutes > 20 && minutes < 30){
					for (int i = 1; i < 10; i++){
						int minute = 20 + i;
						if (minutes == minute){
							time = hmap.get(20)+" "+hmap.get(i)+" minutes to "+ hmap.get(h+1);
							break;
						}
					}
				}
				else
					time = hmap.get(minutes)+" minutes to "+ hmap.get(h+1);
			}
			else{
				time = hmap.get(h)+" o' clock";
			}
			
		return time;
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
