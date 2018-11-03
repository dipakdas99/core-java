package com.BST;

import com.BST.Node;
import java.util.Stack;

public class PostOrderTraversal {
	
	Node root;
	public void printPostOrder(Node root){
		Stack<Node> st1 = new Stack<Node>();
		Stack<Node> st2 = new Stack<Node>();
		st1.push(root);
		while(!st1.isEmpty()){
			root = st1.pop();
			st2.push(root);
			if ( root.left != null )
				st1.push(root.left);
			if ( root.right != null)
				st1.push(root.right);
		}
		while ( !st2.isEmpty() ){
			root = st2.pop();
			System.out.print(root.key+" ");
		}
	}
	public void printPreOrder(Node root){
		Stack<Node> st = new Stack<Node>();
		st.push(root);
		while (!st.isEmpty()){
			root = st.pop();
			System.out.print(root.key+" ");
			if(root.right != null)
				st.push(root.right);
			if(root.left != null)
				st.push(root.left);
		}
	}
	public void printInorder(Node root){
		Stack<Node> st = new Stack<Node>();
		while(true){
			if(root != null){
				st.push(root);
				root=root.left;
			}else{
				if(st.isEmpty())
					break;
				root = st.pop();
				System.out.print(root.key+" ");
				root = root.right;
			}
			
		}
	}
	public static void main(String[] args) {
		PostOrderTraversal tree = new PostOrderTraversal();
		tree.root = new Node(4); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3);
        
        tree.printPostOrder(tree.root);
        System.out.println();
        tree.printPreOrder(tree.root);
        System.out.println();
        tree.printInorder(tree.root);
	}

}
