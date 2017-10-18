package leet.string;

public class LC125M_StringValidPalindrome {

	// TCs
	
	// Empty string
	// Single letter
	// Single non-letterOrNumber
	// Regular input with non-letterOrNumber
	// Regular with letters and numbers
	
	

	public boolean isPalindrome(String s){
		s = formatString(s);
        
		if(s.length() < 2)
			return true;
        //
        //0-3, 1-2
        //0-4, 1-3 2
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1))
                return false;
        }        
        
        return true;
	}
	
	private String formatString(String s) {
        s = s.trim().toLowerCase();		
		s = removeSpacesAndSpecialCharacters(s);
		return s;
	}

	private String removeSpacesAndSpecialCharacters(String s) {
		StringBuilder strBld = new StringBuilder();
		for(Character c: s.toCharArray()){
			if((c>='A' && c<='Z') || (c>='a' && c<= 'z') || (c>='0' && c<='9')){
				strBld.append(c);
			}			
		}		
        return strBld.toString();
	}

	public static void main(String args[]){
		LC125M_StringValidPalindrome palindrome = new LC125M_StringValidPalindrome();
		System.out.println(palindrome.isPalindrome("0p"));
	}
	
}
