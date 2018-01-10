package leet.string;

public class LC161M_OneEditDistance {
	 
    //1020 pm
    //One edit could be - either insert, update or delete only once. 

    //Base: Any case with length difference more than 1 is a false;
    //Base: If one or both are empty or null
    
    //Can treat insert and delete the same way. Meaning insert for one is deletion if swapped. 
	//So swap and keep smaller in s and larger in t, always.
    
    public boolean isOneEditDistance(String s, String t) {
        
        if( (s.length() == 0 && t.length() == 1) ||
            (s.length() == 1 && t.length() == 0))
            return true;
        
        // THIS IS A CLEVER WAY TO CIRCUMVENT THE LENGTH ISSUE        
        if(s.length() > t.length())
            return isOneEditDistance(t, s);
        
        boolean sameDist = (s.length() == t.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sameDist) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
	
    	return s.length() + 1 == t.length() || t.length() + 1 == s.length();
    }
    
    public static void main(String args[]) {
    	LC161M_OneEditDistance oneEdit = new LC161M_OneEditDistance();
    	
    	System.out.println(oneEdit.isOneEditDistance("a", "ac"));
//    	System.out.println(oneEdit.isOneEditDistance("", "sagar"));
//    	System.out.println(oneEdit.isOneEditDistance("", null));    	
//    	System.out.println(oneEdit.isOneEditDistance("sgar", "sagar"));
//    	System.out.println(oneEdit.isOneEditDistance("sagar", "sagr"));
//    	System.out.println(oneEdit.isOneEditDistance("sagar", "sagrs"));
    }
}
