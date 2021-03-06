package leet.graph;

import java.util.HashSet;
import java.util.Set;

public class INCOMPLETE_RedundantConenction2 {

	public int[] findRedundantDirectedConnection(int[][] edges) {
		int[] res = new int [2];
		Set<Integer> seen = new HashSet<Integer>();		
		
		for(int[] curEdge: edges) {
			// [12] [31] - fine
		}
		
		return res;
    }	
}

/*
In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, 
plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. 
The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3

Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3

*/

// [12] [15] 	  	fine
// [12] [23] [31] 	not fine
// [12] [23] [34] [41] [46]