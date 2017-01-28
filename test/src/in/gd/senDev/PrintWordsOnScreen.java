package in.gd.senDev;

public class PrintWordsOnScreen {

	public static int countSentences(String[] sentence, int row, int col){
		
		// Initialize to point to first word in the sentence
		
		int wordPosition = 0;
		String curWord = sentence[wordPosition];
		int curWordLen = curWord.length();
		
		int totalWordCount = 0;
		
		for(int r=0; r<row; r++) {
			
			int remainingCount = col;
			curWord = sentence[wordPosition];
			curWordLen = curWord.length();
			
			while (curWordLen <= remainingCount) {
				
				// Increment the total num of word
				
				remainingCount -= curWordLen;
				totalWordCount++; 
				wordPosition++;
				System.out.print(curWord);
				
				// Prevent array out of bound
				if (wordPosition == sentence.length)
					wordPosition = 0;
				
				// If the word leaves no space at the end of the row
				if (remainingCount > 0) {
					remainingCount--;
					System.out.print(" ");
				}
				
				// get the next word and its length
				curWord = sentence[wordPosition];
				curWordLen = curWord.length();
				
			}
			
			System.out.println();
			
		}
		
		return totalWordCount / sentence.length;
		
	}
	
	public static void main(String args[]) {
		
		String[] sentence = {"My", "name", "is", "Sagar"};
		System.out.println(countSentences(sentence, 6, 10));
		
	}
	
}
