package com.shaurya.leetcode;

import java.util.HashMap;

public class MajorityElement {
	public static void main(String[] args) {
		int a[] = {2,2,1,1,1,2,2};
		System.out.println(majorityElement_using_hashmap(a));
		System.out.println(mooreVoting(a));
	}
	static int mooreVoting(int a[]) {
		//case for  2 2 2 3 4 and 2 3 7 3 4
		int maj_index = 0, count = 1; 
		for (int i = 1; i < a.length; i++) 
		{ 
			if (a[maj_index] == a[i]) 
				count++; 
			else
				count--; 
			if (count == 0) 
			{ 
				maj_index = i; 
				count = 1; 
			} 
		} 
		if(count>=(a.length/2)) {
			return a[maj_index];
		}else {
			//majority element must have count >= n/2 
			return -1;
		}
	}
	static public int majorityElement_using_hashmap(int[] nums) {
		if(nums.length==1) {
			return nums[0];
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i:nums) {
			if(map.containsKey(i) && map.get(i)>=(nums.length/2)) {
				return i;
			}else {
				map.put(i, map.getOrDefault(i, 0)+1);
			}
		}
		return -1;
	}
}
