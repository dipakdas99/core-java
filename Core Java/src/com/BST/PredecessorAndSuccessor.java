package com.BST;

import com.BST.Node;

public class PredecessorAndSuccessor {
	
	Node root;
	static class Res{
		Node pre = null;
		Node succ = null;
	}
	static Res s = new Res();
	static Res p = new Res();
	public static void main(String[] args) {
		PredecessorAndSuccessor tree = new PredecessorAndSuccessor();
		tree.root = new Node(50);
		tree.root.left = new Node(30);
		tree.root.left.left = new Node(20);
		tree.root.left.right = new Node(40);
		tree.root.right = new Node(70);
		tree.root.right.left = new Node(60);
		tree.root.right.right = new Node(80);
		
		tree.findPreSucc(tree.root, s, p, 65);
	}
	private void findPreSucc(Node root, Res s, Res p, int key) {
		if(root.key>=key){
			if(root.key!=key){
				s.succ=root;
			}
			if(root.key==key&&root.right!=null){
				findPreSucc(root.right,p,s,key);
			}
			if(root.left!=null){
				findPreSucc(root.left,p,s,key);
			}
		}else if(root.key<=key){
			if(root.key!=key){
				p.pre=root;
			}
			if(root.key==key&&root.left!=null){
				findPreSucc(root.left,p,s,key);
			}
			if(root.right!=null){
				findPreSucc(root.right,p,s,key);
			}
		}
		
	}

}
