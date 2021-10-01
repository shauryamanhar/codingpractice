package com.shaurya.leetcode;

import java.util.Arrays;

public class SortArrayByParityII {
	//space o(1)
    public int[] sortArrayByParityII(int[] nums) {
    	int even=0;
    	int odd=1;
    	for(int i=0;i<nums.length;i++) {
    		while(nums[i]%2==0 && i%2!=0) {
    			swap(nums,i,even);
    			even=even+2;
    		}
    		while(nums[i]%2==1 && i%2!=1) {
    			swap(nums,i,odd);
    			odd = odd+2;
    		}
    	}
    	return nums;
    }
    void swap(int arr[],int i,int j) {
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j]=temp;
    }
	
	public static void main(String[] args) {
		int a[] = {1,2,3,4};
		SortArrayByParityII p = new SortArrayByParityII();
		int ans[] = p.sortArrayByParityII(a);
		System.out.println(Arrays.toString(ans));
	}
}
