package com.BST;

import com.BST.Node;

public class ChidrenSumParent {
	Node root;

	int sumParent(Node root){
		int sum = 0;
		if (root == null || root.left == null && root.right == null)
			return 1;
		else{
			if (root.left != null)
				sum = root.left.key;
			if (root.right != null)
				sum = root.right.key +sum;
			if ((root.key == sum) && (sumParent(root.left)!=0) && (sumParent(root.right)!=0))
				return 1;
			else
				return 0;
		}
	}

	public static void main(String[] args) {
		ChidrenSumParent tree = new ChidrenSumParent();

		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(1);
		tree.root.right.right = new Node(1);

		System.out.println(tree.sumParent(tree.root));
	}

}
