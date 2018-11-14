package com.BST;

import com.BST.Node;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoBST {
	Node root1;
	Node root2;
	public static void merge(Node root1 , Node root2)
    {
       List<Integer> list1 = insertInorder(root1);
       List<Integer> list2 = insertInorder(root2);
       ArrayList<Integer>list3 = mergeBST(list1, list2, list1.size(), list2.size()); 
         
       Node node = ALtoBST(list3, 0, list3.size()-1); 
       inOrder(node);
    }
	private static void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.key+" ");
		inOrder(node.right);
		
	}
	private static Node ALtoBST(ArrayList<Integer> list, int start, int end) {
		 // Base case 
        if(start > end) 
            return null; 
      
        int mid = (start+end)/2; 
        Node node = new Node(list.get(mid)); 
  
        node.left = ALtoBST(list, start, mid-1); 
          
        node.right = ALtoBST(list, mid+1, end); 
      
    return node; 
	}
	private static ArrayList<Integer> mergeBST(List<Integer> list1, List<Integer> list2, int m, int n) {
		Collections.sort(list1);
		Collections.sort(list2);
		ArrayList<Integer> list3 = new ArrayList<>(); 
        int i=0; 
        int j=0; 
          
        //Traversing through both ArrayLists 
        while( i<m && j<n) 
        { 
            // Smaller one goes into list3 
            if(list1.get(i)<list2.get(j)) 
            { 
                list3.add(list1.get(i)); 
                i++; 
            } 
            else
            { 
                list3.add(list2.get(j)); 
                j++; 
            } 
        } 
          
        // Adds the remaining elements of list1 into list3 
        while(i<m) 
        { 
            list3.add(list1.get(i)); 
            i++; 
        } 
      
        // Adds the remaining elements of list2 into list3 
        while(j<n) 
        { 
            list3.add(list2.get(j)); 
            j++; 
        } 
        return list3; 
	}
	private static List<Integer> insertInorder(Node node) {
		ArrayList<Integer> list1 = new ArrayList<>();  
        ArrayList<Integer> list2 = storeInorderUtil(node,list1);  
        return list2; 
	}
	private static ArrayList<Integer> storeInorderUtil(Node node, ArrayList<Integer> list) {
		if(node == null) 
            return list; 
          
        //recur on the left child 
        storeInorderUtil(node.left, list); 
          
        // Adds data to the list 
        list.add(node.key); 
          
        //recur on the right child 
        storeInorderUtil(node.right, list); 
          
        return list; 
	}
	public static void main(String[] args) {
		MergeTwoBST tree = new MergeTwoBST();
		tree.root1 = new Node(1);
		tree.root1.right = new Node(33);
		tree.root1.right.left = new Node(4);
		
		MergeTwoBST tree2 = new MergeTwoBST();
		tree2.root2 = new Node(6);
		tree2.root2.right = new Node(7);
		tree2.root2.right.left = new Node(1);
		
		merge(tree.root1, tree2.root2);

	}

}
