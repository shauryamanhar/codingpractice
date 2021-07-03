package com.shaurya.gfg;

public class CoinPiles {
	public static void main(String[] args) {
		int arr[] = {1,3};
		int n = arr.length;
		int k = 0;
		System.out.println(minSteps(arr, n, k));
	}
	static int minSteps(int a[],int n,int k) {
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			min = Math.min(min, a[i]);
		}
		int minSteps = 0;
		System.out.println("min "+min);
		for(int i=0;i<n;i++) {
			int diff = a[i] - min;
			if(diff>k) {
				minSteps += (diff-k);
			}
		}
		return minSteps;
	}
}
