package in.gd.senDev;

import java.util.HashSet;
import java.util.Set;

public class NumberOfWays {

	private class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Set<Point> disallowedPoints = new HashSet<Point>();

	NumberOfWays() {
		disallowedPoints.add(new Point(0, 1));
	}

	int NumberOfWays(int[][] input) {
		
		for (Point point:disallowedPoints) {
			System.out.println(point.x + " " + point.y);
		}

		int[][] waysCounter = new int[input.length][input[0].length];

		for(int r=0; r<input.length; r++) {
			
			for(int c=0; c<input[0].length; c++) {
				
				System.out.print(waysCounter[r][c] + " ");
				
			}
			
			System.out.println();
			
		}
		
		for (int r=0; r<input.length; r++) {
			if (r!=0)
				waysCounter[r][0] = 1;
		}

		for (int c=0; c<input[0].length; c++) {
			Point p = new Point(0, c);
			if (c!=0)
				waysCounter[0][c] = 1;
		}
		
		for(int r=0; r<input.length; r++) {
	
			for(int c=0; c<input[0].length; c++) {
				
				System.out.print(waysCounter[r][c] + " ");
				
			}
			
			System.out.println();
			
		}

		for(int r=1; r<input.length; r++) {
			
			for(int c=1; c<input[0].length; c++) {

				if (!disallowedPoints.contains(new Point(r,c))) {
					waysCounter[r][c] = waysCounter[r-1][c] + waysCounter[r][c-1];
				}

			}

		}

		return waysCounter[input.length-1][input[0].length-1];
	}

	public static void main(String args[]) {
		NumberOfWays num = new NumberOfWays();
		
		
		int[][] arr = {{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		System.out.println(num.NumberOfWays(arr));
	}

}
