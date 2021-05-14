package com.shaurya.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int a[] = {8,7,6,9};
		int k =3;
		System.out.println(Arrays.toString(maxSlidingWindow(a, k)));
	}
	
	static int[] maxSlidingWindow(int nums[],int k) {
        Deque<Integer> decreasingQueue = new LinkedList<Integer>();
		int ans[] = new int[nums.length-k+1];
		int index=0;
		for(int i=0;i<nums.length;i++) {
			//pop smaller values from q in end
			while(!decreasingQueue.isEmpty() && nums[decreasingQueue.peekLast()]<nums[i]) {
				decreasingQueue.pollLast();
			}
			//add index to queue
			decreasingQueue.offerLast(i);
			//remove element from queue when it get outside the window
			while(decreasingQueue.peekFirst() <= i-k) {
				decreasingQueue.pollFirst();
			}
			//add to ans when window size completed
			if(i>=k-1) {
				ans[index++]=nums[decreasingQueue.peekFirst()];
			}
		}
		return ans;
	}
	
}
