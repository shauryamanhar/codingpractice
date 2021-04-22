package com.shaurya.gfg.dp;

public class NumberOfCoins {
	public static void main(String[] args) {
		int coins[] = {1,2,5};
		int v =7;
		System.out.println(minCoins(coins, v));
	}
	
	static int minCoins(int coins[], int v){ 
		if(v<0) {
			System.out.println("return -1");
			return -1;
		}
		if(v==0) {
			System.out.println("return 0");
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(int coin:coins) {
			System.out.println("curr coin "+coin);
			int changeFound = minCoins(coins, v-coin);
			System.out.println("changeFound "+changeFound);
			if(changeFound>=0 && min>changeFound) {
				min = 1+changeFound;
			}
			System.out.println("min "+min);
		}
		return min==Integer.MAX_VALUE?-1:min;
	} 

	
}
