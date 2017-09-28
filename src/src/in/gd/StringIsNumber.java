package src.in.gd;

public class StringIsNumber {
	static boolean isNumber(String str)
	{

	 str.trim(); // remove leading and trailing spaces.
	  
	  int i=0; 
	  boolean dec=false; //is decimal?
	  char[] stringChars = str.toCharArray();
	  for(char c:stringChars)
	  {
	    if(c == '-' || c == '+'){
	       if(i!=0) return false;
	       
	       if(str.length()==1)
	    	   return false;
	      
	    }
	   else if(c == '.'){
	     if(dec) 
	        return false; //we can have only one decimal point in a number
	     else 
	        dec = true;
	   
	     if(i == str.length()-1)  // make sure decimal is not last char in the string
	        return false; 
	   }
	   else if(str.charAt(i) < '0' || str.charAt(i)>'9') return false;
	   i++;
	  }
	  
	  return true;
	}
	
	public static void main (String args[]) {
		String str = "";
//		str = "+";
//		System.out.println(str + String.valueOf(isNumber(str)));
//		str = "1+";
//		System.out.println(str + String.valueOf(isNumber(str)));

		
		
		str = "+1";
		System.out.println(str + String.valueOf(isNumber(str)));
		str = "1.0";		
		System.out.println(str + String.valueOf(isNumber(str)));
	}
}
