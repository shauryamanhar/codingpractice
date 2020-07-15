package com.shaurya.udemydp;

import java.util.Arrays;

public class CuttingRodProblem {
    public static void main(String[] args) {
        int rodPrice[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; //index represents the length of the rod
        int length=8;
        System.out.println(maxProfit(length,rodPrice));
        //cache
        int cache[] = new int[rodPrice.length+1];
        Arrays.fill(cache,-1);
        System.out.println(maxProfitCache(length, rodPrice, cache));
        //dp solution
        System.out.println(maxProfitDp(length, rodPrice));
    }

    static int maxProfit(int l,int p[]){
        if(l==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<l;i++){
            max =  Math.max(max,p[i]+maxProfit(l-i-1,p));
        }
        return max;
    }
    static int maxProfitCache(int l,int p[],int cache[]){
        if(l==0){
            return 0;
        }
        if(cache[l]!=-1){
            return cache[l];
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<l;i++){
            max =  Math.max(max,p[i]+maxProfit(l-i-1,p));
        }
        cache[l] = max;
        return max;
    }
    static int maxProfitDp(int L,int p[]){
        int dp[] = new int[L+1];
        //generate all input the input to proble and goes to 1 to L
        for(int l=1;l<=L;l++){
            dp[l] = Integer.MIN_VALUE;
            //this is for calculating the max profit of the subproblem
            for (int i = 0; i < l; i++) {
                dp[l] = Math.max(dp[l], p[i]+dp[l-i-1]);
            }
        }
        return dp[L];
    }
}