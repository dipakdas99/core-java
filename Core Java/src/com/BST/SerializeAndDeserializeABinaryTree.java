package com.BST;

import com.BST.Node;
import java.util.ArrayList;
import java.util.Stack;
public class SerializeAndDeserializeABinaryTree {
	Node root;
	private String serialize (Node node, ArrayList<Integer> aa){
		serhelp(root,aa);
        String ans="";
        for (int i=0;i<aa.size();i++){
            ans+=aa.get(i)+" ";
        }
        return ans;
	}
	
	private void serhelp(Node root, ArrayList<Integer> arr) {
		if (root==null){
            arr.add(-1);
            return;
        }
        
        arr.add(root.key);
        serhelp(root.left,arr);
        serhelp(root.right,arr);
		
	}
	 public static int index=0;
	    public static Node deserhelp(ArrayList<Integer> arr){
	        if (index==arr.size() || arr.get(index)==-1){
	            index++;
	            return null;
	        }
	        
	        Node root = new Node(arr.get(index));
	        index++;
	        
	        root.left=deserhelp(arr);
	        root.right=deserhelp(arr);
	        
	        return root;
	    }
	protected Node deSerialize(String data){
		ArrayList<Integer> arr = new ArrayList<>();
        String splited[] = data.split("\\s+");
        for (int i=0;i<splited.length;i++){
            arr.add(Integer.parseInt(splited[i]));
        }
        
        Node ans = deserhelp(arr);
        index=0;
        return ans;
		
	}
	public static void main(String[] args) {
		SerializeAndDeserializeABinaryTree tree = new SerializeAndDeserializeABinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
		tree.root.right = new Node(30);
		tree.root.left.left = new Node(40);
		tree.root.left.right = new Node(60);
		ArrayList<Integer> list = new ArrayList<Integer>();
		String str = tree.serialize(tree.root, list);
		System.out.println(str);
		tree.deSerialize(str);
	}

}
