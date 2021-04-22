package com.shaurya.gfg.dp;

public class Knapsack {
	public static void main(String[] args) {
		int val[] = {1,2,3};
		int wt[] = {4,5,6};
		int W = 3;
		System.out.println(knapsack(val, wt, val.length-1, W, 0));
		knapsackDp(val, wt, W);
	}
	static int knapsack(int val[],int wt[],int i,int W,int value) {
		if(i<0) {
			return value;
		}
		int max=-1;
		if(W-wt[i]>=0) {
			max = Math.max(max, knapsack(val, wt, i-1, W-wt[i], value+val[i]));
		}
		return Math.max(max, knapsack(val, wt, i-1, W, value));
	}
	static int knapsackDp(int val[],int wt[],int W) {
		int N = val.length;
		int dp[][] = new int[W+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int w=1;w<=W;w++) {
				if(wt[i-1]<=w) {
					dp[w][i] = Math.max(val[i-1]+dp[w-wt[i-1]][i-1], dp[w][i-1]);
				}else {
					dp[w][i] = dp[w][i-1];
				}
			}
		}
		return dp[W][N];
	}
}
