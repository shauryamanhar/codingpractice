package com.shaurya.atcoder;

import java.util.Scanner;

public class Frog1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		System.out.println(mincost(a));
	}

	static int mincost(int a[]) {
		int dp[] = new int[a.length];
		for(int i=0;i<a.length;i++) {
			if(i-1>=0 && i-2<0) {
				dp[i]=Math.abs(a[i]-a[i-1]);
			}
			if(i-1>=0 && i-2>=0) {
				dp[i]=Math.min(dp[i-1]+Math.abs(a[i]-a[i-1]), dp[i-2]+Math.abs(a[i]-a[i-2]));
			}
		}
		return dp[a.length-1];
	}
	static int mincost(int a[], int parent, int curr, int cost) {
		if (curr >=a.length) {
			return cost;
		}
		int newcost = cost + Math.abs(a[parent] - a[curr]);
		int left = mincost(a, curr, curr + 1, newcost);
		int right = mincost(a, curr, curr + 2, newcost);
		return Math.min(left, right);
	}

}
