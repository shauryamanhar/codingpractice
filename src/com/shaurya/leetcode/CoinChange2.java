package com.shaurya.leetcode;

import java.util.Arrays;

public class CoinChange2 {

	public static void main(String[] args) {
		int coins[] = {1,2,3},amount=5;//ans 5
		System.out.println(countRecusion(coins,0,amount));
		
		
		//method 2
		int dp[][]= new int[coins.length][amount+1];
		for(int i=0;i<coins.length;i++)
			Arrays.fill(dp[i], -1);
		System.out.println(countRecusionMemory(coins,0,amount,dp));
	}
	//recursive solution
	static int countRecusion(int coins[],int i,int amount) {
		if(amount==0) {//return 1 because there is only one way to change amount 0 is 1 
			return 1;
		}
		
		if(amount<0 || i==coins.length) {//in case of negative amount there is no way to make change
			return 0;//in i==coins.lenght there is no coin left for change and we already used all
		}
		
		//now we try to choose coin i or not choose coint i
		return countRecusion(coins,i,amount-coins[i])+countRecusion(coins,i+1,amount);//check one note for recursion tree
	}
	
	//recursive with memorization
	static int countRecusionMemory(int[] coins, int i, int amount, int[][] dp) {
		if(amount==0) {//return 1 because there is only one way to change amount 0 is 1 
			return 1;
		}
		
		if(amount<0 || i==coins.length) {//in case of negative amount there is no way to make change
			return 0;//in i==coins.lenght there is no coin left for change and we already used all
		}
		
		//check with recursion is repeating or not
		if(dp[i][amount]!=-1) {
			return dp[i][amount];
		}
		
		//now we try to choose coin i or not choose coint i
		return dp[i][amount]=countRecusionMemory(coins,i,amount-coins[i],dp)+countRecusionMemory(coins,i+1,amount,dp);//check one note for recursion tree
	}
	
}
