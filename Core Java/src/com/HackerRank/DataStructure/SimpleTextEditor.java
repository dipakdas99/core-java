package com.HackerRank.DataStructure;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
	/*static String prev = null;
	static LinkedList<Object> list = new LinkedList<Object>();
	static Stack<Object> st = new Stack<Object>();
	public static void append(String new_data){
		for (int i = 0; i < new_data.length(); i++){
			list.addLast(new_data.charAt(i));
		}
		if (st.isEmpty())
			st.push(new_data);
	}
	public static void deleteNode(int data){
		int size = list.size();
		for (int i = (list.size() - data); i < size; i++){
			list.remove(size - data);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0;i < list.size();i++){
			sb.append(list.get(i));
		}
		st.push(sb);
	}
	public static void printNode(int data){
		System.out.println(list.get(data-1).toString());
	}
	public static void undo(){
		list.clear();
		String element = st.pop().toString();
		for (int i = 0; i < element.length(); i++){
			list.add(element.charAt(i));
		}

	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int noOfInput = scanner.nextInt();
		for (int itr = 0; itr < noOfInput; itr++){
			int input = scanner.nextInt();
			if (input == 1){
				String data = scanner.next();
				append(data);
			}else if(input == 2){
				int data = scanner.nextInt();
				deleteNode(data);
			}else if(input == 3){
				int data = scanner.nextInt();
				printNode(data);
			}else{
				undo();
			}
		}
	}*/
	public static void main(String[] args) {

		String word="";
		Stack<String> temporary = new Stack<String>();

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		int Q = scan.nextInt();

		for(int j=1;j<=Q;j++)
		{
			int type = scan.nextInt();
			if(type==1)
			{
				String input = scan.next(); 
				temporary.push(word);
				word = word+input;
			}
			else if(type==2)
			{
				int k = scan.nextInt();
				temporary.push(word);
				word = word.substring(0,word.length()-k);
			}
			else if(type==3)
			{
				int k = scan.nextInt();
				System.out.println(word.charAt(k-1));
			}
			else if(type==4)
			{
				word = (String)temporary.peek();  
				temporary.pop();
			}
		}
	}
}
