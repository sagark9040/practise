package fb.se.array;

//Merge two sorted arrays in place

//Example Input:
//1,3,5,7
//2,4
//Example Output:
//1,2,3,4
//5,7

//1,2,3,7
//4,5

//Competition is for index i -> i=0 to i<m+n
//if the minimum position is found without need for a swap then increment the value in first array
//if swap is needed, then swap and put the element from the first in it's rightful place in the second 

// NOTES:
// Take care of comparisons and indexes.

public class MergeTwoSortedArraysInPlace {

	int[] arr1; int[] arr2;
	
	MergeTwoSortedArraysInPlace(int[] a1, int[] a2){
		arr1 = a1;
		arr2 = a2;
	}
	
	void mergeSortedInPlace(){
		
		int ptr1 = 0, ptr2 = 0;
		
		while(ptr1 < arr1.length){
			//arr1 element is smaller than arr2 element. Just increment ptr1
			if(arr1[ptr1] <= arr2[ptr2])
				ptr1++;			
			//arr2 element is smaller. Swap elements in ptr1 and ptr2, increment ptr1 and put the temporary element in it's right position in arr2
			else{
				swap(ptr1, ptr2);
				ptr1++;
				putElemInRightPlace();
			}
		}		
		
	}

	private void swap(int ptr1, int ptr2) {
		int temp = arr1[ptr1];
		arr1[ptr1] = arr2[ptr2];
		arr2[ptr2] = temp;
	}
	
	private void putElemInRightPlace(){
		int firstElem = arr2[0];
		
		for(int i=1; i<arr2.length; i++){
			if(arr2[i] < firstElem){
				arr2[i-1] = arr2[i];
				arr2[i] = firstElem;
			}
		}
	}
	
	public static void main(String args[]){
		int[] a1 = {1,3,5,7};
		int[] a2 = {2,4};
		MergeTwoSortedArraysInPlace mer = new MergeTwoSortedArraysInPlace(a1, a2);
		mer.mergeSortedInPlace();
		for(int i: mer.arr1)
			System.out.print(i + " ");
		
		for(int i: mer.arr2)
			System.out.print(i + " ");
	}
}
