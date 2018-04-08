package leet.dfsBfs;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoute {
	public Map<Integer, Set<Integer>> getMap(int[][] routes) {
        Map<Integer, Set<Integer>> connMap = new HashMap<Integer, Set<Integer>>();
        
        for(int[] route:routes) {
            for(int stop:route) {
            	if(!connMap.containsKey(stop)) {
            		connMap.put(stop, new HashSet<Integer>());
            	}
            	Set<Integer> prev = connMap.get(stop);
            	prev.addAll(addOthers(route, stop));
            	
            }
        }
        return connMap;        
    }
    
    private Set<Integer> addOthers(int[] route, int curStop) {

    	Set<Integer> set = new HashSet<Integer>();
    	for(int stop:route){
    		if(stop != curStop)
    			set.add(stop);
    	}
    	
    	
		return set;
	}

	public boolean contains(int[][] routes, int target) {
        for(int[] route:routes) {
            for(int stop:route) {
                if(stop == target) {
                    return true;
                }
            }
        }
        return false;        
    }
    
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(routes == null || routes.length == 0 || !contains(routes, S) || !contains(routes, T)) {
            return -1;
        }
        
        Map<Integer, Set<Integer>> connMap = getMap(routes);
        
        int start = S;
        int bus = 1;
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> nextQueue = new LinkedList<Integer>(), queue = new LinkedList<Integer>();
        queue.offer(S);
        
        while(!queue.isEmpty()) {
            start = queue.poll();
            if(!visited.contains(start)) {
                for(int neighbor:connMap.get(start)) {
                    if(visited.contains(neighbor)) {
                        continue;
                    }

                    if(neighbor == T) {
                        return bus;
                    }
                    nextQueue.offer(neighbor);
                }
                visited.add(start);
                if(queue.isEmpty()) {
                    queue = new LinkedList<Integer>(nextQueue);
                    nextQueue = new LinkedList<Integer>();
                    bus += 1;
                }                
            }
        }
        
        return -1;
    }
    
    public static void main(String args[]) {
    	int[][] routes = {{1,2,7},{3,6,7}};
    	int S = 1, T = 6;
    	BusRoute br = new BusRoute();
    	System.out.println(br.numBusesToDestination(routes, S, T));
    	
    }
}
