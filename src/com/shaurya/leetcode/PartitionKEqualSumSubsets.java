package com.shaurya.leetcode;


public class PartitionKEqualSumSubsets {

	public static void main(String[] args) {
		int a[] = {4,3,2,3,5,2,1};
		int k = 4;
		PartitionKEqualSumSubsets p = new PartitionKEqualSumSubsets();
		System.out.println(p.canPartitionKSubsets(a, k)); 
	}
    boolean canPartitionKSubsets(int[] nums, int k) {
    	boolean vis[] = new boolean[nums.length];
    	int sum =0;
    	for(int n:nums) {
    		sum+=n;
     	}
    	if(sum%k!=0) {
    		return false;
    	}
        return combinationSum(nums, vis, 0, 0, sum/k, k);
    }
    private boolean combinationSum(int nums[],boolean vis[],int curr,int partial,int target,int k) {
    	if(k==0) {
    		return true;
    	}
    	if(partial>target) {
    		return false;
    	}
    	if(partial==target) {
    		return combinationSum(nums, vis,0, 0, target, k-1);
    	}
    	for(int i=curr;i<nums.length;i++) {
    		if(vis[i]==true) {
    			continue;
    		}
    		vis[i]=true;
    		if(combinationSum(nums, vis, curr+1, partial+nums[i], target, k)) {
    			return true;
    		}
    		vis[i]=false;
    	}
    	return false;
    }

}
