package test;

public class SmallestOneMInOneB {
	public static void main (String args[]) {
		String name = "Sagar";
		System.out.println(name.substring(0,2) + " " + name.substring(2));
		System.out.println(name.contains("S"));
		
//		18.12 Given an NxN matrix of positive and negative integers, write code to find the
//		submatrix with the largest possible sum.
		
		//null --> 
		//1 --> 1
		//1 2 --> max(1)+nextColumb
		//1 1
		//1 2 --> max of rowAbove + add columns below 
		//
		// 1  2 -1
		//-1 -2 -2
		// 2  3  1 -->   
		
		
		//0 2 5 10 100 500 700 900 
		//7 27 30 50 501
		
		//3486784401
		//1162261467
		
		int num = 3, pow=0;
		while (num<(Math.pow(2, 33)) && num>0) {
			pow = num;
			num = num*3;
		}
		long pow_ = pow*3;
		
		for(int i=1;i<1000000;i++)
			if(pow%i==0)System.out.println("Factors of 3 pow:" + i);
		
		System.out.println("Orig num:" + num + " " + ((num >> 1) - ((num >> 1) >> 1)));
	}
	
//	- Trees & Graphs - BFS/DFS, Pre,Post,In traversals, Adj List, Matrix
//	- DAG, AVL, R/B
//	- Arrays/Lists/Stacks/Queues/HashMaps/HashSets/HashTables/LL-Insertions, Deletions, Retrieval
//	- Iterator, Comparator
//	- Bit Shifts
	
	
}	
