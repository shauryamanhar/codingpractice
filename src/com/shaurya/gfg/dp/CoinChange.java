package com.shaurya.gfg.dp;

import java.util.Arrays;
import java.util.Collections;

public class CoinChange {

	public static void main(String[] args) {
		Integer a[] = {9,1};
		System.out.println(minCoins(a, 10));
	}

	static  int minCoins(Integer coins[],int value) {
		Arrays.sort(coins, Collections.reverseOrder());
		return min(coins, value,0);
	}
	static int min(Integer coins[],int value,int idx) {
		if(value==0) {
			System.out.println("found solution");
			return 1;
		}
		if(value<0 || idx>=coins.length) {
			return 0; 
		}
		int count = 1+min(coins, value-coins[idx], idx);
		min(coins, value, idx+1);
		return count;
	}

}
