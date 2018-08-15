package leet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reconstruct {
	//1138
	//will it form zero sequences too? or at least one?
	//step 1: O(n) go through all of the inputs and form a->b graph, if multiple a's exist then array-fy the b's. Mark the origin JFK as point zero.
	//step 2: go from the origin (JFK) and mark the 'a' points visited and keep visiting their b's.
	//ex 2: jfk-->sfo, atl ... sfo-->atl ... atl-->jfk,sfo
	//start at jfk.. add to list .. jfk to sfo, go to sfo .. add atl .. go to at atl .. jfk .. add atl sfo
	//jfk sfo atl jfk atl sfo
	
	
	public List<String> findItinerary(String[][] tickets) {
		
		Flight[] allFlights = initFlightGraph(tickets);
		
		return null;        
    }
	
	private Flight[] initFlightGraph(String[][] tickets) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		for(String[] ticket:tickets) {
			String from = ticket[0];
			String to = ticket[1];
				
			String[] destinations;
			if(map.containsKey(from)) {
				destinations = new String[map.get(from).length+1];
				destinations = map.get(from);
				
			} else {
				String[] d = new String[]{to};
				map.put(from, d);
			}
			
		}
		
		
		
		return null;
	}

	
}

class Flight{
	String from;
	String to;
	
	
}
/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. 
All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. 
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
*/