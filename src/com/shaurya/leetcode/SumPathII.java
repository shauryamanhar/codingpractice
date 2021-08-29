package com.shaurya.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SumPathII {

	public static void main(String[] args) {

	}
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        sum(root,targetSum,0,ans,new ArrayList<Integer>());
        return ans;
    }
    void sum(TreeNode root, int targetSum,int currSum,List<List<Integer>> ans,List<Integer> partial){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            if(targetSum==currSum+root.val){
                partial.add(root.val);
                List<Integer> temp = partial.stream().collect(Collectors.toList());
                partial.remove(partial.size()-1);
                ans.add(temp);
            }
            return;
        }
        partial.add(root.val);
        sum(root.left,targetSum,currSum+root.val,ans,partial);
        sum(root.right,targetSum,currSum+root.val,ans,partial);
        partial.remove(partial.size()-1);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
