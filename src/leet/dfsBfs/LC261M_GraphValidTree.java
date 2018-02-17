package leet.dfsBfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC261M_GraphValidTree {
	//345 pm -- 405 pm 
    //405 pm to 435 pm --> had to use DFS to resolve one situation of a->b = b->a
    
    //tree = one parent
    //if more than one parent then it's not a tree, it's a graph
    //Thoughts
    //traverse the edges e=0 to e=len-1
    //child, parent reln
    //e[1] = child, parent in hashmap (or even a hashset)
    //if the e[1] element is found previously, then false
    
    //TCs
    //n = 0 .. empty tree with null root
    //n = 1 .. valid tree
    //undirectional? - yes
    //node without a connection in the graph?

    //FAILED CORNER CASES OF a->b then b->a .. 38/44
	
	
	///					CONCLUSION
	// BE CAREFUL OF THE GRAPH .. IT IS DFS ..
    
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
        //init nodes
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<Integer>());
        //populate edges
        for(int i=0; i<edges.length; i++) {
            int parent = edges[i][0], child = edges[i][1];
            adjList.get(parent).add(child);
            adjList.get(child).add(parent);
        }
        
        boolean[] visited = new boolean[n];
        
        if(hasCycle(adjList, 0, visited, -1)) 
            return false;
        
        for(int i=0; i<n; i++) {
            if(!visited[i])
                return false;            
        }
        
        return true;
    }
    boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;
        
        for (int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i);
            
            if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u)))
                return true;
        }
        
        return false;
    }
    
    public boolean validTreeWrongSolution(int n, int[][] edges) {
	        //base cases
	        if(n < 1 || (n > 1 && edges.length == 0)) {
	            return false;
	        } else if (edges == null || edges.length == 0) {
	            return true;
	        }
	        
	        Set<Integer> child = new HashSet<Integer>();
	        Set<Integer> parents = new HashSet<Integer>();
	        for(int[] edge:edges) {
	            if(child.contains(edge[1])) {
	                return false;
	            }
	            parents.add(edge[0]);
	            child.add(edge[1]);
	        }
	        
	        int firstParent = 0;
	        for(int parent:parents) {
	            if(!child.contains(parent)) {
	                firstParent++;;                 //    <--- returned false wrongly
	            }
	        }
	        child.addAll(parents);	        
	        return firstParent == 1 && child.size() == n;
    }
  
// 5
// [[0,1],[0,2],[2,3],[2,4]]

	 
	 public static void main(String args[]) {
		 int n = 1;
		 int[][] edges = {};
		 LC261M_GraphValidTree g = new LC261M_GraphValidTree();
		 System.out.println(g.validTree(n, edges));
	 }
}
