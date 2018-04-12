package leet.dfsBfs;

import java.util.ArrayList;
import java.util.List;

public class LC638M_ShoppingOffers {

	// 1040 .. 29 min AC
	// Coding shortening ways:
	// 
	
	
	// total prices without any offers

	// needs is the starting point
	// iterate special offers one by one
	// if the items in needs < special offer then add price of regular purchase
	// else simply reduce the count in needs and add the price
	// backtrack with the needs reset to pre-deduction value

	// cut off is needs is all zero display the price

	int priceWithPromo = Integer.MAX_VALUE;

	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

		int priceWithoutPromo = 0;
		int i = 0;
		for (int need : needs) {
			priceWithoutPromo += need * price.get(i);
			i++;
		}

		dfs(price, special, needs, 0);
		return priceWithoutPromo < priceWithPromo ? priceWithoutPromo : priceWithPromo;
	}

	public void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int cost) {
		if (needsZero(needs)) {
			priceWithPromo = Math.min(priceWithPromo, cost);
			return;
		}

		for (List<Integer> offer : special) {
			List<Integer> prevNeeds = new ArrayList<>(needs);
			int origCost = cost;

			if (needsLessThanOffer(needs, offer)) {
				for (int i = 0; i < needs.size(); i++) {
					if (needs.get(i) > 0) {
						cost += price.get(i) * needs.get(i);
						needs.set(i, 0);
					}
				}
			} else {
				for (int i = 0; i < needs.size(); i++) {
					if (needs.get(i) > 0) {
						needs.set(i, needs.get(i) - offer.get(i));
					}
				}
				cost += offer.get(offer.size() - 1);
			}

			dfs(price, special, needs, cost);
			cost = origCost;
			needs = new ArrayList<>(prevNeeds);
		}
	}

	public boolean needsLessThanOffer(List<Integer> needs, List<Integer> offer) {
		for (int i = 0; i < needs.size(); i++) {
			if (needs.get(i) < offer.get(i)) {
				return true;
			}
		}
		return false;
	}

	public boolean needsZero(List<Integer> needs) {
		for (int need : needs) {
			if (need > 0) {
				return false;
			}
		}
		return true;
	}

}