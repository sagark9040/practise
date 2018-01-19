package leet.array;

public class MaximumProfitBestTimeToBuySellStockPart2 {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <=1)
			return 0;

		int maxProfit = 0, prev = prices[0], buyPrice = Integer.MAX_VALUE;
		int day = 0;
		
		if(pricesOnlyDecrease(prices))
			return 0;
		
		int buyDay = getFirstBuyPrice(prices);
		buyPrice = prices[buyDay];
				
		boolean canBuy = false, canSell = true;
		int prevPrice = buyPrice; //3,2,6,5,0,3
		
		for(int curDay = buyDay; curDay < prices.length; curDay++) {
			int curDayPrice = prices[curDay];
			
			if (canBuy && (curDayPrice < prevPrice)) {
				canBuy = false;
				canSell = true;
				buyPrice = curDayPrice;
			} else if (canSell && curDay < prices.length - 1 && curDayPrice < prices[curDay+1]) {
				// HOLD				
			} else if (canBuy && curDay < prices.length - 1 && curDayPrice > prices[curDay+1]) {
				// DONT BUY
			} else if(curDayPrice > buyPrice && canSell) {
				maxProfit = maxProfit + (curDayPrice - buyPrice);
				canBuy = true;
				canSell = false;
			}
			prevPrice = curDayPrice;
		}
		
		
		return maxProfit;
    }
	
	private int getFirstBuyPrice(int[] prices) {
		int i = 1;
		for(i=1; i<prices.length; i++)
			if(prices[i] > prices [i-1])
				return i-1;
		
		return i;
	}

	private boolean pricesOnlyDecrease(int[] prices) {
		
		for(int i=1; i<prices.length; i++)
			if(prices[i] > prices [i-1])
				return false;
		
		return true;
	}

	public static void main(String args[]) {
		MaximumProfitBestTimeToBuySellStockPart2 maxProfit = new MaximumProfitBestTimeToBuySellStockPart2();
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

//		 [7, 6, 4, 3, 1]
