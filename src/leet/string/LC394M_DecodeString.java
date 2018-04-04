package leet.string;

public class LC394M_DecodeString {
	
	// 25 min AC 
	
	// String manipulation - recursion, overflows, substrings, char to number conversion	
	
	//Thinking of stacks or recursion
	//a3[c] = accc
	//2[ac] = acac
	// ac = ac
	// bracket mismatch?

	//  for entire string  
	//	      if(char) then just add to result
	//	      else if open bracket
	//	          while diff = 0 && within bounds
	//	              result += (multiplier * from first open till the diff = 0 i.e. what ever is in between) 
	//
	
	
	public String decodeString(String s) {
	    if(s.length() == 0) return "";
	    StringBuilder result = new StringBuilder();

	    int pos=0;
	    while(pos < s.length()) {
	        int multiplier = 0;

	        if((s.charAt(pos) >= 'A' && s.charAt(pos) <= 'Z') || (s.charAt(pos) >= 'a' && s.charAt(pos) <= 'z')) {
	            result.append(s.charAt(pos));
	            pos++;
	        }   
	        else if(s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
	            int numPos = pos;
	            while(pos < s.length() && s.charAt(pos) != '[') {
	                pos++;
	            }
	            multiplier = Integer.parseInt(s.substring(numPos, pos));

	            int diff = 1, subStringPos = pos+1;
	            pos=subStringPos;
	            while (diff != 0 && pos < s.length()) {
	                if(s.charAt(pos) == ']') {
	                    diff--;
	                } else if(s.charAt(pos) == '[') {
	                    diff++;
	                }
	                pos++;
	            }

	            for(int i=0; i<multiplier; i++) {
	                result.append(decodeString(s.substring(subStringPos, pos-1)));
	            }
	        }
	    }
	    return result.toString();
	}
	
	public static void main(String args[]) {
		String S = "2[2[b]ac]";
		LC394M_DecodeString ds = new LC394M_DecodeString();
		System.out.println(ds.decodeString(S));
		
	}
}
