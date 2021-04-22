package com.shaurya.slidingwindow;

public class FindSubarrayGivenSum {
	public static void main(String[] args) {
//		int a[] = {2, 6, 0, 9, 7, 3, 1, 4, 1, 10};
//		int a[] = {0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10};
		int a[] = {0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10};
		int sum = -3;
		findSubarrayWithSum(a, sum);
	}
	static void findSubarrayWithSum(int a[],int target) {
		int sum=0;
		int i=0,j=0;
		while(j<a.length) {
			sum=sum+a[j];
			while(sum>target && i<=j) {
				sum=sum-a[i];
				i++;
			}
			if(sum==target) {
				System.out.println("len "+(j-i+1));
			}
			j++;
		}
	}
}
