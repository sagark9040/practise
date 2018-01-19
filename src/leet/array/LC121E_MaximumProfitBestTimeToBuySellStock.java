package leet.array;

public class LC121E_MaximumProfitBestTimeToBuySellStock {

	// THOUGHTS - 125p
	// Two ways to do this:
	// First: Two extra arrays, 1st calculates min from left to right, 2nd max from right to left. Max diff is the answer. Linear time and space
	// Second: Square time, constant space. Compare each element with 
	
	// ASSUMPTION: No negative values
	
	// TCs
	// empty prices
	// one element in prices
	// all increasing - basically sell last - buy first.
	// all decreasing - 0 profit
	// regular values
	
	
	// O(n) time and space
	public int maxProfit(int[] prices) {
		
		if (prices == null || prices.length == 0)
			return 0;
		
		int[] min = new int[prices.length];
		int[] max = new int[prices.length];
		
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		int i=0;
		
		for (int curPrice: prices) {			
			if(curPrice < minVal) {
				min[i] = curPrice;
				minVal = min[i];
			}
			else
				min[i] = minVal;			
			i++;
		}
		
		for (i=prices.length-1; i>=0; i--) {
			int curPrice = prices[i];
			
			if(curPrice > maxVal)
				max[i] = curPrice;
			else {
				max[i] = maxVal;
				maxVal = max[i];
			}			
		}
		
		int maxProfit = 0;
		
		for(i=0; i<prices.length; i++) {
			if(max[i] - min[i] > maxProfit)
				maxProfit = max[i] - min[i];
		}
		
        return maxProfit;
    }
	
	public static void main(String args[]) {
		LC121E_MaximumProfitBestTimeToBuySellStock maxProfit = new LC121E_MaximumProfitBestTimeToBuySellStock();
		System.out.println(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		System.out.println(maxProfit.maxProfit(new int[]{7, 6, 4, 3, 1}));
	}

}

/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
*/