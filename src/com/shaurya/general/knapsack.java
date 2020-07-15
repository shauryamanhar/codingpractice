package com.shaurya.general;

import java.util.Arrays;

public class knapsack {
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 }; 
        int wt[] = new int[] { 10, 20, 30 }; 
        int W = 50;
        int dp[][] = new int[W+1][val.length+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println(knapsackMemoize(wt, val, W, val.length, dp));
        System.out.println(knapsackDp(wt, val, W));
    }

    public static int knapsackMemoize(int wt[],int val[],int W,int i,int dp[][]){
        if(i==0 || W==0){
            return 0;
        }
        if(dp[W][i]!=-1){
            return dp[W][i];
        }
        if(i-1>=0 && wt[i-1]<=W){
            int include = val[i-1]+knapsackMemoize(wt, val, W-wt[i-1], i-1, dp);
            int exclude = knapsackMemoize(wt, val, W, i-1, dp);
            dp[W][i]=Math.max(include, exclude);
            return dp[W][i];
        }else{
            return dp[W][i] = knapsackMemoize(wt, val, W, i-1, dp);
        }
    }
    public static int knapsackDp(int[] weights, int[] values, int W){
        int N = weights.length;
        int[][] dp = new int[W + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[w][i] = Math.max(dp[w - weights[i - 1]][i - 1] + values[i - 1], dp[w][i - 1]);
                } else {
                    dp[w][i] = dp[w][i - 1];
                }
            }
        }
        return dp[W][N];
    }
}