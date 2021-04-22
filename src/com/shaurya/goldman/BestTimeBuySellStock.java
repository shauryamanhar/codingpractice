package com.shaurya.goldman;

public class BestTimeBuySellStock {
	public static void main(String[] args) {
			int prices[] = {7,1,5,3,6,4};
			System.out.println(maxProfit(prices));
	}
    static int maxProfit(int[] prices) {
    	int max=0;
    	int minPrice=Integer.MAX_VALUE;
    	for(int i=0;i<prices.length;i++) {
    		if(prices[i]<minPrice) {
    			minPrice = prices[i];
    		}else if(prices[i]-minPrice>max) {
    			max = prices[i]-minPrice;
    		}
    	}
        return max;
    }
}
