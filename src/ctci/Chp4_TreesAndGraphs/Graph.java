package ctci.Chp4_TreesAndGraphs;

public class Graph {
	GraphNode[] graphNodes = {};
	public int count;

	public GraphNode[] getNodes() {
		return graphNodes;
	}	
	public void addNode(GraphNode x) {
		if (count < graphNodes.length) {
			graphNodes[count] = x;
			count++;
		} else {
			System.out.print("Graph full");
		}
    }
	
}

class GraphNode{
	String data;
	GraphNode[] adjacentNodes;
	State state;
	public int adjacentCount;
	
	public GraphNode(String vertex, int adjacentLength) {
        this.data = vertex;                
        adjacentCount = 0;        
        adjacentNodes = new GraphNode[adjacentLength];
    }
	
	public GraphNode[] getAdjacentNodes() {
		return adjacentNodes;
	}

	public void addAdjacent(GraphNode graphNode) {
		if (adjacentCount < adjacentNodes.length) {
            this.adjacentNodes[adjacentCount] = graphNode;
            adjacentCount++;
        } else {
            System.out.print("No more adjacent can be added");
        }
    }
}

enum State {Visited, NotVisited;}