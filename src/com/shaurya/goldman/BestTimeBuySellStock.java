package com.shaurya.goldman;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeBuySellStock {
	public static void main(String[] args) {
			int prices[] = {7,1,5,3,6,4};
			System.out.println(maxProfit(prices));
	}
    static int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += (prices[i] - prices[i - 1]);
			}
		}
		return profit;
    }
}

/*


7 1 5 3 6 4
  b s b s b
    4   3  +7

1,2,3,4,5
  1 1 1 1 +4
7 1 5 3 6 4
    4   3   +7
         
7 6 4 3 1
          +0

1 5 3 2 1 9
  4       8 +12 

*/