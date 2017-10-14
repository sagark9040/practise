package ctci.Chp4_TreesAndGraphs;

import java.util.Stack;

//Gotta use simple DFS on graph

public class Q47_BuildOrder {

	
	public static void main(String args[]){
		Graph g = new Graph();
		
		GraphNode a = new GraphNode("a", 1);
		GraphNode b = new GraphNode("b", 1);
		GraphNode c = new GraphNode("c", 0);
		GraphNode d = new GraphNode("d", 1);
		GraphNode e = new GraphNode("e", 0);
		GraphNode f = new GraphNode("f", 2);
		
		a.adjacentNodes = new GraphNode[]{d};
		f.adjacentNodes = new GraphNode[]{a,b};
		d.adjacentNodes = new GraphNode[]{c};
		b.adjacentNodes = new GraphNode[]{d};

		g.graphNodes = new GraphNode[]{a, b, c, d, e, f};
		
		buildOrder(g);
		
		while(!order.isEmpty())
			System.out.println(order.pop().data);
	}
	
	static Stack<GraphNode> order = new Stack<GraphNode>();

	private static void buildOrder(Graph g) {
		
		for(GraphNode node: g.graphNodes){
			node.state = State.NotVisited;
		}

		for(GraphNode node: g.graphNodes){
			if(node.state.equals(State.NotVisited)){
				buildOrder(node);				
			}
		}
		
	}

	private static void buildOrder(GraphNode node) {
		if(node.state.equals(State.NotVisited)){
			for(GraphNode adj: node.adjacentNodes){
				if(adj.state.equals(State.NotVisited)){
					buildOrder(adj);
				}
			}
			order.add(node);
			node.state = State.Visited;
		}		
	}
	
	
}
