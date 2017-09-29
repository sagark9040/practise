package src.in.gd;

import java.util.Arrays;
import java.util.HashMap;

public class CountDistinctElemInArray {


	// null
	// 1
	// 1, 2, 3
	// 1, 2, 3, 1
	static int getDistinct (int[] input) {

		HashMap<Integer, Integer> elementCounter = new HashMap<Integer, Integer>();
		int distinctElements = 0;

		for (int i=0; i<input.length; i++) {

			int currentElement = input[i];

			if (elementCounter.containsKey(currentElement)) {
				int previousCount = elementCounter.get(currentElement);
				elementCounter.put(currentElement, ++previousCount);
			}
			else 
				elementCounter.put(currentElement, 1);

		}

		for (int currentElement : elementCounter.keySet()) {

			if (elementCounter.get(currentElement) == 1)
				distinctElements++;

		}

		return distinctElements;

	}
	
	static int getDistinctNoExtraSpace (int[] input) {
		
		if (input.length == 0)
			return 0;
		
		if (input.length == 1)
			return 1; 
		
		Arrays.sort(input);
		int distinctCount = 0;		
		
		for (int pos=0; pos<input.length; pos++) {
			
			if (pos == 0) {
				if(input[pos] != input[pos+1])
					distinctCount++;
			}
			
			else if (pos == input.length-1) { 
				if(input [pos] != input [pos-1])
					distinctCount++;
			}	
			
			else {  
				if (input [pos] != input [pos-1] && input[pos] != input[pos+1])
					distinctCount++;
			}
		}
		
		return distinctCount;
	}

	public static void main(String args[]) {

		int[] arr = {1, 2, 1, 3};
		//int[] arr = {1, 2, 3};
		//int[] arr = {1, 1};
		//int[] arr = {};
		
		System.out.println("The number of distinct elements are: " + getDistinctNoExtraSpace(arr));

	}

}
