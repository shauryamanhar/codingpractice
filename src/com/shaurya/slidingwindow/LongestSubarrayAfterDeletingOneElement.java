package com.shaurya.slidingwindow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestSubarrayAfterDeletingOneElement {

	public int longestSubarray(int[] nums) {
		int i = 0, j = 0;
		int maxCount = 0;
		int count0 = 0;
		int count1 = 0;
		while (i < nums.length) {
			if (nums[i] == 0) {
				count0++;
				while (count0 > 1 && j < i) {
					// remove 0
					if (nums[j] == 0) {
						count0--;
					}else {
						count1--;
					}
					j++;
				}
				
			}else {
				count1++;
			}
			i++;
			maxCount = Math.max(maxCount,count1);
		}
		//remove at least 1
		if(count1==nums.length) {
			return maxCount-1;
		}
		return maxCount;
	}

	public static void main(String[] args) throws FileNotFoundException {
		LongestSubarrayAfterDeletingOneElement o = new LongestSubarrayAfterDeletingOneElement();
		int nums[];
		int t;
		int n;
		Scanner sc = new Scanner(new File("res/testcase.txt"));
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int ans = o.longestSubarray(nums);
			System.out.println(ans);
		}
	}

}


//6
//1
//0
//1
//1
//3
//1 1 1
//4
//1 1 0 1
//9
//0 1 1 1 0 1 1 0 1
//3
//1 1 1
//9
//1 1 0 0 1 1 1 0 1
//3
//0 0 0
