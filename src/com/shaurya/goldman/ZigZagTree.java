package com.shaurya.goldman;

import java.util.Stack;

public class ZigZagTree {
	static class Tree{
		int val;
		Tree left,right;
		Tree(int val){
			this.val=val;
			left=right=null;
		}
	}
	
	public static void main(String[] args) {
		Tree root = new Tree(7);
		root.left = new Tree(9);
		root.right = new Tree(7);
		root.left.left = new Tree(8);
		root.left.right = new Tree(8);
		root.right.left = new Tree(6);
		root.left.left.left = new Tree(10);
		root.left.left.right = new Tree(9);
//		preorder(root);
		searchPath(root, 10);
//		zigZag(root);
		
	}
	static void zigZag(Tree root) {
		if(root==null) {
			return;
		}
		Stack<Tree> stack = new Stack<ZigZagTree.Tree>();
		stack.add(root);
		Tree curr=null;
		while(!stack.isEmpty()) {
			curr = stack.pop();
			System.out.println(curr.val);
			if(curr.left!=null) {
				stack.push(curr.left);
				System.out.println("add left "+curr.left.val);
			}
			if(curr.right!=null) {
				stack.push(curr.right);
				System.out.println("add right "+curr.right.val);
			}
		}
	}
	static boolean searchPath(Tree root,int data) {
		if(root==null) {
			return false;
		}
		if(root.val==data) {
			System.out.println(root.val);
			return true;
		}
		boolean left = searchPath(root.left,data);
		boolean right = searchPath(root.right, data);
		if(left || right) {
			System.out.println(root.val);
		}
		return left || right;
	}
	static void preorder(Tree root) {
		if(root==null) {
			return;
		}
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}
}
