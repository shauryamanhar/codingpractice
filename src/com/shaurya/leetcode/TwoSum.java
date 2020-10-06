package com.shaurya.leetcode;
import java.util.*;
public class TwoSum {

    public static void main(String[] args) {
        // int nums[] = {2,7,11,15};
        int nums[] = {3,2,4};
        int t = 6;
        // System.out.println(bs(nums, 1, nums.length, t-nums[0]));
        System.out.println(Arrays.toString(twoSum(nums, t)));
    }

    static public int[] twoSum(int[] nums, int target) {
        int sol[] = {-1,-1};
        int n = nums.length;
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            hash.put(nums[i], i);
        }

        for(int i=0;i<n;i++){
            System.out.println("a[] "+nums[i]);
            if(hash.containsKey(target-nums[i])){
                sol[0]=i;
                sol[1]=hash.get(target-nums[i]);
                if(sol[1]==i)
                    continue;
                return sol;
            }
        }
        return sol;
    }
    
}
