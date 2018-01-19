package leet.array;

public class LC122E_MaximumProfitBestTimeToBuySellStockPart2 {
	
	// Thoughts: Tried to do it manually. Didn't even consider the two array approach.
	// DIDNT ASK THE QUESTION WHERE IN SELLING AND BUYING ON THE SAME DAY IS A PROBLEM!!!!
	
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
	    for (int i=0; i< prices.length-1; i++) {
	        if (prices[i+1]>prices[i]) maxProfit += prices[i+1]-prices[i];
	    }
	    
	    return maxProfit;
    }

	public static void main(String args[]) {
		LC122E_MaximumProfitBestTimeToBuySellStockPart2 maxProfit = new LC122E_MaximumProfitBestTimeToBuySellStockPart2();
		System.out.println(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		System.out.println(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 4, 6}));
		System.out.println(maxProfit.maxProfit(new int[]{7, 6, 4, 3, 1}));
		System.out.println(maxProfit.maxProfit(new int[]{1, 2}));
		System.out.println(maxProfit.maxProfit(new int[]{3,2,6,5,0,3}));
	}
}

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

//Input: [7, 1, 5, 3, 6, 4]
//		 [0, -1, 5, -3, 6, 0]
//            1->5   3->6 = 7

//		 [7, 1, 5, 3, 4, 6, 2, 1, 0]
//		 [7, 1, 1, 1, 1, 1, 1, 1, 0]
// 		 [6	 6	6  6  6	 6	2  1  0]

