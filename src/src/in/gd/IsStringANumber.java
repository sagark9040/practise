package src.in.gd;

public class IsStringANumber {

	static boolean isNumber(String st)
	{
		
		
		
	 char[] str = st.trim().toCharArray(); // remove leading and trailing spaces.
	  
	  boolean dec=false; //is decimal?
	  for(int i=0; i<str.length; i++)
	  {
	    if(str[i] == '-' || str[i] == '+'){
	       if(i!=0) return false;
	    }
	   else if(str[i] == '.'){
	     if(dec) 
	        return false; //we can have only one decimal point in a number
	     else 
	        dec = true;
	   
	     if(i==(str.length-1))  // make sure decimal is not last char in the string
	        return false; 
	   }
	   else if(str[i] < '0' || str[i]>'9') {
		   char c = str[i];
		   return false;
		   
	   }
	   
	  }
	return true;
	}

	public static void main(String args[]) {
		System.out.println(isNumber("1.0001"));
		System.out.println(isNumber("1.000-"));
		System.out.println(isNumber("0000"));
		System.out.println(isNumber("1abced0"));
		System.out.println(isNumber("10"));
		System.out.println(isNumber("abcd"));
		System.out.println(isNumber("+123456"));
		System.out.println(isNumber("1e10001"));
		System.out.println(isNumber("+1"));
		System.out.println(isNumber("1+"));
	}
}
