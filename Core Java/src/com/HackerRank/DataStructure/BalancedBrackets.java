package com.HackerRank.DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	static boolean isBalanced(char character1,char character2) {
		if (character1 == '(' && character2 == ')') 
	         return true; 
	       else if (character1 == '{' && character2 == '}') 
	         return true; 
	       else if (character1 == '[' && character2 == ']') 
	         return true; 
	       else
	         return false; 
	}
	static boolean areParenthesisBalanced(char exp[]) 
	{ 
		Stack<Character> st = new Stack<Character>();
		for(int i=0;i<exp.length;i++) 
		{ 
			if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[') 
				st.push(exp[i]); 
			if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') 
			{ 
				if (st.isEmpty()) 
					return false; 
				else if ( !isBalanced(st.pop(), exp[i]) ) 
					return false; 
			} 
		} 
		if (st.isEmpty()) 
			return true; 
		else
			return false; 
	} 
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
		int t = scanner.nextInt();
		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.next();
			if (areParenthesisBalanced(s.toCharArray())) 
				System.out.println("YES"); 
			else
				System.out.println("NO"); 
		}

		scanner.close();
	}
}
