package com.Algorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryption {
	static String encryption(String s) {
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		int post = (int) Math.ceil(Math.sqrt(len));
		for (int i = 0; i < Math.sqrt(len); i++){
			int n = i;
			while (n < len){
				sb.append(s.charAt(n));
				n = n+post;
			}
			sb.append(" ");
		}
		return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        String result = encryption(s);
        System.out.println(result);

        scanner.close();
    }
}
