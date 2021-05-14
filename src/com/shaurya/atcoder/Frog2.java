package com.shaurya.atcoder;

import java.util.Scanner;

public class Frog2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int K = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		System.out.println(mincost(a,K));
	}

	static int mincost(int a[],int k) {
		int dp[] = new int[a.length];
		dp[1]=Math.abs(a[1]-a[0]);
		int min=1000;
		for(int i=2;i<a.length;i++) {
			min = Integer.MAX_VALUE;
			for(int j=1;j<=k;j++) {
				if(i-j>=0) {
					min = Math.min(min, dp[i-j]+Math.abs(a[i]-a[i-j]));
				}
			}
			dp[i]=min;
		}
		return dp[a.length-1];
	}
}
