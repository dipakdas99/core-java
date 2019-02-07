package com.HackerRank.DataStructure;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
	static Stack<Long> s1 = new Stack<Long>();
	static Stack<Long> s2 = new Stack<Long>();
	private static void enqueue(Long data) {
		s1.push(data);
	}
	private static void dequeue() {
		if(s2.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}  
		s2.pop();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		Long noOfInput = sc.nextLong();
		for (int i = 0; i < noOfInput; i++){
			Long query = sc.nextLong();
			if (query == 1){
				Long data = sc.nextLong();
				enqueue(data);
			}
			else if (query == 2){
				dequeue();
			}
			else if (query == 3){
				if(s2.isEmpty()) {
					while(!s1.isEmpty()) {
						s2.push(s1.pop());
					}
				}
				System.out.println(s2.peek()); 
			}
		}
	}
}
