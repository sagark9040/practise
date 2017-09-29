package src.amz.sde;

public class FindAllPalindromesOfGivenString {

	public static void main(String args[]){
		
		String normalString = "abc";
		String emptyString = "";
		String repeatChars = "google";
		
		findAllPalindromes(normalString);
		//findAllPalindromes(emptyString);
		//findAllPalindromes(repeatChars);
	}
	
	static void findAllPalindromes(String orig){
		
		for(int i=0; i<orig.length(); i++){
			char ch = orig.charAt(i);
			
			for(int j=0; j<orig.length(); j++) {
				String first = orig.substring(0, i) + ch + orig.substring(j, orig.length());
				System.out.println(first);
			}
		}
	}	
}
