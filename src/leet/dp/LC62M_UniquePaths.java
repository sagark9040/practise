package leet.dp;

public class LC62M_UniquePaths {
	public int uniquePaths(int m, int n) {
        int[][] p = new int[m][n];        
        return getPaths(p, m-1, n-1);
    }
    
    public int getPaths(int[][] p, int m, int n) {
        if(m == 0 && n == 0) {
            return 1;
        } else if(m < 0 || n < 0) {
            return 0;
        } else {  
            if(p[m][n] == 0) {
                p[m][n] = getPaths(p, m-1, n) + getPaths(p, m, n-1);
            }
            return p[m][n];        
        }
    }
}
