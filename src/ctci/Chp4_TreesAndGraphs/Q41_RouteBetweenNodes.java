package ctci.Chp4_TreesAndGraphs;

public class Q41_RouteBetweenNodes {

	static boolean doesRouteExist(Graph g, GraphNode start, GraphNode end){
	
		for(GraphNode node: g.getNodes())
			node.state = State.NotVisited;
		
		for(GraphNode node: start.getAdjacentNodes()){
			if(node.state.equals(State.NotVisited)){
				if(end == node)
					return true;
				
			}
			node.state = State.Visited;
		}		
		
		return false;
	}	
	
	public static void main(String a[])
	{
		Graph g = createNewGraph();
		GraphNode[] n = g.getNodes();
		GraphNode start = n[5];
		GraphNode end = n[1];
		System.out.println(doesRouteExist(g, start, end));
	}
	
	public static Graph createNewGraph()
	{
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
		
		return g;
	}
}
