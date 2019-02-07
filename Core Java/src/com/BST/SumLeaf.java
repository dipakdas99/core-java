package com.BST;

import java.util.ArrayList;
import java.util.List;

import com.BST.Node;

public class SumLeaf {
	Node root;
	
	protected int sum(Node root){
		int sum=0;
		if(root == null)
			return sum;
		return sum(root.left)+root.key+sum(root.right);
	}
	private boolean rootToLeafSum(Node root, int sum, List<Integer> path) {
		if(root == null)
			return false;
		if(root.left == null && root.right == null){
			if(root.key == sum){
				path.add(root.key);
				return true;
			}else{
				return false;
			}
		}
		if(rootToLeafSum(root.left,sum-root.key,path)){
			path.add(root.key);
			return true;
		}
		if(rootToLeafSum(root.right,sum-root.key,path)){
			path.add(root.key);
			return true;
		}
		return false;
	}
	protected static boolean isBST(Node root,int min,int max){
		if (root == null) {
			return true;
		}
		if(root.key < min || root.key > max)
			return false;
		
		return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
	}
	public static void main(String[] args) {
		SumLeaf tree = new SumLeaf();
		
		tree.root = new Node(4); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3); 
        
       int s = tree.sum(tree.root);
       System.out.println(s);
       int sum=7;
       List<Integer> path=new ArrayList<Integer>();
       boolean result = tree.rootToLeafSum(tree.root, sum, path);
       if(result == true){
    	   System.out.println(path);
       }else{
    	   System.out.println("Sum not found");
       }
       
       int min = Integer.MIN_VALUE;
       int max = Integer.MAX_VALUE;
       boolean b = isBST(tree.root,min,max);
       System.out.println("Is Binary tree : "+b);
	}

	

}
