package fb.se.string;

public class AllPermutationsOfString {

	static void permutation(String str) {
		permutations(str, "");
	}
		
	// CTCI method
	// Would show duplicates if string contains repeat characters
	// One by one get a single character out from 0 to n-1. 
	// Create a prefix += the character in the ith position -> 0 to n-1
	// Whatever remains is the substring (0 to i) and (i+1) till end.
	
	static void permutations(String str, String prefix){
		if(str.length()==0)
			System.out.println(prefix);
		else{
			for(int i=0; i<str.length(); i++){
				String rem = str.substring(0,i) + str.substring(i+1);
				permutations(rem, prefix+str.charAt(i));
			}
		}
	}
	
	public static void main(String args[]){
		
		String str = "abc";
		permutation(str);
		
	}
}
