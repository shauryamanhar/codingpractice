package com.shaurya.slidingwindow;

public class NumberSubArraysSizeKAverageThreshold {
	public int numOfSubarrays(int[] arr, int k, int threshold) {
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		int avg = sum / k;
		int count = 0;
		if (avg >= threshold) {
			count++;
		}
		for (int i = k; i < arr.length; i++) {
			// remove
			sum -= arr[i - k];
			// add
			sum += arr[i];
			// update value
			avg = sum / k;
			if (avg >= threshold) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		NumberSubArraysSizeKAverageThreshold o = new NumberSubArraysSizeKAverageThreshold();
		int arr[] = { 4,4,4,4 };
		int k = 4;
		int threshold = 1;
		int ans = o.numOfSubarrays(arr, k, threshold);
		System.out.println(ans);
	}
}
