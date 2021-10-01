package com.shaurya.leetcode;

public class SplitLinkedListParts {

	public ListNode[] splitListToParts(ListNode head, int k) {
		ListNode[] ans = new ListNode[k];
		int len = size(head);
		int part = len/k;
		int remains = len%k;
		int i=0;
		ListNode curr = head;
		for(i=0;i<remains;i++) {
			int count =0;
			ans[i] = curr;
			while(curr!=null && count!=part) {
				curr = curr.next;
				count++;
			}
			if(curr==null) {
				break;
			}
			ListNode temp = curr;
			curr = curr.next;
			temp.next=null;
		}
		for(;i<k;i++) {
			if(curr==null) {
				continue;
			}
			int count = 0;
			ans[i] = curr;
			while(curr!=null && count!=part-1) {
				curr = curr.next;
				count++;
			}
			if(curr==null) {
				break;
			}
			ListNode temp = curr;
			curr = curr.next;
			temp.next = null;
		}
		return ans;
		
	}
	private int size(ListNode head) {
		int c=0;
		while(head!=null) {
			head = head.next;
			c++;
		}
		return c;
	}

	public static void main(String[] args) {

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
