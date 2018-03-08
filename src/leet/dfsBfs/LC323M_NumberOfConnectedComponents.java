package leet.dfsBfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC323M_NumberOfConnectedComponents {
    // 721pm .. 744pm AC .. 23 mins
    // n-node
    // HashMap for all the edges -> adjList
    // edge[0] - edge[1] is added to the set, also edge[1] - edge[0] is added to it's set
    // loop through 0 to n-1, and do DFS if !visited[i] and increment the counter of connComp
    
    
    // TCs: n = 0 or edges are empty or null, duplicate edges? 1,2 and 1,2 again .. or 1,2 and 2,1 again.

    // Missed edge cases:
    // I totally missed nodes which are by themselves, thereby each forming a separated connected component
    // I also got wrong, the case of empty edges[]
    
    
    Set<Integer> visited = new HashSet<Integer>();
    public int countComponents(int n, int[][] edges) {
        //corner cases
        if(n == 0) {
            return 0;
        }
        
        int connectedComponents = 0;
        HashMap<Integer, Set<Integer>> adjList = generateAdjList(edges);        
        
        for(int i=0; i<n; i++) {
            if(!visited.contains(i) && adjList.containsKey(i)) {
                visited.add(i);
                connectedComponents++;
                dfs(adjList, i);
            }
        }
        return n-visited.size() > 0 ? connectedComponents + n-visited.size() : connectedComponents;
    }
    
    void dfs(HashMap<Integer, Set<Integer>> adjList, int node) {
        for(int value: adjList.get(node)) {
            if(!visited.contains(value)) {
                visited.add(value);
                dfs(adjList, value);                
            }            
        }
    }
    
    HashMap<Integer, Set<Integer>> generateAdjList(int[][] edges) {
        HashMap<Integer, Set<Integer>> adjList = new HashMap<Integer, Set<Integer>>();
        
        for(int[] edge:edges) {
            Set<Integer> mySet = new HashSet<Integer>();
            if(adjList.containsKey(edge[0])) {
                mySet = adjList.get(edge[0]);
            }            
            mySet.add(edge[1]);                
            adjList.put(edge[0], mySet);                
            
            mySet = new HashSet<Integer>();
            if(adjList.containsKey(edge[1])) {
                mySet = adjList.get(edge[1]);
            }            
            mySet.add(edge[0]);                
            adjList.put(edge[1], mySet);              
        }
        
        return adjList;
    }
}
