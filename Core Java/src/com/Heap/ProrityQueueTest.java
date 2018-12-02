package com.Heap;

import java.util.PriorityQueue;

public class ProrityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); 
		// Adding items to the pQueue using add() 
		pQueue.add(2); 
		pQueue.add(1); 
		pQueue.add(3); 
		pQueue.add(4); 
		System.out.println(pQueue.poll());
		System.out.println(pQueue);
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
	}

}
