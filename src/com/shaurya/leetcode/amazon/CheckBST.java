package com.shaurya.leetcode.amazon;

public class CheckBST {

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);
		System.out.println(checkBst(root));
	}
	static boolean checkBst(Node root) {
		return checkBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	static boolean checkBstUtil(Node root,int min,int max) {
		if(root==null) {
			return true;
		}
		if(root.data>=min && root.data<=max) {
			return checkBstUtil(root.left, min, root.data) && checkBstUtil(root.right, root.data, max);
		}
		return false;
	}
	static class Node{
		Node left,right;
		int data;
		Node(int d){
			data=d;
			left=right=null;
		}
	}

}











class Demo{
	static Demo instance;
	private Demo() {}
	synchronized public static Demo getInstance() {
		if(instance==null) {
			instance = new Demo();
		}
		return instance;
	}
}

