package com.Heap;

public class MinHeap {
	private int[] Heap;
    private int size;
    private int maxsize;
 
    private static final int FRONT = 1;
	MinHeap(int maxsize){
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[maxsize + 1];
		Heap[0] = Integer.MIN_VALUE;
	}
	private int parent(int index){
		return index/2;
	}
	private void swap(int curr, int prev){
		int temp = Heap[curr];
		Heap[curr] = Heap[prev];
		Heap[prev] = temp;
	}
	private void insert(int data){
		Heap[++size] = data;
		int curr = size;
		while (Heap[curr] < Heap[parent(curr)]){
			swap (curr, parent(curr));
			curr = parent(curr);
		}
	}
	private boolean isLeaf(int index){
		if (index >=  (size / 2)  &&  index <= size)
        { 
            return true;
        }
        return false;
	}
	private int leftChild(int index){
		return 2*index;
	}
	private int rightChild(int index){
		return 2*index+1;
	}
	private void minHeapify(int index){
		if (!isLeaf(index)){
			if ( Heap[index] > Heap[leftChild(index)]  || Heap[index] > Heap[rightChild(index)])
            {
                if (Heap[leftChild(index)] < Heap[rightChild(index)])
                {
                    swap(index, leftChild(index));
                    minHeapify(leftChild(index));
                }else
                {
                    swap(index, rightChild(index));
                    minHeapify(rightChild(index));
                }
            }
		}
	}
	public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1 ; pos--)
        {
            minHeapify(pos);
        }
    }
	public void print()
    {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i] 
                + " RIGHT CHILD :" + Heap[2 * i  + 1]);
            System.out.println();
        } 
    }
	 public int remove()
	    {
	        int popped = Heap[FRONT];
	        Heap[FRONT] = Heap[size--]; 
	        minHeapify(FRONT);
	        return popped;
	    }
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        
        minHeap.minHeap();
 
        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
        minHeap.print();
	}

}
