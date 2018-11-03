package com.BST;

import com.BST.Node;

public class MakeTreefromInorderAndPreorder {
	Node root;
	public static int pIndex=0;
	private Node buildTree(int[] in, int[] pre, int stIndex, int endIndex){
		if ( stIndex> endIndex )
			return null;
		Node root = new Node (pre[pIndex]);
		pIndex++;
		if ( stIndex == endIndex )
			return root;
		int index = searchIndex ( in, stIndex, endIndex, root.key);
		root.left = buildTree (in, pre, stIndex, index-1);
		root.right = buildTree (in, pre, index+1, endIndex);
		return root;
	}
	
	private int searchIndex(int[] in, int stIndex, int endIndex, int key) {
		for ( int i=stIndex; i<=endIndex; i++ ){
			if ( in[i] == key )
				return i;
		}
		return -1;
	}
	public void printPOSTORDER(Node root){
		if(root!=null){
			printPOSTORDER(root.left);
			
			printPOSTORDER(root.right);
			System.out.print("  " + root.key);
		}
	}
	public static void main(String[] args) {
		
		MakeTreefromInorderAndPreorder ip = new MakeTreefromInorderAndPreorder();
		
		int [] inOrder = {3,1,4,0,5,2,6};
		int [] preOrder = {0,1,3,4,2,5,6};
		
		Node finalTree = ip.buildTree(inOrder, preOrder, 0, inOrder.length-1);
		ip.printPOSTORDER(finalTree);
	}

}
