package com.LinkedList;

public class RemoveDuplicates {
	Node head;  // head of list 

	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {
			data = d; 
			next = null; 
		} 
	} 

	public void append(int new_data){
		Node new_node = new Node(new_data);
		if (head == null){
			head = new Node(new_data);
			return;
		}
		new_node.next = null;
		Node last = head;
		while (last.next != null){
			last = last.next;
		}
		last.next = new_node;
		return;
	}
	private void printList(){
		if (head == null)
			return;
		Node last = head;
		while (last != null){
			System.out.print(last.data+" ");
			last = last.next;
		}
	}
	private void removeDuplicate(){
		if (head == null || head.next == null)
			return;
		Node root = head;
		while (root.next != null){
			
			if (root.data == root.next.data){
				root.next = root.next.next;
			}else
				root = root.next;
		}
	}
	public static void main(String[] args) {
		RemoveDuplicates llist = new RemoveDuplicates();
		llist.append(1);
		llist.append(1);
		llist.append(2);
		llist.append(2);
		llist.append(3);
		llist.append(3);
		llist.append(4);
		llist.append(4);
		llist.printList();
		llist.removeDuplicate();
		System.out.println();
		llist.printList();
	}

}
