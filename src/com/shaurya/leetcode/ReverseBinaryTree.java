package com.shaurya.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.text.Position;

public class ReverseBinaryTree {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val=val;
			left=null;
			right=null;
		}
	}
	
static 	TreeNode root2 = null;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
		
		ReverseBinaryTree r = new ReverseBinaryTree();
		r.postorder(root);
		r.invertTree(root);
		System.out.println();
		r.postorder(root);
		
	}
	public void invertTree(TreeNode root) {
		if(root==null)
			return;
		invertTree(root.left);
		invertTree(root.right);
		TreeNode temp = root.left;
		root.left=root.right;
		root.right=temp;
    }
	public void postorder(TreeNode root) {
		Queue<TreeNode> stack = new LinkedList<ReverseBinaryTree.TreeNode>();
		stack.add(root);
		stack.add(null);
		while(!stack.isEmpty()) {
			root = stack.remove();
			if(root==null) {
				if(!stack.isEmpty()) {
					stack.add(null);
				}
				continue;
			}else {
				System.out.print(root.val+", ");
				if(root.left!=null)
					stack.add(root.left);
				if(root.right!=null)
					stack.add(root.right);
			}
		}
		System.out.println();
	}
	
}
