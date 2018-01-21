package leet.array;

public class LC418M_CountSentencesScreenFitting {
	    // empty rows or cols then return 0, empty sentence return 0
	    // count the number of words put on screen, then divide it with sentence length to get the totalSentences
	    // iterate row by row. every row start has a balance cols = cols, we go on reducing it.
	    // last word on a line does not need to have space if it balCols = 0
	    
	    //7c 4r Sam I am
	    //Sam_I__
	    //am_Sam_
	    //I_am___
	    
	    
    public int wordsTyping(String[] sentence, int rows, int cols) {
        // base cases
        if(sentence == null || sentence.length == 0 || rows == 0 || cols == 0)
            return 0;
        
        int curWordPtr = 0, countWords = 0;
        
        for(int r=0; r<rows; r++) {
            int balCols = cols;
            
            //There's space left and the word fits within that.
            while (balCols > 0 && sentence[curWordPtr].length() <= balCols) {
                balCols -= sentence[curWordPtr++].length();
                countWords++;
                
                if(curWordPtr >= sentence.length)
                    curWordPtr = 0;

                balCols--;
            }            
        }
        return countWords/sentence.length;
    }
    
    public static void main(String args[]) {
    	LC418M_CountSentencesScreenFitting count = new LC418M_CountSentencesScreenFitting();
    	// System.out.println(count.wordsTyping(new String[] {"sam",  "i",  "am"}, 4, 7));
    			
    	System.out.println(count.wordsTyping(new String[] {"a","b","e"}, 20000, 20000));
    }
}

	