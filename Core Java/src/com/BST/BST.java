package com.BST;

import com.BST.Node;

public class BST {
	Node root;
	
	private boolean findNode(Node node, int val){
		if ( node == null )
			return false;
		if ( node.key == val ){
			return true;
		}
		
		if ( val < node.key ){
			return findNode(node.left, val);
		}
		if ( val > node.key )
			
			return findNode(node.right, val);
		
		return false;
	}
	
	public static void main(String[] args) {
		BST tree = new BST();
		
		tree.root = new Node(20);
		tree.root.left = new Node(10);
		tree.root.left.right = new Node(8);
		tree.root.left.left = new Node (5);
		tree.root.right = new Node(30);
		tree.root.right.right = new Node(32);
		tree.root.right.left = new Node(25);
		
		boolean result = tree.findNode(tree.root, 24);
		System.out.println(result);
		if (result)
			System.out.println("1");
		else
			System.out.println("0");
		
		Node temp = tree.insertRec(tree.root, 10);
		//Node temp = tree.insertBSTInIterative(tree.root,10);
		
		tree.inorder(temp);
	}

	private void inorder(Node temp) {
		if ( temp == null )
			return;
		inorder(temp.left);
		System.out.print(temp.key+" ");
		inorder(temp.right);
	}

	private Node insertRec(Node node, int data) {
		
		if ( node == null ){
			node = new Node(data);
			return node;
		}
		if ( data < node.key )
			node.left = insertRec( node.left, data );
		if ( data > node.key )
			node.right = insertRec(node.right, data );
		
		return node;
		
	}
	private Node insertBSTInIterative(Node node, int data){
		Node new_data = new Node(data);
		if ( node == null )
			return new_data;
		
		Node parent = null, current = node;
		
		while ( current != null ){
			parent = current;
			
			if ( parent.key > data )
				current = current.right;
			else if ( parent.key > data )
				current = current.left;
			else
				return node;
		}
		if ( parent.key <= data )
			parent.right = new_data;
		else
			parent.left = new_data;
		
		return node;
		
	}

}
