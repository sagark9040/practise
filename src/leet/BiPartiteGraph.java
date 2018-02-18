package leet;

import java.util.HashSet;

public class BiPartiteGraph {

		public boolean isBiPartiteGraph = true;
	    public boolean isBipartite(int[][] graph) {
	        int cur = 0;
	        HashSet<Integer> setA = new HashSet<Integer>();
	        HashSet<Integer> setB = new HashSet<Integer>();
	        for(int neighbors[]:graph) {
	            bfs(neighbors, graph[cur][0], setA, setB);
	            cur++;
	            
	            if(!isBiPartiteGraph) {
	                return false;
	            }
	        }
	        
	        return isBiPartiteGraph;
	    }
	    
	    public void bfs(int[] neighbors, int u, HashSet<Integer> setA, HashSet<Integer> setB) {
	        if(!setA.contains(u) && !setB.contains(u)) {
	            setA.add(u);
	        }
	        
	        for(int v:neighbors) {
	            if((setA.contains(u) && setA.contains(v)) ||
	               (setB.contains(u) && setB.contains(v))) {
	                isBiPartiteGraph = false;
	                return;
	            } else if(!setB.contains(v) && !setA.contains(v)) {
	                setB.add(v);
	            }
	        }
	    }
	
	public static void main(String args[]) {
		int[][] graph = new int[][] {{3,2}, {0,1}, {1,2}};
		BiPartiteGraph b = new BiPartiteGraph();
		System.out.println(b.isBipartite(graph));
	}
}
