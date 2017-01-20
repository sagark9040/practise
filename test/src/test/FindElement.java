package test;

public class FindElement {
	
	public static int findElement (String[] arr, int low, int high, String search) {
		int mid = -1;
		while (low < high) {

			//Find the middle element in the array
			mid = (low + high)/2;

			/*Check for space in the middle element
			As long as the middle element continues to be a space,
			keep looking backwards*/
			while (arr[mid].length()==0 && mid>0 && mid<arr.length) 
				mid--;

			if (arr[mid].equals(search))
				return mid;

			if (arr[mid].compareTo(search) > 1)
				high = mid-1;
				//findElement(arr, low, mid-1, search);
			else
				low = mid+1;
				//findElement(arr, mid+1, high, search);

		}
		return -1;
	}

	//TC
	public static void main (String args[]) {
		String arr[] = {"","aba","abd","","cd","ef","",""};

		//TC
		//String arr[] = {"","aba","abd","","cd","ef","","","","","","","","","",""};
	
		/*TC
		String arr[] = {"","","","","","","","","","aba","abd","","cd","ef","",""};
	
		*///TC
		//String arr[] = {"aba","abd","cd","ef","gh","yz"};
	
		/*TC
		String arr[] = {"","","","","","","",""};*/
		
		System.out.println(findElement (arr, 0 , arr.length-1, "aba"));
		
	}
	
}
