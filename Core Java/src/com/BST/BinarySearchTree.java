package com.BST;

class Node { 
    int key; 
    Node left, right; 

    public Node(int item) { 
        key = item; 
        left = right = null; 
    } 
} 
class BinarySearchTree { 
    
    Node root;
    Node root2;
   
    void insert(int key) { 
       root = insertRec(root, key); 
    } 
      
    Node insertRec(Node root, int key) { 
    	
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
  
        if (key < root.key) 
            root.left = insertRec(root.left, key); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key); 
  
        return root; 
    } 
  
    void inorder()  { 
       inorderRec(root); 
    } 
  
    void inorderRec(Node root) { 
        if (root != null) { 
            inorderRec(root.left); 
            System.out.print(root.key+" "); 
            inorderRec(root.right); 
        } 
        
    } 
   
  Node search(Node root,int key){
	  if(root == null || root.key == key)
		  return root;
	  if(root.key <key)
		  return search(root.right , key);
	  return search(root.left , key);
  }
  protected static boolean sameTree(Node a, Node b){
	  if(a == null && b ==null)
		  return true;
	  if(a !=null && b!=null)
		  return (a.key == b.key &&  sameTree(a.left,b.left) && sameTree(a.right,b.right));
	  
	  return false;
	  
  }
  protected static int sizeBST(Node root){
	  if(root == null)
		  return 0;
	  int l_size = sizeBST(root.left);
	  int r_size = sizeBST(root.right);
	  return l_size+r_size+1;
  }
  protected static int heightBST(Node root){
	  if(root == null)
		  return 0;
	  int l_size = heightBST(root.left);
	  int r_size = heightBST(root.right);
	  return 1+Integer.max(l_size,r_size);
  }
    public static void main(String[] args) { 
        BinarySearchTree tree = new BinarySearchTree(); 
  
        tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
  
        tree.inorder();
        
        tree.root2 = new Node(1); 
        tree.root2.left = new Node(2); 
        tree.root2.right = new Node(3); 
        tree.root2.left.left = new Node(4); 
        tree.root2.left.right = new Node(5);
        System.out.println();
        System.out.println();
        Node result = tree.search(tree.root,50);
        if(result==null){
        	System.out.println("Not found");
        }else
        	System.out.println(result.key);
        
        System.out.println();
        Node result2 = tree.search(tree.root2,50);
        if(result2==null){
        	System.out.println("Not found");
        }else
        	System.out.println("Search found: "+result.key);
        
        boolean r = sameTree(tree.root,tree.root2);
        System.out.println(r);
        
        int size = sizeBST(tree.root);
        System.out.println("Size: "+size);
        
        int height = heightBST(tree.root2);
        System.out.println("height of a binary tree is :"+height);
    } 
} 
