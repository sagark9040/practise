package misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


class Point {
	public Point(int i, int j) {
		x = i; y = j;
	}

	int x, y;
}

public class NumOfPathsIn2DMatrix {
		
	

	int numPaths(Point start, Point end, List<Point> toPass) {

		// contains all columns we need to pass through and the corresponding point
		Map<Integer, Point> toPassMap = new HashMap<Integer, Point>();
		for(Point p : toPass) {
			toPassMap.put(p.x, p);
		}

		// containts num ways to get from a Point to the end
		Map<Point, Integer> numWays = new HashMap<Point, Integer>(); 	
		numWays.put(end, 1);

		// for each column from right to left (backwards)
		for(int col = end.x - 1; col >= start.x; col--) {
			// cache of previous column numWays
			Map<Point, Integer> numWaysTemp = new HashMap<Point, Integer>(); 
			for(Point p : numWays.keySet()) { // p is at col + 1
				int x = p.x;
				int y = p.y;
				int ways = numWays.get(p);

				Point prevPoint = new Point(x-1, y-1);
				
				if(numWaysTemp.containsKey(prevPoint))
					numWaysTemp.put(prevPoint, numWaysTemp.get(prevPoint) + ways);
				else
					numWaysTemp.put(prevPoint, ways);

				prevPoint = new Point(x-1, y);
				if(numWaysTemp.containsKey(prevPoint))
					numWaysTemp.put(prevPoint, numWaysTemp.get(prevPoint) + ways);
				else
					numWaysTemp.put(prevPoint, ways);
				
				prevPoint = new Point(x-1, y+1);
				if(numWaysTemp.containsKey(prevPoint))
					numWaysTemp.put(prevPoint, numWaysTemp.get(prevPoint) + ways);
				else
					numWaysTemp.put(prevPoint, ways);
			}	
			
			// handle case where we had to pass through a point at column col
			if(toPassMap.containsKey(col)) {
				// make sure numWaysTemp contains that point
				Point mustPass = toPassMap.get(col);
				if(!numWaysTemp.containsKey(mustPass)) {
					return 0; // can't complete the traversal
				}
				numWays = new HashMap<Point, Integer>();
				numWays.put(mustPass, numWaysTemp.get(mustPass));
			} else { // assign numWaysTemp to numWays
				numWays = numWaysTemp;
			}
			
		}

		return (numWays.containsKey(start) ?  numWays.get(start) : 0);
	}
	
	static int[][] dp;
	public static void main(String args[]) {
//		Point s = new Point(0,0);
//		Point e = new Point(3,3);
//		
//		List<Point> mustPass = new ArrayList<Point>();
//		mustPass.add(new Point(1,1));
//		
//		NumOfPathsIn2DMatrix n = new NumOfPathsIn2DMatrix();
//		System.out.println(n.numPaths(s, e, mustPass));
//		

		
		//	0 0 0
		//  1 0 0
		//  0 0 0
		
		
		
		
		int n = 3;
		dp = new int[n][n];
		int x = n-1, y = n-1;
		getWays(0, 0, x, y, dp, path);
		System.out.println(dp[x][y]);
	}	
	
	



static int[][] mustVisitPts = {{1,0}};
	static Map<Integer, Integer> path = new HashMap<Integer, Integer>();
	
	static int getWays(int startX, int startY, int endX, int endY, int[][] dp, Map<Integer, Integer> path) {
		if(endX < 0 || endY < 0) { 
			return 0;
		}
		if(startX == endX && startY == endY && contains(path, mustVisitPts)) {
			return 1;
		}
		if(dp[endX][endY] > 0) {
			return dp[endX][endY];
		}
		
		path.put(endX-1, endY);
		dp[endX][endY] = getWays(startX, startY, endX-1, endY, dp, path);
		
		path.put(endX, endY-1);
		dp[endX][endY] += getWays(startX, startY, endX, endY-1, dp, path);
		return dp[endX][endY];
	}

	private static boolean contains(Map<Integer, Integer> path2, int[][] mustVisitPts2) {
		for(int[] pt:mustVisitPts2) {
			if(path2.containsKey(pt[0]) && path2.get(pt[0]) == pt[1])
				continue;
			else
				return false;
		}
		
		return true;
	}
}
