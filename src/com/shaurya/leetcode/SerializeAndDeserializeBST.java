// package com.shaurya.leetcode;

// import java.util.*;

// public class SerializeAndDeserializeBST {
//     static StringBuffer sb = new StringBuffer();
//     static class TreeNode{
//         int val;
//         TreeNode left,right;
//         TreeNode(int val){
//             this.val=val;
//             left=right=null;
//         }
//     }//treenode

//     static public void serialize(TreeNode root) {
//         if(root==null){
//             return;
//         }
//         sb.append(root.val+" ");
//         serialize(root.left);
//         serialize(root.right);
//     }

//     static public TreeNode deserialize(TreeNode root,String data[],int i) {
//         if(i<0 || i>=data.length){
//             return null;
//         }
//         TreeNode root = new TreeNode(new Integer(data[i]));
//         deserialize(root.left,data, i+1);
//         deserialize(root.right,data, i+1);
//         return root;
//     }

//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(1);
//         root.left=new TreeNode(2);    
//         root.right=new TreeNode(3);
//         root.left.left=new TreeNode(4);    
//         root.left.right=new TreeNode(5);
//         root.right.left=new TreeNode(6);
//         root.right.right=new TreeNode(7);
  
//         serialize(root);
//         System.out.println("serialize "+sb.toString());
//         TreeNode head = deserialize(, sb.toString().split(" "), 0);
//         print(head);
//     }
//     static void print(TreeNode root){
//         Queue<TreeNode> q = new LinkedList<TreeNode>();
//         q.add(root);
//         while(!q.isEmpty()){
//             root = q.poll();
//             System.out.print(root.val+" ");
//             if(root.left!=null){
//                 q.add(root.left);
//             }
//             if(root.right!=null){
//                 q.add(root.right);
//             }
//         }
//     }//
// }
