package leet.array;

public class LC274M_HIndex {
	
	//220p --> 245p .. straightforward including bug fixes for WRONG answers 
	//sort it  n log n
	//0, 1, 3, 5, 6
	//0, 1, 2, 3, 4
	//5, 4, 3, 2, 1
	
	//TCs
	//0 citations?
	//1 citation - itself is the answer
	//2 or more 
	//duplicate values of citations
	//2 values having the same citation
	//max values of citations? 
	
	public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
        	return 0;
        } 
        
        
        
        int max = Integer.MIN_VALUE;
        for(int cur:citations) {
        	max = Math.max(max, cur);
        }
		
        int[] citationCounts = new int[max+1];
        int sumSoFar = 0;
        
        for(int i=citations.length-1; i>=0; i--) {
        	citationCounts[citations[i]]++;        	
        }
        
        max = 0;
        for(int i=citationCounts.length-1; i>=0; i--) {
        	sumSoFar += citationCounts[i];
        	
        	if(i <= sumSoFar) {	 //								<---- PROBLEM AREA ... DIDN'T HAVE IT AT FIRST
        		max = i;	
        		break;
        	}
        	
        }
		
        return max;
    }
	
	public static void main(String args[]) {
		LC274M_HIndex hi = new LC274M_HIndex();
		int[] citations = {1,1}; //{3, 0, 6, 1, 5};
		System.out.println(hi.hIndex(citations));
	}
}

/*
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, 
and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 
citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, 
his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

*/