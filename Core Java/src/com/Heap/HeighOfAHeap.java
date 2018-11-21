package com.Heap;
import java.util.Scanner;
public class HeighOfAHeap {
	private int height(int n){
		return (int)Math.ceil(Math.log(n + 	1) / Math.log(2)) - 1; 
	}
	public static void main(String[] args) {
		HeighOfAHeap minHeap = new HeighOfAHeap();
		Scanner sc = new Scanner(System.in);
		int noOfInput = sc.nextInt();
		for (int i = 0; i < noOfInput; i++) {
			int noOfElements = sc.nextInt();
			int arr[] = new int[noOfElements];
			for (int j=0; j < noOfElements; j++){
				arr[j] = sc.nextInt();
			}
			int h = minHeap.height(noOfElements);
			System.out.println(h);
		}
	}
}
