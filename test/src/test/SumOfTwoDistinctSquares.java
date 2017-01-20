package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

public class SumOfTwoDistinctSquares {
	
	HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
	
	public void sumOfSq(int n) {
		
		int i = 1, j = 1;
		for(i = 1; i < n; i++) {
			for(j = 1; j < n; j++) {
				int sum = i*i + j*j;
				
				if(sum < n && (i!=j)) {
					if(map.containsKey(sum)) {
						HashSet<Integer> values = map.get(sum);
						values.add(i);
						values.add(j);
						map.put(sum, values);
					}
					else {
						HashSet<Integer> values = new HashSet<Integer>();
						values.add(i);
						values.add(j);
						map.put(sum, values);
					}					
				}
			}
		}
		
		print();
	}
	
	void print() {
		
		for(Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
			Integer key = entry.getKey();
			HashSet<Integer> val = entry.getValue();
			
			System.out.println(key + " " + val);
		}
	}
	
	public static void main (String args[]) {
		SumOfTwoDistinctSquares a = new SumOfTwoDistinctSquares();
		a.sumOfSq (1234);
	}
}
