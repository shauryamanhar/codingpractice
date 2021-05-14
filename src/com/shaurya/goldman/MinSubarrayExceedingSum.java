package com.shaurya.goldman;

public class MinSubarrayExceedingSum {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };
		System.out.println(minSubArray(a, 6));
	}

	static int minSubArray(int a[], int target) {
		int left = 0, right = 0, sum = 0, minWindow = Integer.MAX_VALUE;
		while (right < a.length) {
			sum += a[right];
			while (sum >= target && left < right) {
				sum -= a[left];
				minWindow = Math.min(right - left + 1, minWindow);
				left++;
			}
			right++;
		}
		return minWindow;
	}
}
