package com.tree;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

public class BottomViewOfBinaryTree {
	Node root;
	public static void main(String[] args) {
		BottomViewOfBinaryTree tree = new BottomViewOfBinaryTree();
		/*tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.right = new Node(7);
		tree.root.right.left = new Node(6);
		tree.root.left.right = new Node(5);
		tree.root.left.left = new Node(4);*/
		
		tree.root = new Node(20); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(22); 
		tree.root.left.left = new Node(5); 
		tree.root.left.right = new Node(3); 
		tree.root.right.left = new Node(4); 
		tree.root.right.right = new Node(25); 
		tree.root.left.right.left = new Node(10); 
		tree.root.left.right.right = new Node(14);
		tree.root.right.left.left = new Node(15);
		tree.root.right.left.right = new Node(16);
		tree.root.right.right.left = new Node(30);
		tree.root.right.right.right = new Node(31);
		tree.printBottomView(tree.root);
	}
	private void printBottomView(Node node) {
		TreeMap<Integer, Vector<Integer>> vt = new TreeMap<>();
		int hd = 0;
		printBottomViewUtil(node, vt, hd);
		System.out.println(vt);
		for (Entry<Integer, Vector<Integer>> entrySet : vt.entrySet()){
			if (entrySet.getKey() > 0)
				System.out.print(entrySet.getValue().get(0)+" ");
			else
				System.out.print(entrySet.getValue().get(entrySet.getValue().size()-1)+" ");
		}
	}
	private void printBottomViewUtil(Node node,
			TreeMap<Integer, Vector<Integer>> vt, int hd) {
		
		if (node == null)
			return;
		Vector<Integer> v = vt.get(hd);
		if (v == null){
			v = new Vector<>();
			v.add(node.data);
		}else{
			v.add(node.data);
		}
		vt.put(hd, v);
		printBottomViewUtil(node.left, vt, hd-1);
		printBottomViewUtil(node.right, vt, hd+1);
	}
}
