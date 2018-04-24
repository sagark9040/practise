package leet.dfsBfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC365M_WaterAndJugProblem {
	
	//This is the coding soln, there's a GCD-based Math soln to this problem too.
	//Took wayyyyyyy tooo lonnggg to code, almost a reject!!! arggghhhhh...
	
	public boolean canMeasureWater(int x, int y, int z) {
		return bfs(0, 0, new HashSet<String>(), x, y, z);
	}
	
	public boolean bfs(int i, int j, Set<String> set, int x, int y, int z) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{i, j});
		set.add("" + i + " " + j);
		int count = 0;
		if(x < 0 || y < 0 || x+y < z) 
			return false;
		
		//
		
		while(!q.isEmpty()) {
			int[] val = q.poll();
			i = val[0];
			j = val[1];
			System.out.println(i + " " + j + " -> " + count++ );
			
			if(i == z || j == z || i+j == z) {
				return true;
			}
			
			if(!set.contains("" + x + " " + j)) {
				set.add("" + x + " " + j);
				q.add(new int[]{x, j});
			}
			
			if(!set.contains("" + i + " " + y)) {
				set.add("" + i + " " + y);
				q.add(new int[]{i, y});
			}
			
			if(!set.contains("" + 0 + " " + j)) {
				set.add("" + 0 + " " + j);
				q.add(new int[]{0, j});
			}
			
			if(!set.contains("" + i + " " + 0)) {
				set.add("" + i + " " + 0);
				q.add(new int[]{i, 0});
			}
			
			int prevI = i, prevJ = j;
			while(i > 0 && j < y) {
				i--;
				j++;
			}
			if(!set.contains("" + i + " " + j)) {
				set.add("" + i + " " + j);
				q.add(new int[]{i, j});
			}
			
			i=prevI;
			j=prevJ;
			while(j > 0 && i < x) {
				j--;
				i++;
			}
			if(!set.contains("" + i + " " + j)) {
				set.add("" + i + " " + j);
				q.add(new int[]{i, j});			
			}
		}
		
		return false;
	}
	
	public static void main(String args[]) {
		int x=5, y=3, z=4; // 22003
//		31237
//		123
		LC365M_WaterAndJugProblem wj = new LC365M_WaterAndJugProblem();
		System.out.println(wj.canMeasureWater(x, y, z));
		
	}
}


