package com.BST;
import com.BST.Node;
public class MirrorTree {
	Node root;
	protected void makeMirrorTree(Node root){
		if (root == null)
			return ;
		makeMirrorTree(root.right);
		System.out.print(root.key+" ");
		makeMirrorTree(root.left);
	}
	public static void main(String[] args) {
		MirrorTree tree = new MirrorTree();
		tree.root = new Node(0);
		tree.root.left = new Node(1);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(6);
		
		tree.makeMirrorTree(tree.root);
	}

}
