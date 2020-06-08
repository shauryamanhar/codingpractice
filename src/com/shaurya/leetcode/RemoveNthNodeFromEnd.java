package com.shaurya.leetcode;

import java.util.Stack;

public class RemoveNthNodeFromEnd {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int v){
			next=null;
			val=v;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		print(head);
		head = remove(head, 2);
		print(head);
	}
	
	static ListNode remove(ListNode head,int n) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode curr = head;
		while(curr!=null) {
			stack.push(curr);
			curr = curr.next;
		}
		int i=n;ListNode prev=null,last=null;
		while(i-->0 && !stack.isEmpty()) {
			prev = last;
			last = stack.pop();
		}
		if(prev!=null) {
			last.val=prev.val;
			last.next=prev.next;
			return head;
		}else {
			if(!stack.isEmpty()) {
				prev=stack.pop();
				prev.next=null;
				return head;
			}else {
				return null;
			}
		}
	}
	
	
	static void print(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"->");
			head=head.next;
		}
		System.out.println();
	}

}
