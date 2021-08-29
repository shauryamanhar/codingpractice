package com.shaurya.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {
		int a[] = {4,4,4,1,4};
		subsetsWithDup(a);
	}
	static List<List<Integer>> subsetsWithDup(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		HashSet<String> set = new HashSet<String>();
		set.add("");
		for(int i=0;i<(1<<n);i++) {
			StringBuilder s= new StringBuilder();
			for(int j=0;j<n;j++) {
				if((i&(1<<j))!=0) {
					s.append(nums[j]);
					s.append(";");
				}
			}
			set.add(s.toString());
		}
		List<List<Integer>> ans = new ArrayList<>();
		for(String str:set) {
			String s[] = str.split(";");
			List<Integer> list = new ArrayList<>();
			for(String r:s) {
//				if(r.isBlank()) {
//					continue;
//				}
				list.add(Integer.valueOf(r));
			}
			ans.add(list);
		}
		return ans;
	}
}
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return subsets;
        
        // Build num count map
        int[] cntMap = new int[21];
        for (int i = 0; i < nums.length; i++) {
            cntMap[nums[i] + 10] += 1; 
        }
        
        // backtrack
        backtrack(cntMap, 0, new int[21], subsets);
        
        return subsets;
    }
    
    private void backtrack(int[] cntMap, int ind, int[] currSet, List<List<Integer>> subsets) {
        // Add result
        if (ind >= cntMap.length) {
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < currSet.length; i++) {
                int cnt = currSet[i];
                while (cnt > 0) {
                    curr.add(i - 10);
                    cnt--;
                }
            }
            subsets.add(curr);
            return;
        }
        
        for (int i = 0; i <= cntMap[ind]; i++) {
            currSet[ind] = i;
            backtrack(cntMap, ind + 1, currSet, subsets);
        }
    }
}
