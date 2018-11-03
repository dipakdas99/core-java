package com.BST;
import com.BST.Node;
public class CountBSTNodesThatLieInAGivenRange {
	Node root;
	int getCountOfNode(Node node, int low, int high) 
    {
		if (node == null)
			return 0;
		if (node.key >= low && node.key <= high )
			return 1+getCountOfNode(node.left,low,high) + getCountOfNode(node.right,low,high);
		else if (node.key < low)
			return getCountOfNode(node.right,low,high);
		else
			return getCountOfNode(node.left,low,high);
    }
	public static void main(String[] args) {
		CountBSTNodesThatLieInAGivenRange tree = new CountBSTNodesThatLieInAGivenRange();
		tree.root = new Node(20);
		tree.root.left = new Node(10);
		tree.root.left.right = new Node(8);
		tree.root.left.left = new Node (5);
		tree.root.right = new Node(30);
		tree.root.right.right = new Node(32);
		tree.root.right.left = new Node(25);
		
		System.out.println(tree.getCountOfNode(tree.root, 1, 15));
	}

}
