package fb.se.array;

import java.util.ArrayList;

// How many arrays?
// All sorted in asc order?
// Result array is big enough?

// This question is deceptively difficult!!!!!

public class MergeMultipleSortedArrays {
	
	int[][] arrays;
	int[] indices;
	int[] resultArray;
	
	public MergeMultipleSortedArrays(int[][] arrays){
		this.arrays = arrays;
		this.resultArray = new int[15];
		this.indices = new int[arrays.length];
		
		for(int i=0; i<arrays.length; i++)
			indices[i] = 0;
	}
	
	public int[] merge(){
		int n = 0;		
				
		while(n<15){			//O(n)
			int copyElementFromArray = findSmallest(arrays); //O(k)
			resultArray[n++] = arrays[copyElementFromArray][indices[copyElementFromArray]++];
		}
		
		return resultArray;
	}
	
	public int findSmallest(int[][] arrays){
		
		//O(k)
		int[] selection = getSelection(arrays);
		
		int index = -1;
		int smallest = Integer.MAX_VALUE;
		int indexOfSmallest = -1;
		
		//O(k)
		for(int number: selection){
			index++;
			if(smallest > number){
				smallest = number;
				indexOfSmallest = index;
			}				
		}
		return indexOfSmallest;
	}
	
	// O(k) where k is the number of arrays we have
	private int[] getSelection(int[][] arrays2) {
		ArrayList<Integer> selection = new ArrayList<Integer>();
		
		int i=0; 
		
		//runs O(k) times, once per array
		for(int index=0; index<arrays.length; index++){
			if(indices[index] < arrays[0].length)
				selection.add(arrays2[i][indices[index]]);
			else
				selection.add(Integer.MAX_VALUE);
			i++;
		}
		
		//O(k)
		int[] intArray = new int[selection.size()];
		for (int j = 0; j < intArray.length; j++) {
		    intArray[j] = selection.get(j);
		}
		
		return intArray;
	}

	public static void main(String args[]){
		int[][] input = {{2,4,10,12,20},{1,8,9,13,16},{3,5,10,14,15}};
		MergeMultipleSortedArrays mergeArrays = new MergeMultipleSortedArrays(input);
		
		if(input == null || input.length == 0)
			return;
		
		if(input.length == 1)
			return;
		
		int[] res = mergeArrays.merge();
		for(int i: res){
			System.out.println(i);
		}
	}
	//TODO will fail for one array or empty 2D arrays
}
