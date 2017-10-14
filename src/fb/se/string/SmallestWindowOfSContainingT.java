package fb.se.string;

// Find the minimum window in string S which will contain all the characters in string T
// Two methods:

// 1 --- Brute Force
// Start creating all the substrings in S, starting from S[0] to S[N-1-len(T)]
// Return the smallest of the above substrings that has the elements of T
// Time Complexity: O(N^2)

public class SmallestWindowOfSContainingT {

	//////////////////////////////////////////////////////////////////////////////////
	//							BruteForce Solution
	//////////////////////////////////////////////////////////////////////////////////
	void smallestWindow(String main, String pat){
		
		int maxWindowSize = Integer.MAX_VALUE;
		
		for(int i=0; i<main.length()-pat.length(); i++){
			String subString = main.substring(i);
			int windowSize = windowSize(subString, pat);
			maxWindowSize = windowSize < maxWindowSize ? windowSize : maxWindowSize;
		}
		
		System.out.println(maxWindowSize);
	}

	private int windowSize(String subString, String pat) {
		int[] patChars = new int[256];
		int count = pat.length();
		
		patChars = getPatChars(pat);
		
		for(int i=0; i<subString.length(); i++){
			if(count>0){
				char currentAlphabet = subString.charAt(i);				
				if(patChars[currentAlphabet] > 0){				
					count--;
				}
				if(count == 0)
					return i+1;
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
	private int[] getPatChars(String pat) {
		int[] patChars = new int[256];
		
		for(Character c: pat.toCharArray()){
			patChars[c]++;
		}

		return patChars;
	}
	//////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String args[]){
		String mainString = "sagarsagar";
		String patternString = "rsg";
		
		SmallestWindowOfSContainingT smallestWindow = new SmallestWindowOfSContainingT();
		smallestWindow.smallestWindow(mainString, patternString);
	}
	
}
