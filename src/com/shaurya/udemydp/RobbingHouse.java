package com.shaurya.udemydp;

import java.util.Arrays;

public class RobbingHouse {
    public static void main(String[] args) {
        int house[] = {20,25,20,15,16};
        //recursion
        System.out.println(maxProfit(house, house.length-1));
        //recursion with memoization
        int cache[] = new int[house.length+1];
        Arrays.fill(cache, -1);
        System.out.println(maxProfitMemoize(house, house.length-1,cache));
        
        //dp solution
        System.out.println(maxProfitDp(house));

        //recostruction of solution
        maxProfitDpReconstructSolution(house);
    }
    //general recusive solution
    static int maxProfit(int house[],int i){
        if(i<0){
            return 0;
        }
        if(i==0){
            return house[i];
        }
        return Math.max(house[i]+maxProfit(house, i-2), maxProfit(house, i-1));
    }
    //memoization
    static int maxProfitMemoize(int house[],int i,int cache[]){
        if(i<0){
            return 0;
        }
        if(i==0){
            return house[i];
        }
        if(cache[i]!=-1){
            return cache[i];
        }
        return Math.max(house[i]+maxProfit(house, i-2), maxProfit(house, i-1));
    }
    //dp solution
    static int maxProfitDp(int house[]){
        int dp[] = new int[house.length+1];
        dp[1]=house[0];
        for(int i=2;i<=house.length;i++){
            dp[i] = Math.max(dp[i-1],house[i-1]+dp[i-2]);
        }
        return dp[house.length];
    }
    //recontruct solution
    static void maxProfitDpReconstructSolution(int house[]){
        int N = house.length;
        int dp[] = new int[N+1];
        boolean []robbed = new boolean[N];
        robbed[0]=true;
        dp[1]=house[0];
        for(int i=2;i<=N;i++){
            if(dp[i-1]<house[i-1]+dp[i-2]){
                robbed[i-1] = true;
                dp[i]=house[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1];
                robbed[i-1]=false;
            }
        }
        int ans = dp[N];
        System.out.println("Max profit is "+ans+"\nGiven below is solution");
        //print all the solution
        int i=N-1;

        while(i>=0){
            if(robbed[i]){
                System.out.println("robbed "+i+" money "+house[i]);
                i=i-2;
            }else
                i--;
        }
    }


}