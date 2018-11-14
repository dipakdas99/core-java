package com.BST;
import java.util.Scanner;
import com.BST.Node;
public class ArrayToBST {
	Node root;
	
	private Node sortedArrayToBST(int[] arr, int start, int end){
		if (start > end)
			return null;
		int mid = (start + end)/2;
		
		Node node = new Node(arr[mid]);
		
		node.left = sortedArrayToBST(arr, start, mid-1);
		
		node.right = sortedArrayToBST(arr, mid+1, end);
		
		return node;
	}
	private void preOrder(Node node){
		if (node == null)
			return;
		System.out.print(node.key+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	public static void main(String[] args) {
		ArrayToBST tree = new ArrayToBST();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int noOfElement = sc.nextInt();
			int arr[] = new int[noOfElement];
			for (int j = 0; j < noOfElement; j++){
				arr[j] = sc.nextInt();
			}
			 int len = arr.length; 
		     tree.root = tree.sortedArrayToBST(arr, 0, len - 1);
		     tree.preOrder(tree.root);
		     System.out.println();
		}
	}

}
