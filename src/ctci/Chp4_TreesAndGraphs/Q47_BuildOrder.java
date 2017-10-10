package ctci.Chp4_TreesAndGraphs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q47_BuildOrder {
	Graph graph = new Graph();
	Stack<GraphNode> topoStack = new Stack<GraphNode>();
	
	Q47_BuildOrder(Graph g){
		graph = g;
		
		for(GraphNode node: g.graphNodes){
			node.state = State.NotVisited;
		}		
	}

	//TODO Complete this
	void buildOrder(){
		
		Set<GraphNode> visited = new HashSet<GraphNode>();
		
		for(GraphNode node: graph.graphNodes){
			if(node.state.equals(State.Visited))
				continue;
			checkNodes(node, visited);			
		}
		
	}
	
	void checkNodes(GraphNode node, Set<GraphNode> visited){
		
		for(GraphNode dependent: node.adjacentNodes){			
			if(dependent.state.equals(State.NotVisited)){
				checkNodes(dependent, visited);				
			}				
			topoStack.add(node);		
		}		
	}		
}
