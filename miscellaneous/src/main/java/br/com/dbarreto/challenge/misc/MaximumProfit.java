package br.com.dbarreto.challenge.misc;

import java.util.List;

/*
 Given an array of a stock’s price over a week, calculate the maximum profit you could make
by buying the stock on one day and selling it on a day in the future.
 
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 
Examples:
[3,6,4,4,7,7,2] => 4 (buy at 3, sell at 7 => profit 4)
[8,2,6,4,7,1,4] => 5 (buy at 2, sell at 7 => profit 5)
[7,5,4,3,2,1,1] => 0
[7,5,4,3,4,1,1] => 1
 */
class MaximumProfit {

	public int maxProfit(List<Integer> prices) {

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < prices.size(); i++) {
			for (int j = i + 1; j < prices.size(); j++) {
				int currentProfit = prices.get(j) - prices.get(i);
				if (currentProfit > max) {
					max = currentProfit;
				}
			}
		}

		return max;
	}
	
	public int maxProfitLinear(List<Integer> prices) {

		int maxProfit = Integer.MIN_VALUE;
		int currentMinPrice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.size(); i++) {
			int currentElement = prices.get(i);
			
			if (currentElement < currentMinPrice) {
				currentMinPrice = currentElement;
			}
			
			int currentProfit = currentElement - currentMinPrice;
			if (currentProfit > maxProfit) {
				maxProfit = currentProfit;
			}
		}

		return maxProfit;
	}
}
