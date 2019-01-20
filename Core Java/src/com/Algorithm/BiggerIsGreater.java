package com.Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BiggerIsGreater {
	
	static String biggerIsGreater(String s) {
		int i;
		String a ="";
		int flag = 0, x = 0;
		for(i = 1;i<=s.length();i++) {
			a = s.substring(s.length() - i);
			for(x = a.length()-1;x>0;x--) {
				if(a.charAt(0)<a.charAt(x)) {
					flag = 1;
					break;
				}
				if(flag == 1)
					break;
			}
			if(flag == 1)
				break;
		}
		if(flag == 1){
			String temp = a.substring(0,x)+a.substring(x+1);
			char c[] = temp.toCharArray();
			Arrays.sort(c);
			temp = a.charAt(x) + new String(c);
			String ans = s.substring(0,s.length()-i)+temp;
			return ans;
		}
		return "no answer";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int T = scanner.nextInt();

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.next();

            String result = biggerIsGreater(w);
            System.out.println(result);
        }


        scanner.close();
    }

}
