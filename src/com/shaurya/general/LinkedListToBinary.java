package com.shaurya.general;

public class LinkedListToBinary {
	public static void main(String[] args) {
		String s="";
	}
	static public long getnumber(String s) {
		long decimal = 0;
		int i=0;
		while(i<s.length()) {
			decimal = (decimal<<1)+(s.charAt(i)==1?1:0);
			i++;
		}
		return decimal;
	}
	static class Node{
		int n;
		Node next;
		Node(int n){
			this.n=n;
			this.next=null;
		}
	}
}
