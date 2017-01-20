package test;

public class SentenceOnScreen {

	static int repeatedSentence(String sentence, int M, int N) throws Exception { // 5x5 - I ate an
		// apple
		if (sentence == null || sentence.length() == 0) // Error case
			throw new Exception("String was empty");

		int countWords = 0;
		String[] words = sentence.split(" ");
		int widthRow = N, i = 0, j = 0, pos = 0;
		for (i =0; i < M; i++) {
			// check remaining slots
			// Wid: 5, cur elem = 2 → ”A ate“2: Wid (5) - len occupied (2)=3
			j=0;
			while (words[pos].length() <= (widthRow - j) && j < N) {
				
//				String curWord = words[pos]; // A

				countWords++; // 1
				j = j + words[pos].length(); // A_ j->0-4

				System.out.print(words[pos]+" ");
				
				
				j = j + 1; // adding that space to a non-complete row
				pos++;
				
				if (pos >= words.length)
					pos = 0;
				
				
			}
			
			System.out.println();
		}

		int countSent = countWords / words.length;
		return countSent;
	}
	
	static int repeatedSentenceOrig(String sentence, int M, int N) throws Exception{ //5x5 - I ate an apple
		if (sentence == null || sentence.length()==0) //Error case
			throw new Exception ("String was empty");

		int countWords = 0; 
		String[] words = sentence.split(" ");
		int widthRow = N, i=0, j=0, pos=0;  
		
		while(i<M){
			 j=0;
			//check remaining slots
			//Wid: 5, cur elem = 2 → ”A ate“2: Wid (5) - len occupied (2)=3
					while (words[pos].length() <= (N-j) && j<M) {
						if (pos>=words.length)
							pos = 0;
						int slotsRem = N - j; 
						//curWord = words[pos]; //A

			countWords++; //1
			j = j+words[pos].length(); //A_ j->0-4

			if (j>=N) { //Don’t overflow the row 
			j = 0; // adding space if j is not the last word
			i++; // go to next row
			pos++;	
			continue;
			} 

			j = j+1; //adding that space to a non-complete row
			pos++;
			
			if(pos == words.length)
			pos = 0;
			}
			i++;
			}
		System.out.println(countWords);
		int countSent = countWords / words.length;
		return countSent;
	}
	
	/*
	 
	 while(i<M){
	 j=0;
	//check remaining slots
	//Wid: 5, cur elem = 2 → ”A ate“2: Wid (5) - len occupied (2)=3
			while (word[pos].length() <= (N-j) && j<M) {
				if (pos>=words.length())
					pos = 0;
				int slotsRem = N - j; 
				curWord = words[pos]; //A

	countOfWords++; //1
	j = j+word[pos].length(); //A_ j->0-4

	if (j>=N) { //Don’t overflow the row 
	j = 0; // adding space if j is not the last word
	i++; // go to next row
	pos++;	
	continue;
	} 

	j = j+1; //adding that space to a non-complete row
	pos++;
	
	if(pos == words.length)
	pos = 0;
	}
	i++;
	}

		int countSent = countWords/words.length();
		return countSent;
	 
	 */
	
	public static void main(String args[]){
		try {
			System.out.println(repeatedSentenceOrig("This is a test", 10, 10));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
