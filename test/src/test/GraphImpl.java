package test;

import java.util.Iterator;
import java.util.LinkedList;

class Graph{
	int V;
	LinkedList<Integer> adj[];
	
	Graph(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	void addEdge(int v, int w){
		adj[v].add(w);
	}		
	
	void dfs(int node){
		boolean[] visited = new boolean[V];
		dfsUtil(node, visited);
	}
	
	void dfsUtil(int v, boolean visited[]){
		visited[v] = true;
		System.out.print(v + " ");
		
		Iterator<Integer> i = adj[v].listIterator(); //TODO I didn't know this iterator
		
		while(i.hasNext()){
			int n = i.next();
			if(!visited[n])
				dfsUtil(n, visited);
				
		}
	}
	
	void bfs(int n){
		boolean visited[] = new boolean[V];
		for(int i=0; i<V; i++)
			visited[i] = false;
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[n] = true;
		queue.push(n);
				
		while(!queue.isEmpty()){
			int cur = queue.poll();
			System.out.print(cur + " ");
			visited[cur] = true;
			LinkedList<Integer> neighbors = adj[cur];
			
			for(Integer neighbor: neighbors){
				if(visited[neighbor] == false){
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
		
	}
}
	
public class GraphImpl{
	 public static void main(String args[])
    {
        Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.dfs(2);

        System.out.println("\nFollowing is BFS");
        g.bfs(2);
    }
}