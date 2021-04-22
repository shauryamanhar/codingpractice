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

	static int mincost(int a[],int K) {
		int dp[] = new int[a.length];
		dp[1]=Math.abs(a[1]-a[0]);
		int min=1000;
		for(int i=0;i<a.length;i++) {
			for(int k=0;k<K && i-k>=0;k++) {
				if(i==(i-k)) {
					continue;
				}
				System.out.printf("i=%d |a[%d]-a[%d]+%d=%d| min=%d \n",i,a[i],a[i-k],dp[i-k],(Math.abs(a[i]-a[i-k])+dp[i-k]),min);
				min = Math.min(min, Math.abs(a[i]-a[i-k])+dp[i-k]);
			}
			min=1000;
		}
		for(int i:dp) {
			System.out.print(i+" " );
		}
		return dp[a.length-1];
	}
}
