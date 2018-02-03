package leet.bit;

public class LC393M_UTF8Validation {
	// DIDN'T UNDERSTAND THE QUESTION!!!!!!
    //                                          note
    // I was on the right track. Instead of string, using ints for the original solution
    // This qtn was simple enough but didn't understand the statement, should ask for clarifications.
    // Need to know bit manip or at least think about it more.
    
    // start from right and move left
    // first init numBytes = 0
    // while data
    //      if numBytes = 0:
    //          getNumBytes 
    //      checkValid(data[i], numBytes)
    //      reduceBytes   

    public boolean validUtf8(int[] data) {
        if(data == null || data.length == 0)    return false;
        boolean isValid = true;
        for(int i=0; i<data.length; i++) {
            int numOfBytes = 0;
            if((data[i] & 128) == 0) {
			    numOfBytes = 1;
            } else if((data[i] & 224) == 192) {
                numOfBytes = 2;
            } else if((data[i] & 240) == 224) {
                numOfBytes = 3;
            } else if((data[i] & 248) == 240) {
                numOfBytes = 4;
            } else {
                return false;
            }
            for(int j=1;j<numOfBytes;j++) {
                if(i+j>=data.length) return false;
                if((data[i+j] & 192) != 128) return false;
            }
            i=i+numOfBytes-1;
        }
        return isValid;
    }
}
