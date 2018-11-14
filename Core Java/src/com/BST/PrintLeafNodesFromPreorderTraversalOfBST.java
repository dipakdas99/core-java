package com.BST;
import java.util.Stack;
import java.util.Scanner;
public class PrintLeafNodesFromPreorderTraversalOfBST {
	private static void printLeafNode(int[] preorder, int n){
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0, j = 1; j < n; i++, j++) 
	    { 
	        boolean found = false; 
	  
	        if (preorder[i] > preorder[j]) 
	            s.push(preorder[i]); 
	  
	        else
	        { 
	            while (!s.empty()) 
	            { 
	                if (preorder[j] > s.peek()) 
	                { 
	                    s.pop(); 
	                    found = true; 
	                } 
	                else
	                    break; 
	            } 
	        } 
	  
	        if (found)
	        	System.out.print(preorder[i]+" ");
	            //cout << preorder[i] << " "; 
	    } 
	  
	    // Since rightmost element is always leaf node.
		System.out.print(preorder[n-1]+" ");
	    //cout << preorder[n - 1]; 
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = {3, 2, 4};
		int size = arr.length;
		/*int noOfInput = sc.nextInt();
		for (int i = 0; i < noOfInput; i++){
			int noOfElement = sc.nextInt();
			int arr[] = new int[noOfElement];
			for (int j = 0; j < noOfElement; j++){
				arr[j] = sc.nextInt();
			}
			int size = arr.length;
			printLeafNode(arr, size);
		}*/
		printLeafNode(arr, size);
		
	}

}
