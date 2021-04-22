package com.shaurya.leetcode;

public class MinimumOperationsReduceXtoZero {

	public static void main(String[] args) {
		int nums[] = {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
		int x=134365;
		int count = minOperations(nums, x);
		System.out.println("count "+count);
	}
    static public int minOperations(int[] nums, int x) {
    	//Find the max sub array with (sum(nums)-x) 
    	int sum = 0;
    	for(int n:nums) {
    		sum+=n;
    	}
    	int target = sum - x;
    	int i=0,j=0;
    	sum=0;
    	int len=0;
    	if(target==0) {
    		return nums.length;
    	}
    	while(j<nums.length) {
    		sum = sum + nums[j];
    		while(sum>target && i<=j) {
    			sum = sum - nums[i];
    			i++;
    		}
    		if(sum==target) {
    			len = Math.max(len, (j-i+1));
    		}
    		j++;
    	}
    	if(len==0) {
    		return -1;
    	}
        return nums.length-len;
    }

}
