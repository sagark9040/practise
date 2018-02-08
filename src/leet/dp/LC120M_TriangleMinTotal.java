package leet.dp;

import java.util.ArrayList;
import java.util.List;

public class LC120M_TriangleMinTotal {
	 public int minimumTotal(List<List<Integer>> triangle) {
        int pos = 0;
        int[][] min = fillUp(triangle.size());
        for(List<Integer> curRow:triangle) {
            if(pos == 0) {
                min[pos][pos] = curRow.get(0);
            } else {
                for(int i=0; i<curRow.size(); i++) {
                    int prev = i-1 >= 0 ? min[pos-1][i-1] : Integer.MAX_VALUE;	// <----		PROBLEM AREA EARLIER
                    min[pos][i] = Math.min(min[pos-1][i], prev) + curRow.get(i);		
                }
            }
            pos++;
        }
        
        int minTotal = Integer.MAX_VALUE;
        for(int i=0; i<min.length; i++) {
            minTotal = Math.min(minTotal, min[min.length-1][i]);
        }
        return minTotal;
    }
	 
	private int[][] fillUp(int size) {
		int[][] min = new int[size][size];
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				min[i][j] = Integer.MAX_VALUE;		//  			<-- MAX VALUE IS KEY HERE
			}
		}
		return min;
	}

	public static void main(String args[]) {
		List<List<Integer>> tr = new ArrayList<List<Integer>>();
		List<Integer> c = new ArrayList<Integer>();
		c.add(1);
		tr.add(c);
		
		c = new ArrayList<Integer>();
		c.add(2);
		c.add(3);
		tr.add(c);
		
		LC120M_TriangleMinTotal t = new LC120M_TriangleMinTotal();
		System.out.println(t.minimumTotal(tr));
	}
}
