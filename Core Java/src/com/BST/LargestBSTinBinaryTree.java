package com.BST;

import com.BST.Node;

public class LargestBSTinBinaryTree {
	Node root;
	
	public int largestBST(Node root){
        MinMax m = largest(root);
        return m.size;
    }
    
    private MinMax largest(Node root){
        //if root is null return min as Integer.MAX and max as Integer.MIN 
        if(root == null){
            return new MinMax();
        }
        
        //postorder traversal of tree. First visit left and right then
        //use information of left and right to calculate largest BST.
        MinMax leftMinMax = largest(root.left);
        MinMax rightMinMax =largest(root.right);
        
        MinMax m = new MinMax();
        
        //if either of left or right subtree says its not BST or the key
        //of this node is not greater/equal than max of left and less than min of right
        //then subtree with this node as root will not be BST. 
        //Return false and max size of left and right subtree to parent
        if(leftMinMax.isBST == false || rightMinMax.isBST == false || (leftMinMax.max > root.key || rightMinMax.min <= root.key)){
            m.isBST = false;
            m.size = Math.max(leftMinMax.size, rightMinMax.size);
            return m;
        }
        
        //if we reach this point means subtree with this node as root is BST.
        //Set isBST as true. Then set size as size of left + size of right + 1.
        //Set min and max to be returned to parent.
        m.isBST = true;
        m.size = leftMinMax.size + rightMinMax.size + 1;
     
        //if root.left is null then set root.key as min else
        //take min of left side as min
        m.min = root.left != null ? leftMinMax.min : root.key;
  
        //if root.right is null then set root.key as max else
        //take max of right side as max.
        m.max = root.right != null ? rightMinMax.max : root.key;
   
        return m;
    }
	
	public static void main(String[] args) {
		LargestBSTinBinaryTree tree = new LargestBSTinBinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(10);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(8);
		tree.root.left.left.left = new Node(2);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(6);
		tree.root.left.right.right = new Node(12);
		tree.root.right = new Node(15);
		tree.root.right.left = new Node(16);
		tree.root.right.right = new Node(20);
		tree.root.right.right.left = new Node(18);
		tree.root.right.right.right = new Node(22);
		
		
		 int largestBSTSize = tree.largestBST(tree.root);
		 System.out.println(largestBSTSize);
	}

}

/**
 * Object of this class holds information which child passes back
 * to parent node.
 */
class MinMax{
    int min;
    int max;
    boolean isBST;
    int size ;
    
    MinMax(){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        isBST = true;
        size = 0;
    }
}
