package com.shaurya.udemydp;

import java.util.Arrays;

public class HouseColorProblem {
    public static void main(String[] args) {
        int cost[][] = {{17,2,17},{16,16,5},{14,3,9}};
        int i=2;
        //simple recursion
        // System.out.println(Math.min(minCost(cost, i, RED), Math.min(minCost(cost, i, YELLOW), minCost(cost, i, BLUE))));
        //memoize
        int cache[][] = new int[cost.length+1][i+1];
        for(int j=0;j<cache.length;j++){
            Arrays.fill(cache[j],-1);
        }
        System.out.println(Math.min(minCostMemoize(cost, i, RED,cache), Math.min(minCostMemoize(cost, i, YELLOW,cache), minCostMemoize(cost, i, BLUE,cache))));
    }
    static int RED=0,BLUE=1,YELLOW=2;
    static int minCost(int cost[][],int i,int color){
        if(i==-1){
            return 0;
        }
        int costRed = 0;
        int costBlue = 0;
        int costYellow = 0;
        if(color==RED){
            costBlue = minCost(cost, i-1, BLUE);
            costYellow = minCost(cost, i-1, YELLOW);
            return cost[i][RED]+Math.min(costBlue,costYellow);
        }else if(color==BLUE){
            costRed = minCost(cost, i-1, RED);
            costYellow = minCost(cost, i-1, YELLOW);
            return cost[i][BLUE]+Math.min(costRed,costYellow);
        }else if(color==YELLOW){
            costRed = minCost(cost, i-1, RED);
            costBlue = minCost(cost, i-1, BLUE);
            return cost[i][YELLOW]+Math.min(costRed,costBlue);
        }
        return 0;
    }
    static int minCostMemoize(int cost[][],int i,int color,int cache[][]){
        if(i==-1){
            return 0;
        }
        if(cache[i][color]!=-1){
            return cache[i][color];
        }
        int costRed = 0;
        int costBlue = 0;
        int costYellow = 0;
        if(color==RED){
            costBlue = minCostMemoize(cost, i-1, BLUE,cache);
            costYellow = minCostMemoize(cost, i-1, YELLOW,cache);
            return cache[i][color]=cost[i][RED]+Math.min(costBlue,costYellow);
        }else if(color==BLUE){
            costRed = minCostMemoize(cost, i-1, RED,cache);
            costYellow = minCostMemoize(cost, i-1, YELLOW,cache);
            return cache[i][color]=cost[i][BLUE]+Math.min(costRed,costYellow);
        }else if(color==YELLOW){
            costRed = minCostMemoize(cost, i-1, RED,cache);
            costBlue = minCostMemoize(cost, i-1, BLUE,cache);
            return cache[i][color]=cost[i][YELLOW]+Math.min(costRed,costBlue);
        }
        return 0;
    }
    static int minCostDp(int costs[][],int house,int color){
        int[][] dp = new int[costs.length + 1][3];
        int n = costs.length;
        if (costs.length == 0) {
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][RED] = costs[i - 1][RED] + Math.min(dp[i - 1][BLUE], dp[i - 1][YELLOW]);
            dp[i][BLUE] = costs[i - 1][BLUE] + Math.min(dp[i - 1][RED], dp[i - 1][YELLOW]);
            dp[i][YELLOW] = costs[i - 1][YELLOW] + Math.min(dp[i - 1][RED], dp[i - 1][BLUE]);
        }
        return Math.min(dp[n][RED], Math.min(dp[n][BLUE], dp[n][YELLOW]));
    }
}