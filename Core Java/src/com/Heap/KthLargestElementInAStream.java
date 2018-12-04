package com.test.Heap;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
public class KthLargestElementInAStream {
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	List<Integer> elements = new ArrayList<Integer>();
	int prev = 0;
	private void addNum(int data, int k){
		minHeap.offer(data);
		if (minHeap.size() < k){
			elements.add(-1);
		}else{
			if (prev > minHeap.peek()){
				elements.add(prev);
				minHeap.poll();
			}else{
				prev = minHeap.poll();
				elements.add(prev);
			}
			
		}
	}
	private void printStream(){
		for (Integer data : elements)
			System.out.print(data+" ");
		elements.clear();
		minHeap.clear();
		prev = 0;
	}
	public static void main(String[] args) {
		KthLargestElementInAStream stream = new KthLargestElementInAStream();
		Scanner sc = new Scanner(System.in);
		int k = 4;
		stream.addNum(1, k);
		stream.addNum(2, k);
		stream.addNum(3, k);
		stream.addNum(4, k);
		stream.addNum(5, k);
		stream.addNum(6, k);
		stream.printStream();
		/*int noOfInput = sc.nextInt();
		for (int i = 0; i < noOfInput; i++){
			int k = sc.nextInt();
			int noOfElements = sc.nextInt();
			for (int j = 0; j < noOfElements; j++){
				stream.addNum(sc.nextInt(), k);
			}
			stream.printStream();
		}*/
	}

}
