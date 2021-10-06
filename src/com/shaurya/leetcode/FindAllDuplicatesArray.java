package com.shaurya.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesArray {

	public static void main(String[] args) {
		int nums[] = {1};
		System.out.println(findDuplicates(nums));
	}
	static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicate = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++) {
        	int val = Math.abs(nums[i]);
        	if(nums[val-1]<0) {
        		duplicate.add(val);
        	}else if(nums[val-1]<0) {
    			nums[val-1]=-nums[val-1];
        	}
        }
        return duplicate;
    }

}
