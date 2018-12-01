package com.Heap;
import java.util.Stack;
import java.util.Scanner;

public class NearlySortedAlgorithm {
	private void sortedNearly(int[] arr, int len, int k){
		/*Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		s1.add(arr[0]);
		for (int i=1; i < len; i++){
			if (s1.peek() > arr[i]){
				while (!s1.isEmpty() && s1.peek() > arr[i]){
					int removeElement = s1.pop();
					s2.add(removeElement);
				}
				s1.add(arr[i]);
				while (!s2.isEmpty()){
					int removeElement = s2.pop();
					s1.add(removeElement);
				}
			}else{
				s1.add(arr[i]);
			}
		}
		while (!s1.isEmpty()){
			s2.add(s1.pop());
		}
		while (!s2.isEmpty()){
			System.out.print(s2.pop()+" ");
		}*/
		for (int i = 0; i < k ; ){
 			if (arr[i] > arr[k-1]){
				swap(arr,i,k-1);
			}else
				i++;
			if (i == k-1 && len > k){
				i = k;
				k = k + k;
			}
		}
		for (int i = 0; i < len; i++){
			System.out.print(arr[i]+" ");
		}
	}
	private void swap(int[] arr,int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	

	public static void main(String[] args) {
		NearlySortedAlgorithm sort = new NearlySortedAlgorithm();
		/*int arr1[] = {2, 6, 3, 12, 56, 8};
		int arr[] = {2, 1, 3};
		int n = arr1.length;
		int k1=3;
		sort.sortedNearly(arr1, n, k1);*/
		Scanner sc = new Scanner(System.in);
		int inputLen = sc.nextInt();
		for (int i = 0; i < inputLen; i++){
			int noOfElement = sc.nextInt();
			int arr[] = new int[noOfElement];
			int k = sc.nextInt();
			for (int j = 0; j < noOfElement; j++){
				arr[i] = sc.nextInt();
			}
			sort.sortedNearly(arr, noOfElement, k);
		}
	}

}
