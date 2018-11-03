package com.BST;

import com.BST.Node;

public class DeleteBST {
	
	Node root;
	protected Node deleteNodeFromTree(Node node, int data){
		
		if ( node == null )
			return node;
		if ( node.key < data)
			node.right = deleteNodeFromTree(node.right, data);
		else if ( node.key >data )
			node.left = deleteNodeFromTree(node.left, data);
		else{
			if (node.left == null && node.right == null)
			{
				// update root to null
				return null;
			}

			// Case 2: node to be deleted has two children
			else if (node.left != null && node.right != null)
			{
				// find its in-order predecessor node
				Node predecessor = maxValue(node.left);

				// Copy the value of predecessor to current node
				node.key = predecessor.key;

				// recursively delete the predecessor. Note that the
				// predecessor will have at-most one child (left child)
				deleteNodeFromTree(node.left, predecessor.key);
			}

			// Case 3: node to be deleted has only one child
			else
			{
				// find child node
				Node child = (node.left != null)? node.left: node.right;
				node = child;
			}
		}
		return node;
	}
	private Node maxValue(Node ptr) {
		while (ptr.right != null) {
			ptr = ptr.right;
		}

		return ptr;
	}
	private void inorder(Node node){
		if ( node == null )
			return;
		inorder(node.left);
		System.out.print(node.key+" ");
		inorder(node.right);
	}
	public static void main(String[] args) {
		DeleteBST tree = new DeleteBST();
		
		tree.root = new Node(20);
		tree.root.left = new Node(10);
		tree.root.left.right = new Node(8);
		tree.root.left.left = new Node (5);
		tree.root.right = new Node(30);
		tree.root.right.right = new Node(32);
		tree.root.right.left = new Node(25);
		tree.root.right.left.left = new Node(22);
		
		/*tree.root = new Node(57);
		tree.root.left = new Node(12);
		tree.root.left.right = new Node(43);
		tree.root.left.right.left = new Node (30);
		tree.root.left.right.left.left = new Node(22);
		tree.root.left.right.left.left.left = new Node(20);
		tree.root.left.right.left.left.left.right = new Node(38);
		tree.root.left.right.left.left.left.right.left = new Node(25);
		tree.root.left.right.left.left.left.right.left.left = new Node(16);
		tree.root.left.right.left.left.left.right.left.left.left = new Node(14);
		tree.root.left.right.left.left.left.right.left.left.left.right = new Node(27);
		tree.root.left.right.left.left.left.right.left.left.left.right.left = new Node(6);
		tree.root.left.right.left.left.left.right.left.left.left.right.left.right = new Node(26);
		tree.root.left.right.left.left.left.right.left.left.left.right.left.right.right = new Node(28);
		tree.root.left.right.left.left.left.right.left.left.left.right.left.right.right.right = new Node(37);
		tree.root.left.right.left.left.left.right.left.left.left.right.left.right.right.right.left = new Node(6);
		tree.root.left.right.left.left.left.right.left.left.left.right.left.right.right.right.left.right = new Node(47);
		tree.root.left.right.left.left.left.right.left.left.left.right.left.right.right.right.left.right.left = new Node(30);
		tree.root.left.right.left.left.left.right.left.left.left.right.left.right.right.right.left.right.left.left = new Node(14);
		tree.root.left.right.left.left.left.right.left.left.left.right.left.right.right.right.left.right.left.left.right = new Node(25);
		tree.root.left.right.left.left.left.right.left.left.left.right.left.right.right.right.left.right.left.left.right.right = new Node(46);
		tree.root.left.right.left.left.left.right.left.left.left.right.left.right.right.right.left.right.left.left.right.right.left = new Node(15);
		tree.root.left.right.left.left.left.right.left.left.left.right.left.right.right.right.left.right.left.left.right.right.left.right = new Node(35);
		tree.root.left.right.left.left.left.right.left.left.left.right.left.right.right.right.left.right.left.left.right.right.left.right.right = new Node(44);
		tree.root.left.right.left.left.left.right.left.left.left.right.left.right.right.right.left.right.left.left.right.right.left.right.right.right = new Node(51);
		tree.root.right = new Node(74);
		tree.root.right.right = new Node(85);
		tree.root.right.right.right = new Node(99);
		tree.root.right.right.right.left = new Node(71);
		tree.root.right.right.right.left.right = new Node(92);
		tree.root.right.right.right.left.right.left = new Node(81);
		tree.root.right.right.right.left.right.left.left = new Node(57);
		tree.root.right.right.right.left.right.left.left.right = new Node(74);
		tree.root.right.right.right.left.right.left.left.right.left = new Node(63);
		tree.root.right.right.right.left.right.left.left.right.left.right = new Node(71);
		tree.root.right.right.right.left.right.left.left.right.left.right.right = new Node(97);
		tree.root.right.right.right.left.right.left.left.right.left.right.right.left = new Node(82);
		tree.root.right.right.right.left.right.left.left.right.left.right.right.left.right = new Node(85);
		tree.root.right.right.right.left.right.left.left.right.left.right.right.left.right.left = new Node(58);
		tree.root.right.right.right.left.right.left.left.right.left.right.right.left.right.left.right = new Node(96);
		tree.root.right.right.right.left.right.left.left.right.left.right.right.left.right.left.right.left = new Node(83);
		tree.root.right.right.right.left.right.left.left.right.left.right.right.left.right.left.right.left.left = new Node(68);
		tree.root.right.right.right.left.right.left.left.right.left.right.right.left.right.left.right.left.left.left = new Node(65);
		tree.root.right.right.right.left.right.left.left.right.left.right.right.left.right.left.right.left.left.left.right = new Node(88);*/
		/*tree.root.right.right.right.left.right.left.left.right.left.right.right.left.right.left.right.left.left.left.right.left = new Node(71);*/
		
		//57 12 43 30 74 22 20 85 38 99 25 16 71 14 27 92 81 57 74 63 71 97 82 6 26 85 28 37 6 47 30 14 58 25 96 83 46 15 68 35 65 44 51 88 71
		Node result = tree.deleteNodeFromTree(tree.root, 30);
		tree.inorder(result);
	}

}
