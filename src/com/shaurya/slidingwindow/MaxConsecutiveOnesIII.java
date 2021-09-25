package com.shaurya.slidingwindow;

public class MaxConsecutiveOnesIII {
	public int longestOnes(int[] nums, int k) {
		int maxLen = 0;
		int i=0,j=0;
		int count =0;
		int currLen = 0;
		while(i<nums.length) {
			if(nums[i]==0) {
				count++;
				while(count>k) {
					if(nums[j]==0) {
						count--;
					}
					j++;
				}
				currLen = i-j+1;
			}else {
				currLen++;
			}
			maxLen = Math.max(maxLen, currLen);
			i++;
		}
		return maxLen;
    }
	public static void main(String[] args) {
		MaxConsecutiveOnesIII o = new MaxConsecutiveOnesIII();
		int arr[] = {0,0,1,2,0,0,3,4,5,0,6,7,0,0,0,8,9,10,11};
		int k=3;
		int ans = o.longestOnes(arr, k);
		System.out.println(ans);

	}

}
