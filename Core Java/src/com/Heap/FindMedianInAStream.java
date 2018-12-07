package com.Heap;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class FindMedianInAStream {
	List<Integer> median = new ArrayList<Integer>();
	PriorityQueue<Integer> maxHeap;//lower half
	PriorityQueue<Integer> minHeap;//higher half

	public FindMedianInAStream(){
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		minHeap = new PriorityQueue<Integer>();
	}

	// Adds a number into the data structure.
	public void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());

		if(maxHeap.size() < minHeap.size()){
			maxHeap.offer(minHeap.poll());
		}
	}

	public void findMedian() {
		if(maxHeap.size()==minHeap.size()){
			median.add((maxHeap.peek()+(minHeap.peek()))/2);
			
		}else{
			median.add(maxHeap.peek());
		}
	}
	private void printMedian() {
		for (Integer element : median)
			System.out.println(element);
		median.clear();
	}
	public static void main(String[] args) {
		FindMedianInAStream med = new FindMedianInAStream();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++){
			med.addNum(sc.nextInt());
			med.findMedian();
		}
		med.printMedian();
	}

	
}
