package leet.string;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        s = s.trim().replaceAll(" +", " ");
    	
    	if(s.length() < 2)
    		return s;
    	
        char[] sArray = s.toCharArray();
        
        for(int i=0; i<s.length()/2; i++){
        	char temp = sArray[i];
        	sArray[i] = sArray[s.length()-1-i];
        	sArray[s.length()-1-i] = temp;
        }
        
        int firstChar = 0, curChar = 1;
        boolean lastCharIsSpace = false; 
        
        while(curChar<sArray.length){
        	char curCharValue = sArray[curChar];
        	
        	if(sArray[curChar] == ' ' && !lastCharIsSpace){
        		
        		sArray = swap(sArray, firstChar, curChar-1);
        		lastCharIsSpace = true;
        		
        	} else if(sArray[curChar] != ' '){
        		if(lastCharIsSpace){
        			firstChar = curChar;
        			lastCharIsSpace = false;
        		}
        	}

        	curChar++;
        }
        
        sArray = swap(sArray, firstChar, curChar-1);
        
        return String.valueOf(sArray);
    }
	
	private static char[] swap(char[] sArray, int firstChar, int lastChar) {
		if(sArray.length < 2)
			return sArray;
		
		int mid = (firstChar+lastChar)/2;
		int end = lastChar;
		for(int start = firstChar; start <= mid; start++){
			char temp = sArray[start];
			sArray[start] = sArray[end];
			sArray[end] = temp;
			end--;					
		}
		
		return sArray;
	}

	public static void main(String args[]){
		
		String str = "   a   b "; //" "; //"    "; //" baseball  alphabet"
		System.out.println("-->" + str + "<--");
		System.out.println("-->" + reverseWords(str) + "<--");
	}
	
}
