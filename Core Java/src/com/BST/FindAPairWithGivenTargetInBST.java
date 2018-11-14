package com.BST;

import com.BST.Node;
import java.util.ArrayList;
import java.util.HashSet;
public class FindAPairWithGivenTargetInBST {
	Node root;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public boolean findPair(Node root, int target){
		HashSet<Integer> s = new HashSet<Integer>(); 
		if (root == null)
			return false;
		inorder(root);
		for (int i=0; i<list.size(); ++i) 
        { 
            int temp = target-list.get(i); 
  
            // checking for condition 
            if (temp>=0 && list.contains(temp)) 
            { 
                return true; 
            } 
            s.add(list.get(i)); 
        } 
		return false;
	}
	private void inorder(Node node) {
		/*if (node == null)
			return;
		inorder(node.left);
		list.add(node.key);
		inorder(node.right);*/
		/*list.add(11);// 11 35 67 41 9 16 22 73 9 20 69 37 61 39
		list.add(35);
		list.add(67);
		list.add(41);
		list.add(9);
		list.add(16);
		list.add(22);
		
		list.add(73);
		list.add(9);
		list.add(20);
		list.add(69);
		list.add(37);
		list.add(61);
		list.add(39);*/
		list.add(99);list.add(91);list.add(44);list.add(18);list.add(81);list.add(32);list.add(92);list.add(75);list.add(4);list.add(34);list.add(85);list.add(71);list.add(11);list.add(75);list.add(93);list.add(47);list.add(77);list.add(55);list.add(76);list.add(33);list.add(26);list.add(17);list.add(11);list.add(85);list.add(9);list.add(56);list.add(69);list.add(31);list.add(31);list.add(23);list.add(50);list.add(29);list.add(65);list.add(94);list.add(47);list.add(97);list.add(77);list.add(90);list.add(71);list.add(80);list.add(76);list.add(55);list.add(3);list.add(86);list.add(81);list.add(47);list.add(33);list.add(9);list.add(53);list.add(60);list.add(41);list.add(30);list.add(76);list.add(4);
		
	}
	public static void main(String[] args) {
		FindAPairWithGivenTargetInBST tree = new FindAPairWithGivenTargetInBST();
		tree.root = new Node(20);
		tree.root.left = new Node(10);
		tree.root.left.right = new Node(8);
		tree.root.left.left = new Node (5);
		tree.root.right = new Node(30);
		tree.root.right.right = new Node(32);
		tree.root.right.left = new Node(25);
		
		boolean flag = tree.findPair(tree.root, 19);
		System.out.println(flag);
	}

}
