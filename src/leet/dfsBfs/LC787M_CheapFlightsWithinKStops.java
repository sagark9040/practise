package leet.dfsBfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC787M_CheapFlightsWithinKStops {

	// 804

	// use the info to create adj list
	// iterate from src and reach bfs till dst, max hops = k

	// hop = 0 ... till k
	// init price = Integer.MAX_VALUE;

	// 804

	// use the info to create adj list
	// iterate from src and reach bfs till dst, max hops = k

	// hop = 0 ... till k
	// init price = Integer.MAX_VALUE;

	// 904 redo coding .. 6 min coding done AC!!!!!

	int price = Integer.MAX_VALUE;

	Map<Integer, List<Ticket>> map = new HashMap<>();

	public void getMap(int[][] flights) {
		for (int[] flight : flights) {
			List<Ticket> tickets = new ArrayList<>();
			tickets.add(new Ticket(flight[1], flight[2]));

			if (map.containsKey(flight[0])) {
				tickets.addAll(map.get(flight[0]));
			}

			map.put(flight[0], tickets);
		}
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		getMap(flights);
		dfs(src, dst, 0, 0, K);
		return price == Integer.MAX_VALUE ? -1 : price;
	}

	void dfs(int src, int dst, int tempPrice, int hops, int K) {
		if (tempPrice > price || hops > K) {
			return;
		}

		if (map.containsKey(src)) {
			for (Ticket t : map.get(src)) {
				int d = t.d;
				int p = t.p;

				if (d == dst) {
					price = Math.min(price, tempPrice + p);
				}

				dfs(d, dst, tempPrice + p, hops + 1, K);
			}
		}
	}
}

class Ticket {
	int d;
	int p;

	Ticket(int desti, int price) {
		d = desti;
		p = price;
	}
}