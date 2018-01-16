package leet.array;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class LC283E_MoveZeroes {
	
	public static int[] moveZeroesExtraSpace(int[] arr){
		int zeroCount = 0;
		
		for(int i=0; i<arr.length; i++){
			if(arr[i] == 0)
				zeroCount++;
		}
		
		int[] result = arr;
		int resPos = 0, arrPos = 0;
		while(arrPos < arr.length){
			if(arr[arrPos] != 0) {
				result[resPos] = arr[arrPos];
				resPos++;
			}
			arrPos++;			
		}
		
		int pointer = arr.length-1;
		while(zeroCount>0){
			result[pointer] = 0;
			pointer--;
			zeroCount--;
		}
		
		return result;
	}
	
	public static int[] moveZerosInPlace(int[] arr){
		
		int firstZero = findFirstZero(arr);
		
		if (firstZero == -1)
			return arr;
		
		int pointer = firstZero+1;
		
		while (pointer < arr.length){
			
			if (arr[pointer] != 0){
				arr = swap(arr, pointer, firstZero);
				firstZero++;
			}
			
			pointer++;
		}
		
		return arr;
	}
	
	private static int findFirstZero(int[] arr) {
		for(int i=0; i<arr.length; i++){
			if(arr[i] == 0)
				return i;
		}
		return -1;		
	}

	private static int[] swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
		
		return arr;
	}

	public static void main(String args[]){
		beginsWithZero();
		System.out.println();
		beginsWithNONZero();
		System.out.println();
		NoZeroes();
		System.out.println();
		AllZeroes();
	}
	
	public static void beginsWithZero(){
		int[] arr = {0, 1, 0, 3, 12};
		int[] arr2 = moveZerosInPlace(arr);
		for(int i=0; i<arr2.length; i++)
			System.out.print(arr2[i] + ",");
	}
	
	public static void beginsWithNONZero(){
		int[] arr = {7,0, 1, 0, 3, 12};
		int[] arr2 = moveZerosInPlace(arr);
		for(int i=0; i<arr2.length; i++)
			System.out.print(arr2[i] + ",");
	}

	public static void NoZeroes(){
		int[] arr = {8, 1, 4, 3, 12};
		int[] arr2 = moveZerosInPlace(arr);
		for(int i=0; i<arr2.length; i++)
			System.out.print(arr2[i] + ",");
	}
	
	public static void AllZeroes(){
		int[] arr = {0, 0, 0, 0};
		int[] arr2 = moveZerosInPlace(arr);
		for(int i=0; i<arr2.length; i++)
			System.out.print(arr2[i] + ",");
	}
}
