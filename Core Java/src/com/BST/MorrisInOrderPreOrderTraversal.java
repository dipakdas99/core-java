package com.BST;

import com.BST.Node;

public class MorrisInOrderPreOrderTraversal {
	Node root;
	protected void MorrisInOrderTraversal(Node root){
		Node current,predecessor;
		if (root == null){
			return;
		}
		current = root;
		while (current!=null){
			//left is null then print the node and go to right
			if (current.left == null){
				System.out.print(current.key+" ");
				current = current.right;
			}else{
				//find the predecessor.
				predecessor = current.left;
				//To find predecessor keep going right till right node is not null or right node is not current.
                while(predecessor.right != current && predecessor.right != null){
                    predecessor = predecessor.right;
                }
              //if right node is null then go left after establishing link from predecessor to current.
                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }else{ //left is already visit. Go right after visiting current.
                    predecessor.right = null;
                    System.out.print(current.key + " ");
                    current = current.right;
                }
			}
		}
	}
	public static void main(String[] args) {
		MorrisInOrderPreOrderTraversal tree = new MorrisInOrderPreOrderTraversal();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
  
        tree.MorrisInOrderTraversal(tree.root); 
        System.out.println();
        tree.MorrisPreorderTraversal(tree.root);
		
	}
	private void MorrisPreorderTraversal(Node root) {
		Node current,predecessor;
		if (root == null){
			return;
		}
		current = root;
		while (current!=null){
			//left is null then print the node and go to right
			if (current.left == null){
				System.out.print(current.key+" ");
				current = current.right;
			}else{
				//find the predecessor.
				predecessor = current.left;
				//To find predecessor keep going right till right node is not null or right node is not current.
                while(predecessor.right != current && predecessor.right != null){
                    predecessor = predecessor.right;
                }
              //if right node is null then go left after establishing link from predecessor to current.
                if(predecessor.right == null){
                    predecessor.right = current;
                    System.out.print(current.key + " ");
                    current = current.left;
                }else{ //left is already visit. Go right after visiting current.
                    predecessor.right = null;
                    current = current.right;
                }
			}
		}
		
	}

}
