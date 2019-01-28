package com.Algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class SherlockAndTheValidString {
	static String isValid(String s) {
		String ans = "YES";
		HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++){
			if (!hmap.containsKey(ch[i])){
				hmap.put(ch[i], 1);
			}else{
				hmap.put(ch[i], hmap.get(ch[i])+1);
			}
		}
		int prev = hmap.get(ch[0]), count = 0;
		for (Integer value : hmap.values()){
			if (prev != value){
				count++;
			}
		}
		if (count > 1){
			ans = "NO";
			return ans;
		}
		return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        String result = isValid(s);
        System.out.println(result);

        scanner.close();
    }
}
