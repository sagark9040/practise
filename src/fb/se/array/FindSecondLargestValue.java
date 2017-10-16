package fb.se.array;

public class FindSecondLargestValue {

	//TCs
	//1--> Only one value
	//2--> Zero values
	//3--> All values are the same
	//4--> Normal array
	//
	int[] arr;
	
	FindSecondLargestValue(int[] arr){
		this.arr = arr;
	}
	
	public int secondLargestValue(int[] arr){
		if(arr.length < 2)
			return Integer.MIN_VALUE;
		
		int largest = arr[0], secondLargest = Integer.MIN_VALUE;		
		
		for(int i=1; i<arr.length; i++){
			int curVal = arr[i];
			
			if(curVal == largest || curVal == secondLargest)
				continue;
			else if(curVal > largest){
				secondLargest = largest;
				largest = curVal;
			} else if(curVal > secondLargest && curVal != largest){
				secondLargest = curVal;
			}			
		}
		
		return largest != secondLargest ? secondLargest : Integer.MIN_VALUE;
	}
	
	public void secondLargestValue(){
		int secLargest = secondLargestValue(this.arr);
		
		if(secLargest != Integer.MIN_VALUE)
			System.out.println(secLargest);
		else
			System.out.println("Something wrong with the array.");
	}
	
	public static void main(String args[]){
		int[] oneVal = {1};
		int[] twoVal = {1,2};
		int[] zeroVal = {};
		int[] normal = {3,4,5,1,2};
		int[] duplicates = {5, 5, 4, 4, 3, 3};
		int[] duplicatesReverse = {3, 3, 4, 4, 5, 5};
		
		FindSecondLargestValue findSecondLargest = new FindSecondLargestValue(zeroVal);
		findSecondLargest.secondLargestValue();
		
		findSecondLargest = new FindSecondLargestValue(oneVal);
		findSecondLargest.secondLargestValue();
		
		findSecondLargest = new FindSecondLargestValue(twoVal);
		findSecondLargest.secondLargestValue();
		
		findSecondLargest = new FindSecondLargestValue(normal);
		findSecondLargest.secondLargestValue();
		
		findSecondLargest = new FindSecondLargestValue(duplicates);
		findSecondLargest.secondLargestValue();
		
		findSecondLargest = new FindSecondLargestValue(duplicatesReverse);
		findSecondLargest.secondLargestValue();
	}
	
}
