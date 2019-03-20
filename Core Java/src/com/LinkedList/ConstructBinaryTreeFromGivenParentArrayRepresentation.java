package com.LinkedList;

public class ConstructBinaryTreeFromGivenParentArrayRepresentation {
	static Node root;
	static class Node{
		int data;
		Node left,right;
		Node(int key){
			this.data = key;
			left = right = null;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 5, 5, 2, 2, -1, 3};
		int n = arr.length;
		Node node = createTree(arr, n);
		inorder(node);
	}
	static void inorder(Node node)  
    { 
        if (node != null)  
        { 
            inorder(node.left); 
            System.out.print(node.data + " "); 
            inorder(node.right); 
        } 
    } 
	private static Node createTree(int[] arr, int n) {
		Node created[] = new Node[n];
		for (int i = 0; i < n; i++) {
			created[i] = null;
		}
		for (int i = 0; i < n; i++) {
			buildTree(arr,i,created);
		}
		return root;
	}
	private static void buildTree(int[] arr, int i, Node[] created) {
		if (created[i] != null) 
            return; 
   
        // Create a new node and set created[i] 
        created[i] = new Node(i); 
   
        // If 'i' is root, change root pointer and return 
        if (arr[i] == -1)  
        { 
            root = created[i]; 
            return; 
        } 
   
        // If parent is not created, then create parent first 
        if (created[arr[i]] == null) 
        	buildTree(arr, arr[i], created); 
   
        // Find parent pointer 
        Node p = created[arr[i]]; 
        // If this is first child of parent 
        if (p.left == null) 
            p.left = created[i]; 
        else // If second child 
            p.right = created[i];
	}
}
