package leet;

public class PerfectRectangle {
boolean inValid = false;
public boolean isRectangleCover(int[][] rectangles) {
        
    
	
	int minX = getMinX(rectangles);
	int minY = getMinY(rectangles);
	int maxX = getMaxX(rectangles);
	int maxY = getMaxY(rectangles);

	boolean[][] val = new boolean[maxX-minX+1][maxY-minY+1];

	for(int[] rectangle:rectangles) {
		if(inValid) {
			return false;
		}
		val = markX(rectangle, val, minX);
	}
	return allCellsCovered(val);

}

	private boolean allCellsCovered(boolean[][] val) {
		for(int i=0; i<val.length; i++) {
			for(int j=0; j<val[0].length; j++) {
				if(!val[i][j]) {
					return false;
				}
			}			
		}
	return true;
}

	boolean[][] markX(int[] rectangle, boolean[][] val, int minX) {
		int start = rectangle[0], end = rectangle[2];

		for(int i=0; i<end-start+1; i++) {
			for(int j=0; j<rectangle[3]-rectangle[1]+1; j++) {
				if(!inValid && val[i][j]) {
					inValid = true;
				}
				val[i][j] = true;
			}

		}	
		return val;
	}




	int getMinX(int[][] rectangles) {
		int minX = Integer.MAX_VALUE;
		for(int[] r:rectangles) {
			minX = Math.min(r[0], minX);
		}
		return minX;
	}



	int getMinY(int[][] rectangles) {
		int minY = Integer.MAX_VALUE;
		for(int[] r:rectangles) {
			minY = Math.min(r[1], minY);
		}
		return minY;
	}

	int getMaxX(int[][] rectangles) {
		int maxX = Integer.MIN_VALUE;
		for(int[] r:rectangles) {
			maxX = Math.max(Math.max(r[0], maxX),r[3]);
		}
		return maxX;
	}

	int getMaxY(int[][] rectangles) {
		int maxY = Integer.MIN_VALUE;
		for(int[] r:rectangles) {
			maxY = Math.max(Math.max(maxY, r[1]), r[3]);
		}
		return maxY;
	}
	
	public static void main(String args[]) {
		int[][] rectangles =
				{{1,1,3,3},
		  {3,1,4,2},
		  {3,2,4,4},
		  {1,3,2,4},
		  {2,3,3,4}};
				
				
//				  {{1,1,3,3},
//				  {3,1,4,2},
//				  {1,3,2,4},
//				  {3,2,4,4}};
				
//				{{1,1,2,3},
//				  {1,3,2,4},
//				  {3,1,4,2},
//				  {3,2,4,4}};
		
		PerfectRectangle pR = new PerfectRectangle();
		System.out.println(pR.isRectangleCover(rectangles));		
	}
}
