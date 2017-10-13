package fb.se.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AllPermutationsOfString {

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	
	static void permutation(String str) {
		permutations(str, "");
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Tushar Roy method (handles duplicate characters as well
	//Create an array of size of string
	//Create a map of character count and convert it to array of character,integer
	//Keep adding characters to the result and increment the resultset
	
	Map<Character, Integer> characterCount = new HashMap<Character, Integer>();
	int[] count;
	char[] characters;
	
	void createArray(String str){
		for(Character c: str.toCharArray()){
			if(characterCount.containsKey(c))
				characterCount.put(c, characterCount.get(c)+1);
			else
				characterCount.put(c, 1);
		}
		
		count = new int[characterCount.size()];
		characters = new char[characterCount.size()];
		int i=0;
		
		for(Entry<Character, Integer> entry: characterCount.entrySet()){
			count[i] = entry.getValue();
			characters[i] = entry.getKey();
			i++;
		}
	}
	
	void allPermutationsWithRepeatCharacters(String str, char[] result, int level){
		if(level == str.length()){
			System.out.println(result);
			return;
		}
		
		for(int i=0; i<count.length; i++){
			if(count[i] == 0)
				continue;
			result[level] = characters[i];
			count[i]--;
			allPermutationsWithRepeatCharacters(str, result, level+1);
			count[i]++;			
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String args[]){
		
		String strUnique = "abc";
		System.out.println("All permutations of unique character string --> " + strUnique); 		
		permutation(strUnique);
		
		AllPermutationsOfString allPerm = new AllPermutationsOfString();
		String strWithDups = "aabc";
		allPerm.createArray(strWithDups);		
		char[] result = new char[strWithDups.length()];
		System.out.println("\nAll permutations of duplicate character string --> " + strWithDups);
		allPerm.allPermutationsWithRepeatCharacters("aabc", result, 0);
		
	}
}
