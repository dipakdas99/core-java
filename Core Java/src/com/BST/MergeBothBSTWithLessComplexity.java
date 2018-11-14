package com.BST;
import com.BST.Node;
import java.util.Stack;
public class MergeBothBSTWithLessComplexity {
	Node root1;
	Node root2;

	public static void main(String[] args) {
		MergeBothBSTWithLessComplexity tree = new MergeBothBSTWithLessComplexity();
		tree.root1 = new Node(1);
		tree.root1.right = new Node(33);
		tree.root1.right.left = new Node(4);
		
		MergeBothBSTWithLessComplexity tree2 = new MergeBothBSTWithLessComplexity();
		tree2.root2 = new Node(6);
		tree2.root2.right = new Node(7);
		tree2.root2.right.left = new Node(1);
		
		merge(tree.root1, tree2.root2);
	}
	private static void insertIntoStack(Node node, Stack<Node> s1){
		while (node != null){
			s1.push(node);
			node = node.left;
		}
	}
	private static void merge(Node root1, Node root2) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		insertIntoStack(root1,s1);
		insertIntoStack(root2,s2);
		
		while (!s1.isEmpty() || !s2.isEmpty()){
			int a = (!s1.isEmpty() ? s1.peek().key : Integer.MAX_VALUE);
			int b = (!s2.isEmpty() ? s2.peek().key : Integer.MAX_VALUE);
			
			if (a <= b){
				System.out.print(a+" ");
				Node temp = s1.peek();
				s1.pop();
				insertIntoStack(temp.right, s1);
			}else{
				System.out.print(b+" ");
				Node temp = s2.peek();
				s2.pop();
				insertIntoStack(temp.right, s2);
			}
		}
	}

}
