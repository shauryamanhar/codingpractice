package com.shaurya.slidingwindow;

import java.util.LinkedHashSet;
import java.util.Set;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new LinkedHashSet<Integer>(k);
		int start = 0;
		for(int i=0;i<nums.length;i++) {
			if(!set.add(nums[i])) {
				return true;
			}
			System.out.println(set);
			if(set.size()==k+1) {
				set.remove(nums[start]);
				start++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicateII o = new ContainsDuplicateII();
		int nums[] = {1,0,1,1};
		int k=1;
		boolean ans = o.containsNearbyDuplicate(nums, k);
		System.out.println(ans);
	}

}
