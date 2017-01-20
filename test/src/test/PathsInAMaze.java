package test;

public class PathsInAMaze {

	/*static int pathsRecursion (int m, int n) {
		if (m==2 && n==3)
			return 0;
		
		if (m==1 || n==1) {
			return 1;
		}
		
		return pathsRecursion(m-1,n) + pathsRecursion(m, n-1);
	}*/
	
	static int pathsDP (int m, int n, int steps) {
		if (m>=6 || n>=4 || m<0 || n<0 || !checkValid(m,n))
			return 0;
		else if (m==0 && n==0) {
			steps++;
			System.out.println("No of steps:" + steps);
			return 1;
		}
		int noOfWays = pathsDP(m-1, n, steps+1) + pathsDP(m, n-1, steps+1);
		return noOfWays;
	}
	
	private static boolean checkValid(int m, int n) {
		int[][] a = {{1, 1, 1, 1},
	            	 {0, 1, 0, 1},
	            	 {0, 1, 1, 1},
	            	 {0, 1, 0, 0},
	            	 {1, 1, 0, 0},
	            	 {1, 1, 1, 1}}; 
				
				// {{1,0,0,0,1},{1,0,0,1,1},{1,1,1,1,1}};
		return (a[m][n]==1);
	}

	public static void main (String args[]) {
		long start = System.currentTimeMillis();
		/*System.out.println(pathsRecursion(13,15));
		System.out.println(System.currentTimeMillis()-start);*/
		
		start = System.currentTimeMillis();
		System.out.println(pathsDP(5,3,0));
	}
}
