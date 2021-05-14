package com.shaurya.goldman;

public class RotateLinkedListByK {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		print(head);
		rotateRightByK(head, 3);
	}
	static class Node{
		int val;
		Node next;
		Node(int val){
			this.val=val;
			this.next=next;
		}
	}
	static void rotateRightByK(Node head,int k) {
		int len = 0;
		Node curr = head;
		while(curr!=null) {
			curr = curr.next;
			len++;
		}
		System.out.println("len found "+len);
		int step = len -(k%len);
		if(step<=0) {
			System.out.println("didn't rotate step<=0");
			return;
		}
		curr = head;
		while(curr!=null && step-1>0) {
			step--;
			curr = curr.next;
		}
		System.out.println("curr at "+curr.val);
		Node temp = curr.next;
		Node p = curr.next;
		curr.next=null;
		while(p.next!=null) {
			p = p.next;
		}
		p.next = head;
		head = temp;
		print(head);
	}
	static void print(Node head) {
		Node curr = head;
		while(curr!=null) {
			System.out.print(curr.val+"->");
			curr = curr.next;
		}
		System.out.println();
	}
}
