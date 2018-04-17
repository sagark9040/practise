package leet.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LC452M_MinNumberOfArrows {
	// 1014 ... 26 min AC .. initially I only had 21/43 TCs after 16 mins.. silly algo that time, had to improve

	// 1,6 .. 2,8
	// 7,12 .. 10,16

	// 1,6 ... 2,8 .. 7,12 ... 10,16

	// Brute Force
	// Numbers from start to end - count per number

	// Sort them by x1, x2 values
	// shoot x2, while check if next x1 is greater than previous x2, increase
	// count everytime
	// choose new x1, x2 and then x2 becomes the shooting point, again do the
	// above check.

	public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) { 
               if(a[0] == b[0]) {
                   return a[1]-b[1];
               }
               return a[0]-b[0];
           } 
        });    
        
        int count = 0;
        
        for(int i=0; i<points.length;) {
            int[] range = {points[i][0], points[i][1]}; 
            i++;
            count++;
            
            while(i < points.length && withinRange(range, points[i])) {
                range = getRange(range, points[i]);
                i++;
            }
        }
        
        return count;
    }
                  
    public boolean withinRange(int[] range, int[] point) {
        return point[0] <= range[1] && point[1] >= range[0];        
    }
                  
    public int[] getRange(int[] range, int[] point) {
        int x = point[0];
        int y = point[1] < range[1] ? point[1] : range[1];
            
        return new int[] {x, y};
    }
    
    public static void main(String args[]) {
    	int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
    	LC452M_MinNumberOfArrows min = new LC452M_MinNumberOfArrows();
    	System.out.println(min.findMinArrowShots(points));
    	
    }
}
