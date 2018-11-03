package com.BST;

import java.util.Deque;
import java.util.LinkedList;

import com.BST.Node;

public class PostOrderTraversalUsingOneStack {
	Node root;

	protected void postOverTraversal(Node root){
		Deque<Node> st = new LinkedList<>();
		Node current = root;
		while (current != null || !st.isEmpty()){
			if(current != null){
				st.addFirst(current);
				current = current.left;
			}else{
				Node temp = st.peek().right;
				if (temp == null){
					temp = st.poll();
					System.out.print(temp.key+" ");
					while (!st.isEmpty() && temp == st.peek().right){
						temp = st.pop();
						System.out.print(temp.key+" ");
					}
				}else{
					current = temp;
				}
			}
		}

	}

	public static void main(String[] args) {
		PostOrderTraversalUsingOneStack tree = new PostOrderTraversalUsingOneStack();

		tree.root = new Node(4); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(1); 
		tree.root.left.right = new Node(3);

		tree.postOverTraversal(tree.root);
	}

}
