package com.mathemetics;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JumpingNumbers {
	static List<Integer> list = new LinkedList<Integer>();
	private static void printJumpingNumber(int n){
		for (int i = 1; i <= 9 && i <= n; i++){
			findJumpingNumber(n,i);
		}
	}

	private static void findJumpingNumber(int n, int i) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		while (!q.isEmpty()){
			i = q.peek();
			q.poll();
			if (i <= n) 
			{ 
//				System.out.print(i+" ");
				list.add(i);
				
				int last_dig = i % 10; 

				// If last digit is 0, append next digit only 
				if (last_dig == 0) 
					q.add((i*10) + (last_dig+1)); 

				// If last digit is 9, append previous digit only 
				else if (last_dig == 9) 
					q.add( (i*10) + (last_dig-1) ); 

				// If last digit is neither 0 nor 9, append both 
				// previous and next digits 
				else
				{ 
					q.add((i*10) + (last_dig-1)); 
					q.add((i*10) + (last_dig+1)); 
				} 
			} 
		}
	}

	public static void main(String[] args) {
		int n = 1000041;
		list.add(0);
		printJumpingNumber(n);
		Collections.sort(list);
		for (Integer l : list)
			System.out.print(l+" ");
		list.clear();
	}
}
