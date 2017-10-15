package fb.se.string;

// Find the minimum window in string S which will contain all the characters in string T
// Two methods:

// 1 --- Brute Force
// Start creating all the substrings in S, starting from S[0] to S[N-1-len(T)]
// Return the smallest of the above substrings that has the elements of T
// Time Complexity: O(N^2)

public class SmallestWindowOfSContainingT {

	//////////////////////////////////////////////////////////////////////////////////
	//							BruteForce Solution O(N^2)
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
		
		patChars = getCharacterCountArray(pat);
		
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
	
	private int[] getCharacterCountArray(String str) {
		int[] charCountArray = new int[256];
		
		for(Character c: str.toCharArray()){
			charCountArray[c]++;
		}

		return charCountArray;
	}
	//////////////////////////////////////////////////////////////////////////////////
	// 						Efficient Solution O(N)
	//////////////////////////////////////////////////////////////////////////////////
		
	void smallestWindowLinearTime(String main, String pat){
		int[] mainChars = new int[256];
		int[] patChars = getCharacterCountArray(pat);
		int count = 0, start = 0, startIndex = -1, minWindow = Integer.MAX_VALUE; 
		int patLen = pat.length();		
		
		//sagargsagar
		//rsg
		
		for(int i=0; i<main.length(); i++){
			char c = main.charAt(i);
			mainChars[c]++;

			//C is present in pattern, increment count if we've not exceeded the value of C
			if(patChars[c] != 0 &&
					mainChars[c] <= patChars[c])
				count++;
				
			// Found a window
			if(count == patLen){
				
				char curChar = main.charAt(start);
				
				// extra characters or unnecessary characters
				while(patChars[curChar]==0 || 
						mainChars[curChar] > patChars[curChar]){	
					
					if(mainChars[curChar] > patChars[curChar])
						mainChars[curChar]--;
					
					start++;
					curChar = main.charAt(start);
				}
	
				// update window size
	            int len_window = i - start + 1;
	            if (minWindow > len_window)
	            {
	                minWindow = len_window;
	                startIndex = start;
	            }
			}			
		}
		System.out.println(minWindow);
	}
	
	public static void main(String args[]){
		String mainString = "sagargsagar";
		String patternString = "rsg";
		
		SmallestWindowOfSContainingT smallestWindow = new SmallestWindowOfSContainingT();
		//smallestWindow.smallestWindow(mainString, patternString);
		smallestWindow.smallestWindowLinearTime(mainString, patternString);
		
	}
	
}
