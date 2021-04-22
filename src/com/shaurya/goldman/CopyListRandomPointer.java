package com.shaurya.goldman;

public class CopyListRandomPointer {

	public static void main(String[] args) {
		Node head = new Node(1);
		Node curr = head;
		for(int i=2;i<=10;i++) {
			curr.next = new Node(i);
			curr = curr.next;
		}
		print(head);
	}
	
	static void copy(Node head) {
		Node nhead = new Node(head.val);
		Node curr1=head;
		Node curr2=nhead;
		while(curr1!=null) {
//			curr2 = 
		}
	}
	
	static void print(Node head) {
		Node curr= head;
		while(curr!=null) {
			System.out.print(curr.val+"->");
			curr=curr.next;
		}
		System.out.println();
	}
	static class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}

}
