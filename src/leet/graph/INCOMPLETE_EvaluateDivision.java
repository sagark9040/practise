package leet.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class INCOMPLETE_EvaluateDivision {
	 //308 pm .. 316 pm
    //318 pm .. 
    
    //divide with present, one absent, both absent, itself
    //thinking of a DS I'll need.
    
    // a/b = 2   b/c = 3   c/d = 5
    
    //DFS graph? a-->b 2 ,, b-->c 3 .. c-->d 5
    //a-->c = 6 
    //b--> 0.5
    //
    
    // a = 2b ..  b = 0.5a  .. c = 0.33b .. b = 3c    
    
    //map of g nodes:
    //get the num, look for deno in it's keys. if found return the calc
    //     if not, 
    //          check for deno in keys, 
    //                    if found take the deno and look in the map for the same one .. multiply prev val
    //          deno not in keys
    //                    return -1
    //num not found .. return -1
    
    HashMap<Character, GraphNode> g;
    double[] values;
    
    public double[] calcEquation(String[][] equations, double[] v, String[][] queries) {
        g = generateMap(equations);
        values = v;
        double[] results = new double[queries.length];
        int pos = 0;
        for(String[] query: queries) {
            results[pos] = dfs(query);
            pos++;
        }
        return results;
    }
    
    public double dfs(String[] query) {
        double res = 1.0d;
        if(!g.containsKey(query[0]))
            return -res;
       double val = 1.0d;
       for(char neighbor: g.get(query[0]).neighbors){
           val = 1.0d * dfsUtil(neighbor);
       } 
       
       return res;
    }
    
    private double dfsUtil(char neighbor) {
    	
		return 0;
	}

	public HashMap<Character, GraphNode> generateMap(String[][] equations) {
        HashMap<Character, GraphNode> map = new HashMap<Character, GraphNode>();
         
        for(int i=0; i< equations.length; i++) {
            String[] equation = equations[i];
            double val = values[i];
            
            if(map.containsKey(equation[0])) {
                GraphNode g = map.get(equation[0]);
                ArrayList<Character> neighbors = g.neighbors;
                ArrayList<Double> values = g.val;
                neighbors.add(equation[1].charAt(0));
                values.add(val);
                g = new GraphNode(neighbors, values);
                map.put(equation[0].charAt(0), g);
            } else {
                map.put(equation[0].charAt(0), new GraphNode(equation[1].charAt(0), val));
            }
            
        }
        return map;
    }
    
    class GraphNode {
        char divisor;
        ArrayList<Character> neighbors = new ArrayList<Character>();
        ArrayList<Double> val = new ArrayList<Double>();
        GraphNode(char ch, double v) {
            neighbors.add(ch);
            val.add(v);
        }
        GraphNode(ArrayList<Character> n, ArrayList<Double> v) {
            val = v;
            neighbors = n;
        }
    }
}
