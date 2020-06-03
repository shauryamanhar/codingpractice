package com.shaurya.leetcode;

public class SingleElementInSortedList {

	public static void main(String[] args) {
		int nums[] = {1,1,2,2,3,3,4,4};
		System.out.println(singleNonDuplicateMooreVoting(nums));
	}
	static public int singleNonDuplicateMooreVoting(int[] nums) {
		int elementIndex=0;
		int count=1;
		boolean found=false;
		for(int i=1;i<nums.length;i++) {
			if(nums[elementIndex]==nums[i]) {
				count--;
			}else if(nums[elementIndex]!=nums[i] && count==0) {
				elementIndex=i;
				count++;
			}else if(nums[elementIndex]!=nums[i] && count!=0) {
				found=true;
				return nums[elementIndex];
			}
		}
		if(count!=0)
			return nums[elementIndex];
        return found?nums[elementIndex]:-1;
    }

}
